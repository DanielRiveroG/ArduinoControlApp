package model;


public class Instruction{
    private final String name;
    private final String command;

    public Instruction(String name, String command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
