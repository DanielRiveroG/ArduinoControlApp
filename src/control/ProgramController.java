package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Connection;

public class ProgramController {
    private final Connection connection;

    public ProgramController(Connection connection) {
        this.connection = connection;
    }
    
    public void executeProgram(DefaultListModel program){
        new Thread(new ExecThread()).start();
    }
    
    class ExecThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Iteración: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgramController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
    
}
