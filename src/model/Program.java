package model;

import javax.swing.DefaultListModel;

public class Program {
    private final DefaultListModel<Instruction> instructions;
    private final Connection connection;

    public Program(Connection connection) {
        this.connection = connection;
        instructions = new DefaultListModel<>();
    }
    
    public void addInstruction(Instruction ins){
        instructions.addElement(ins);
    }
    public void deleteInstruction(int pos){
        instructions.remove(pos);
    }
    public DefaultListModel getInstructions(){
        return instructions;
    }
    public void run(){
        new Thread(new ExecThread()).start();
    }
    class ExecThread implements Runnable{
        @Override
        public void run() {
            for (Object inst : instructions.toArray()) {
                Instruction test = (Instruction)inst;
                connection.sendData(test.getExecuteCommand());
                if(!connection.receiveData().equals("!AK")){
                    break;
                }
            }
        }
    
    }
}
