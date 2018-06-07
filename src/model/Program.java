package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Program {
    private DefaultListModel<Instruction> instructions;
    private final Connection connection;
    private boolean stopFlag;
    private boolean runningFlag;
    private int size;
    private Map<String, Double> dreg = new HashMap<String, Double>();
    private Map<String, Integer> ireg = new HashMap<String, Integer>();
    private Map<String, Double> rreg = new HashMap<String, Double>();

    public Program(Connection connection) {
        this.connection = connection;
        instructions = new DefaultListModel<>();
        stopFlag = false;
        runningFlag = false;
        initProgram();
    }
    
    private void initProgram(){
        instructions.addElement(new Instruction("<START>", "", -1));
        instructions.addElement(new Instruction("<FINISH>", "", -1));
        size = 1;
    }
    
    public void save(File file) throws IOException{
        String json = new Gson().toJson(instructions);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json, 0, json.length());
        }
    }
    
    public void load(File file) throws FileNotFoundException, IOException{
        java.lang.reflect.Type listType = new TypeToken<DefaultListModel<Instruction>>(){}.getType();
        String json;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            json = reader.readLine();
        }
         DefaultListModel<Instruction> loaded = new Gson().fromJson(json, listType);
         for (Object inst : loaded.toArray()) {
             Instruction aux = (Instruction)inst;
             addInstruction(aux, -1);
         }
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public boolean isRunningFlag() {
        return runningFlag;
    }
    
    public void clear(){
        int realSize = instructions.getSize();
        for (int i = 0; i < realSize; i++) {
            instructions.remove(0);
        }
        initProgram();
    }
    
    public void addInstruction(Instruction ins, int pos){
        switch (pos) {
            case -2:
                instructions.add(size+1, ins);
                instructions.add(size+2, new Instruction("RETURN", "$XX", -1));
                size--;
                break;
            case -1:
                instructions.add(size, ins);
                break;
            case 0:
                instructions.add(1, ins);            
                break;
            default:
                instructions.add(pos, ins);
                break;
        }
        size++;
    }
    public void deleteInstruction(int pos){
        if(instructions.get(pos).getName().equals("<START>") || instructions.get(pos).getName().equals("<FINISH>")){
            JOptionPane.showMessageDialog(null, "No se pueden borrar las etiquetas de inicio y fin de programa", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        instructions.remove(pos);
        size--;
    }
    public DefaultListModel getInstructions(){
        return instructions;
    }
    public void run(){
        if(!connection.getConectionState()){
            JOptionPane.showMessageDialog(null, "No se puede ejecutar el programa si no hay hardware conectado", "Atención", JOptionPane.WARNING_MESSAGE);
        }else{
            new Thread(new ExecThread()).start();
        }
    }
    
    
    class ExecThread implements Runnable{
        
        
        public ExecThread() {
            
        }

        private int findLabel(String label){
            int res = 0;
            for (Object inst : instructions.toArray()) {
                Instruction test = (Instruction)inst;
                if(test.getInstructionType() == 5 && test.getLabel().equals(label)){
                    return res;
                }
                res++;
            }
            return -2;
        }

        private String sendAndReceive(Instruction inst, boolean receive){
            String response = "";
            connection.sendData(inst.getExecuteCommand());
            response = connection.receiveData();
            while(response.equals("")){
                response = connection.receiveData();
            }
            if(!response.equals("!AK")){
                JOptionPane.showMessageDialog(null, "Ejecución Abortada", "Error", JOptionPane.ERROR_MESSAGE);
                return "abort";
            }
            if(receive){
                response = "";
                while(response.equals("")){
                    response = connection.receiveData();
                }   
                return response;
            }
            return response;
        }

        private int checkJump(Instruction inst){
            String variable = inst.getArguments()[0];
            String label = inst.getArguments()[1];
            String comparer = inst.getArguments()[3];
            Double value = Double.parseDouble(inst.getArguments()[2]);
            if(dreg.get(variable) != null){
                if(checkCondition(dreg.get(variable),value , comparer)) return findLabel(label);
                return -1;
            }else if(ireg.get(variable) != null){
                if(checkCondition(dreg.get(variable),value , comparer)) return findLabel(label);
                return -1;
            }else if(rreg.get(variable) != null){
                if(checkCondition(dreg.get(variable),value , comparer)) return findLabel(label);
                return -1;
            }
            return -2;
        }

        private boolean checkCondition(Double variable, Double value, String comparer){
            switch(comparer){
                case "=":
                    if(Double.compare(variable, value) == 0) return true;
                    return false;
                case ">":
                    if(Double.compare(variable, value) > 0) return true;
                    return false;
                case "<":
                    if(Double.compare(variable, value) < 0) return true;
                    return false;
            }
            return false;
        }

        @Override
        public void run() {
            dreg.clear();
            runningFlag = true;
            System.out.println("Inicio del programa");
            String response;
            for (int i = 0; i < instructions.size(); i++) {
                if(stopFlag){
                    stopFlag = false;
                    break;
                }
                Instruction current = instructions.get(i);
                if(current.getName().equals("<FINISH>")){
                    break;
                }
                if(current.getCommand().equals("$XX")){
                    switch(current.getInstructionType()){
                        case 5:
                            break;
                        case 6:
                            String[] args = current.getArguments();
                            try {
                                TimeUnit.MILLISECONDS.sleep(Integer.parseInt(args[0]));
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 7:
                            i = findLabel(instructions.get(i).getLabel());
                            if(i == -2){
                                JOptionPane.showMessageDialog(null, "Error en el salto, ejecución abortada", "Error", JOptionPane.ERROR_MESSAGE);
                                runningFlag = false;
                                return;
                            }
                            break;
                        case 8:
                            int tmp = checkJump(current);
                            if(tmp == -1){
                                System.out.println("No se cumple salto");
                                break;
                            }else if(tmp == -2){
                                JOptionPane.showMessageDialog(null, "Error en el salto, ejecución abortada", "Error", JOptionPane.ERROR_MESSAGE);
                                runningFlag = false;
                                return;
                            }else{
                                i = tmp;
                            }
                            break;
                        case 9:
                            if(current.getArguments()[1].equals("0")){
                                dreg.put(current.getArguments()[0], Double.parseDouble(current.getArguments()[2]));
                            }else{
                                String[] arg = {current.getArguments()[2]};
                                String res = sendAndReceive(new Instruction("Entrada Binaria Bit","$IB",0,arg), true);
                                System.out.println(res);
                                dreg.put(current.getArguments()[0], Double.parseDouble(res.substring(4, res.length())));
                            }
                    }

                }else{
                    response = sendAndReceive(current, false);
                    if(response.equals("abort")) break;
                }
            }
            runningFlag = false;
            System.out.println("Fin del programa");
        }
    }

}
