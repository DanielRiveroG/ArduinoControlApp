package control;

import java.io.File;
import javax.swing.JFileChooser;
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
    
    public void executeProgram(){
        this.program.run();
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

    public void saveProgram() {
        JFileChooser fileChooser = new JFileChooser();
        int selection = fileChooser.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            program.save(fileToSave);
        }
    }
    
}
