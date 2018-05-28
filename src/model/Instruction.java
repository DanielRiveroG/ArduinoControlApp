package model;


public class Instruction{
    private final String name;
    private final String command;
    private final int instructionType;
    private int[] arguments;
    private String label;

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
    
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getExecuteCommand(){
        String result = command;
        for (int i = 0; i < arguments.length; i++) {
            result += " " + arguments[i];
        }
        result += "\n";
        return result;
    }
    @Override
    public String toString() {
        if(arguments == null && label == null){
            return name;
        }
        String result = "";
        switch(instructionType){
            case 0:
                result = ">>" + name + " - Pin " + arguments[0] + " - Valor " + arguments[1];
                break;
            case 1:
                result = ">>" + name + " - Valor " + arguments[0];
                break;
            case 2:
                result = ">>" + name + " - Valor " + arguments[0];
                break;
            case 3:
                result = ">>" + name + " - Pin " + arguments[0];
                break;
            case 4:
                break;
            case 5:
                result = label + ":";
                break;
            case 6:
                result =  ">>" + name + ": " + arguments[0] + " milisegundos";
                break;
            case 7:
                result = ">>" + name + " a " + label;
        }
        return result;
    }
    
}
