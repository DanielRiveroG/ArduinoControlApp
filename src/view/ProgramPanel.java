package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProgramPanel extends JPanel {

    public ProgramPanel() {
        JLabel filler = new JLabel("Panel del programa");
        filler.setHorizontalAlignment(JLabel.CENTER);
        setLayout(new GridLayout(1, 1));
        add(filler);
    }
    
}
