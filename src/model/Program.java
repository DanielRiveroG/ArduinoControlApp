package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Program {
    private DefaultListModel<Instruction> instructions;
    private final Connection connection;
    private Map<String, Integer> dreg = new HashMap<String, Integer>();
    private Map<String, Integer> ireg = new HashMap<String, Integer>();
    private Map<String, Double> rreg = new HashMap<String, Double>();

    public Program(Connection connection) {
        this.connection = connection;
        instructions = new DefaultListModel<>();
    }
    
    public void save(File file) throws IOException{
        String json = new Gson().toJson(instructions);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json, 0, json.length());
        }
    }
    
    public void load(File file) throws FileNotFoundException, IOException{
        java.lang.reflect.Type listType = new TypeToken<DefaultListModel<Instruction>>(){}.getType();
        String json;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            json = reader.readLine();
        }
         DefaultListModel<Instruction> loaded = new Gson().fromJson(json, listType);
         for (Object inst : loaded.toArray()) {
             Instruction aux = (Instruction)inst;
             addInstruction(aux);
         }
    }
    
    public void clear(){
        int size = instructions.getSize();
        for (int i = 0; i < size; i++) {
            deleteInstruction(0);
        }
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
        if(!connection.getConectionState()){
            JOptionPane.showMessageDialog(null, "No se puede ejecutar el programa si no hay hardware conectado", "Atención", JOptionPane.WARNING_MESSAGE);
        }else{
            new Thread(new ExecThread(instructions, connection, dreg, ireg, rreg)).start();
        }
    }

}
