package control;

import java.util.concurrent.TimeUnit;
import model.Connection;

public class ConnectionControler {
    private final Connection connection;
    public ConnectionControler(Connection connection) {
        this.connection = connection;
    }
    public boolean establishConnection(String port) throws InterruptedException{
        connection.setPort(port);
        connection.initializeConection();
        TimeUnit.SECONDS.sleep(2);
        connection.sendData("%hl-");
        return connection.receiveData().equals("ok");
    }
}
