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
            if(arguments[i] == null){
                break;
            }
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
                result = ">> Variable " + arguments [0];
                if(arguments[1].equals("0")){
                    result = result + " = " + arguments[2];
                }else if(arguments[1].equals("1")){
                    result = result + " = Pin digital " + arguments[2]; 
                }else if(arguments[1].equals("2")){
                    result = result + " = Pin analógico " + arguments[2];
                }else if(arguments[1].equals("3")){
                    result = result + " = byte ";
                }
                break;
            case 10:
                result = "Subrutina " + label;
                break;
            case 11:
                result = ">>" + name + " " + label;
                break;
            case 13:
                result = ">>Salto a subrutina " + arguments[1] + " si " + arguments[0] + " " + arguments[3] + " " + arguments[2];
                break;
            case 14:
                result = ">>" + name + " " + arguments[0] + " = " + arguments[1];
                break;
            case 15:
                result = ">>" + name + " - Pin " + arguments[0] + " - Valor " + arguments[1];
                break;
            case 16:
                result = (arguments[2].equals("0"))? ">>" + name + " " + arguments[0] + " < " + arguments[1] : ">>" + name + " " + arguments[0] + " > " + arguments[1];
                break;
            case 17: 
                result = ">>" + name + " a " + arguments[0] + " kPa";
                break;
            case 18:
                result = ">>" + name;
                break;
        }
        return result;
    }
    
}
