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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Program {
    private DefaultListModel<Instruction> instructions;
    private final Connection connection;

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
            new Thread(new ExecThread()).start();
        }
    }
    class ExecThread implements Runnable{
        @Override
        public void run() {
            System.out.println("Inicio del programa");
            String response;
            for (int i = 0; i < instructions.size(); i++) {
                Instruction current = instructions.get(i);
                
                if(current.getCommand().equals("$XX")){
                    switch(current.getInstructionType()){
                        case 5:
                            break;
                        case 6:
                            int[] args = current.getArguments();
                            try {
                                TimeUnit.MILLISECONDS.sleep(args[0]);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 7:
                            i = findLabel(instructions.get(i));
                            if(i == -1){
                                JOptionPane.showMessageDialog(null, "Error en el salto, ejecución abortada", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }
     
                }else{
                    response = "";
                    connection.sendData(instructions.get(i).getExecuteCommand());
                    response = connection.receiveData();
                    while(response.equals("")){
                        response = connection.receiveData();
                    }
                    if(!response.equals("!AK")){
                        JOptionPane.showMessageDialog(null, "Ejecución Abortada", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            System.out.println("Fin del programa");
        }
        
        private int findLabel(Instruction jump){
            int res = 0;
            for (Object inst : instructions.toArray()) {
                Instruction test = (Instruction)inst;
                if(test.getInstructionType() == 5 && test.getLabel().equals(jump.getLabel())){
                    return res;
                }
                res++;
            }
            return -1;
        }
    
    }
}
