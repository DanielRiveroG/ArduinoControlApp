package arduinocontrolapp;

import java.util.ArrayList;
import model.Instruction;
import view.MainFrame;

public class ArduinoControlApp {

    public static void main(String[] args) {
        ArrayList<Instruction> set = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            set.add(new Instruction("Instrucción " + i));
        }
        new MainFrame(set).setVisible(true);
    }
    
}
