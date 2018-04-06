package arduinocontrolapp;

import control.ConnectionControler;
import control.ProgramController;
import model.Connection;
import model.InstructionTree;
import model.Program;
import view.MainFrame;


public class ArduinoControlApp {

    public static void main(String[] args) {
        Connection connection = new Connection();
        new MainFrame(new ConnectionControler(connection), new InstructionTree().getModel(), new ProgramController(connection), new Program()).setVisible(true);
    }
 
}
