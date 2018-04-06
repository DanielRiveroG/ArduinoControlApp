package model;


public class Instruction{
    private final String name;
    private final String command;
    private final int instructionType;
    private int[] arguments;

    public Instruction(String name, String command, int instructionType) {
        this.name = name;
        this.command = command;
        this.instructionType = instructionType;
    }

    public Instruction(String name, String command, int instructionType, int[] arguments) {
        this.name = name;
        this.command = command;
        this.instructionType = instructionType;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public int getInstructionType() {
        return instructionType;
    }

    public int[] getArguments() {
        return arguments;
    }

    public void setArguments(int[] arguments) {
        this.arguments = arguments;
    }
    

    @Override
    public String toString() {
        if(arguments == null){
            return name;
        }
        String result = name;
        for (int i = 0; i < arguments.length; i++) {
            result += "-" + arguments[i];
            
        }
        return result;
    }
    
}
