package model;

import javax.swing.DefaultListModel;

public class Program {
    private final DefaultListModel<Instruction> instructions;

    public Program() {
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
}
