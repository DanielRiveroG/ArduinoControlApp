package arduinocontrolapp;

import control.ConnectionControler;
import java.util.ArrayList;
import model.Connection;
import model.Instruction;
import view.MainFrame;


public class ArduinoControlApp {

    public static void main(String[] args) {
        
        new MainFrame(new ConnectionControler(new Connection())).setVisible(true);
    }
    
}
