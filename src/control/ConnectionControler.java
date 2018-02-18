package control;

import java.util.concurrent.TimeUnit;
import model.Connection;

public class ConnectionControler {
    private Connection connection;
    public ConnectionControler(Connection connection) {
        this.connection = connection;
    }
    public boolean establishConnection(String port) throws InterruptedException{
        connection.setPort(port);
        connection.initializeConection();
        TimeUnit.SECONDS.sleep(2);
        connection.sendData("%hl-");
        if(connection.receiveData().equals("ok")){
            return true;
        }else{
            return false;
        }
    }
    
}
