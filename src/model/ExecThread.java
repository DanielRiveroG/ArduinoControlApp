package model;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

class ExecThread implements Runnable{
    private final DefaultListModel<Instruction> instructions;
    private final Connection connection;
    private Map<String, Double> dreg;
    private Map<String, Integer> ireg;
    private Map<String, Double> rreg;

    public ExecThread(DefaultListModel<Instruction> instructions, Connection connection, Map<String, Double> dreg, Map<String, Integer> ireg, Map<String, Double> rreg) {
        this.instructions = instructions;
        this.connection = connection;
        this.dreg = dreg;
        this.ireg = ireg;
        this.rreg = rreg;
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
        System.out.println("Inicio del programa");
        String response;
        for (int i = 0; i < instructions.size(); i++) {
            Instruction current = instructions.get(i);

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
        System.out.println("Fin del programa");
    }
}