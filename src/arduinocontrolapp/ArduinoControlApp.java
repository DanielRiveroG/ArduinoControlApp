package arduinocontrolapp;

import control.ConnectionControler;
import model.Connection;
import model.InstructionTree;
import view.MainFrame;


public class ArduinoControlApp {

    public static void main(String[] args) {
        new MainFrame(new ConnectionControler(new Connection()), new InstructionTree().getModel()).setVisible(true);
    }
 
}
