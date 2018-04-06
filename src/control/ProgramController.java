package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Connection;
import model.Instruction;
import model.Program;
import view.DigitalIODialog;

public class ProgramController {
    private final Connection connection;

    public ProgramController(Connection connection) {
        this.connection = connection;
    }
    
    public void executeProgram(DefaultListModel program){
        new Thread(new ExecThread()).start();
    }
    
    public void addInstruction(Instruction ins, Program prog){
        int[] result = new DigitalIODialog().showDialog();
        prog.addInstruction(new Instruction(ins.getName(),ins.getCommand(),ins.getInstructionType(),result));
    }
    
    public void deleteInstruction(int pos, Program prog){
        prog.deleteInstruction(pos);
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
