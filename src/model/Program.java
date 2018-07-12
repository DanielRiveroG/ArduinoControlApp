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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Program {
    private DefaultListModel<Instruction> instructions;
    private DefaultComboBoxModel<String> variableNames;
    private final Connection connection;
    private boolean stopFlag;
    private boolean runningFlag;
    private int size;
    private Map<String, Double> register = new HashMap<String, Double>();

    public Program(Connection connection) {
        this.connection = connection;
        instructions = new DefaultListModel<>();
        variableNames = new DefaultComboBoxModel<>();
        stopFlag = false;
        runningFlag = false;
        initProgram();
    }

    public int getSize() {
        return size;
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
        boolean finish = false;
        if(runningFlag){
            JOptionPane.showMessageDialog(null, "No se puede modificar el programa durante la ejecución", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        clear();
        instructions.remove(0);
        instructions.remove(0);
        size--;
        java.lang.reflect.Type listType = new TypeToken<DefaultListModel<Instruction>>(){}.getType();
        String json;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            json = reader.readLine();
        }
        DefaultListModel<Instruction> loaded = new Gson().fromJson(json, listType);
        for (Object inst : loaded.toArray()) {
            Instruction aux = (Instruction)inst;
            instructions.addElement(aux);
            if(aux.getName().equals("<FINISH>")){
                finish = true;
            }
            if(!finish){
                size++;
            }
        }
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public boolean isRunningFlag() {
        return runningFlag;
    }

    public Map<String, Double> getRegister() {
        return register;
    }
    
    public void clear(){
        if(runningFlag){
            JOptionPane.showMessageDialog(null, "No se puede modificar el programa durante la ejecución", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int realSize = instructions.getSize();
        for (int i = 0; i < realSize; i++) {
            instructions.remove(0);
        }
        initProgram();
    }
    
    public void addInstruction(Instruction ins, int pos){
        if(runningFlag){
            JOptionPane.showMessageDialog(null, "No se puede modificar el programa durante la ejecución", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        switch (pos) {
            case -2:
                instructions.add(size+1, ins);
                instructions.add(size+2, new Instruction("RETURN", "$XX", 12));
                size--;
                break;
            case -1:
                instructions.add(size, ins);
                break;
            case 0:
                instructions.add(1, ins);            
                break;
            default:
                if(pos > size){
                    size--;
                }
                instructions.add(pos, ins);
                break;
        }
        size++;
    }
    public void deleteInstruction(int pos){
        if(runningFlag){
            JOptionPane.showMessageDialog(null, "No se puede modificar el programa durante la ejecución", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
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

    public DefaultComboBoxModel<String> getVariableNames() {
        return variableNames;
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
        
        private int findSubroutine(String label){
            for (int i = size+1; i < instructions.getSize(); i++) {
                Instruction test = instructions.get(i);
                if(test.getInstructionType() == 10 && test.getLabel().equals(label)){
                    return i;
                }
            }
            return -2;
        }
        
        private String sendAndReceive(Instruction inst, boolean receive){
            String response = "";
            connection.sendData(inst.getExecuteCommand());
            response = connection.receiveData();
            while(response.equals("")){
                response = connection.receiveData();
                if(stopFlag){
                    break;
                }
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
            if(register.get(variable) != null){
                if(checkCondition(register.get(variable),value , comparer)) return findLabel(label);
                return -1;
            }
            return -2;
        }
        
        private int checkJumpSubroutine(Instruction inst){
            String variable = inst.getArguments()[0];
            String label = inst.getArguments()[1];
            String comparer = inst.getArguments()[3];
            Double value = Double.parseDouble(inst.getArguments()[2]);
            if(register.get(variable) != null){
                if(checkCondition(register.get(variable),value , comparer)) return findSubroutine(label);
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
           
            variableNames.removeAllElements();
            register.clear();
            runningFlag = true;
            int lastIndex = 0;
            int tmp = 0;
            System.out.println("Inicio del programa");
            String response;
            for (int i = 1; i < instructions.size(); i++) {
                if(stopFlag){
                    stopFlag = false;
                    break;
                }
                Instruction current = instructions.get(i);
                System.out.println(current.toString());
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
                            tmp = checkJump(current);
                            if(tmp == -1){
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
                            String[] arg = {current.getArguments()[2]};
                            if(current.getArguments()[1].equals("0")){
                                register.put(current.getArguments()[0], Double.parseDouble(current.getArguments()[2]));
                            }else if(current.getArguments()[1].equals("1")){
                                String res = sendAndReceive(new Instruction("Entrada Binaria Bit","$IB",0,arg), true);
                                register.put(current.getArguments()[0], Double.parseDouble(res.substring(4, res.length())));
                            }else if(current.getArguments()[1].equals("2")){
                                String res = sendAndReceive(new Instruction("Entrada Analogica","$AI",0,arg), true);
                                register.put(current.getArguments()[0], Double.parseDouble(res.substring(4, res.length())));
                            }else if(current.getArguments()[1].equals("3")){
                                String res = sendAndReceive(new Instruction("Entrada Byte","$IL",0,arg), true);
                                register.put(current.getArguments()[0], Double.parseDouble(res.substring(4, res.length())));
                            }
                            if(variableNames.getIndexOf(current.getArguments()[0]) == -1){
                                variableNames.addElement(current.getArguments()[0]);
                            }
                            break;
                        case 11:
                            lastIndex = i;
                            i = findSubroutine(instructions.get(i).getLabel());
                            if(i == -2){
                                JOptionPane.showMessageDialog(null, "Error en el salto, ejecución abortada", "Error", JOptionPane.ERROR_MESSAGE);
                                runningFlag = false;
                                return;
                            }
                            break;
                        case 12:
                            i = lastIndex;
                            break;
                        case 13:
                            tmp = checkJumpSubroutine(current);
                            if(tmp == -1){
                                break;
                            }else if(tmp == -2){
                                JOptionPane.showMessageDialog(null, "Error en el salto, ejecución abortada", "Error", JOptionPane.ERROR_MESSAGE);
                                runningFlag = false;
                                return;
                            }else{
                                i = tmp;
                            }
                            break;
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
