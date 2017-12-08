package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonitorPanel extends JPanel {

    public MonitorPanel() {
        JLabel filler = new JLabel("Panel de monitorización");
        filler.setHorizontalAlignment(JLabel.CENTER);
        setLayout(new GridLayout(1, 1));
        add(filler);
    }
    
}
