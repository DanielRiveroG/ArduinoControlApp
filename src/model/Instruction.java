package model;


public class Instruction{
    private final String name;
    private final String command;
    private final int instructionType;
    private String[] arguments;
    private String label;

    public Instruction(String name, String command, int instructionType) {
        this.name = name;
        this.command = command;
        this.instructionType = instructionType;
    }

    public Instruction(String name, String command, int instructionType, String[] arguments) {
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

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
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
                result = ">>" + name + " - Pin " + arguments[0] + " - Valor " + arguments[1] + " - Tiempo " + arguments[2] + " milisegundos";
                break;
            case 5:
                result = label + ":";
                break;
            case 6:
                result =  ">>" + name + ": " + arguments[0] + " milisegundos";
                break;
            case 7:
                result = ">>" + name + " a " + label;
                break;
            case 8:
                result = ">> Salto a " + arguments[1] + " si " + arguments[0] + " " + arguments[3] + " " + arguments[2];
                break;
            case 9:
                result = (arguments[1].equals("0"))? ">> Variable booleana " + arguments[0] + " = " + arguments[2]:">> Variable booleana " + arguments[0] + " = Pin digital " + arguments[2];
        }
        return result;
    }
    
}
