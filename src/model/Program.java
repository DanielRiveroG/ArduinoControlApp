package model;

import control.ProgramController;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }
    class ExecThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Iteración: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgramController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
}
