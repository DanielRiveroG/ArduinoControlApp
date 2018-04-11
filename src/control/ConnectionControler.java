package control;

import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import model.Connection;

public class ConnectionControler {
    private final Connection connection;
    public ConnectionControler(Connection connection) {
        this.connection = connection;
    }
    public boolean establishConnection() throws InterruptedException{
        String port = JOptionPane.showInputDialog("Indique el puerto al que está conectado el controlador:");
        connection.setPort(port);
        connection.initializeConection();
        if(!connection.getConectionState()){
            return false;
        }
        TimeUnit.SECONDS.sleep(2);
        connection.sendData("$HL\n");
        return connection.receiveData().equals("!AK");
    }
}
