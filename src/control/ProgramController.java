package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Instruction;
import model.Program;
import view.DigitalIODialog0;
import view.DigitalIODialog1;
import view.DigitalIODialog2;

public class ProgramController {
    private final Program program;

    public ProgramController(Program program) {
        this.program = program;
    }
    
    public void executeProgram(DefaultListModel program){
        new Thread(new ExecThread()).start();
    }
    
    public void addInstruction(Instruction ins){
        int type = ins.getInstructionType();
        int[] result = null;
        switch(type){
            case 0:
                result = new DigitalIODialog0().showDialog();
                break;
            case 1:
                result = new DigitalIODialog1(254).showDialog();
                break;
            case 2:
                result = new DigitalIODialog1(65534).showDialog();
                break;
            case 3:
                result = new DigitalIODialog2().showDialog();
                break;
        }
        if(result != null){
            program.addInstruction(new Instruction(ins.getName(),ins.getCommand(),ins.getInstructionType(),result));
        }
    }
    
    public void deleteInstruction(int pos){
        program.deleteInstruction(pos);
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
