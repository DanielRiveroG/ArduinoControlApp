package model;

public class Instruction {

    String name;
    public Instruction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    
}
