package arduinocontrolapp;

import java.util.ArrayList;
import model.Instruction;
import view.MainFrame;
import view.MonitorPanel;
import view.ProgramPanel;

public class ArduinoControlApp {

    public static void main(String[] args) {
        new MainFrame(new ProgramPanel(), new MonitorPanel()).setVisible(true);
    }
    
}
