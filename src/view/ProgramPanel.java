package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProgramPanel extends JPanel {

    public ProgramPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel instLabel = new JLabel();
        instLabel.setText("Seleccionar instrucción:");
        JLabel progLabel = new JLabel();
        progLabel.setText("Programa actual:");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(instLabel, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.NORTHEAST;
        add(progLabel, c);
        
        JButton boton = new JButton("Boton");
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(boton, c);
    }
    
}
