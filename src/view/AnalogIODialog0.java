package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

public class AnalogIODialog0 extends JDialog{
    private JButton acceptButton;
    private JButton cancelButton;
    private JSpinner portSpinner;  
    private JSpinner valueSpinner;  
    private JLabel numberLabel;
    private JLabel stateLabel;
    private String[] args;
    
    public AnalogIODialog0() {
        args = new String[2];
        initComponents();
    }
    
    public String[] showDialog() {
        this.setVisible(true);
        return args;
    }
    
    private void acceptButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        args[0] = portSpinner.getValue().toString();
        args[1] = valueSpinner.getValue().toString();
        dispose();
    }
    
    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        args = null;
        dispose();
    }
    
    @SuppressWarnings("Convert2Lambda")
    private void initComponents(){
        GridBagConstraints gridBagConstraints;
        numberLabel = new JLabel();
        portSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));
        valueSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
        stateLabel = new JLabel();
        acceptButton = new JButton();
        cancelButton = new JButton();
        
        this.setSize(new Dimension(250, 200));
        this.setTitle("Argumentos");
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setModal(true);

        numberLabel.setText("Seleccione el pin:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(numberLabel, gridBagConstraints);

        JFormattedTextField tf = ((JSpinner.DefaultEditor) portSpinner.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(portSpinner, gridBagConstraints);

        stateLabel.setText("Valor de la Salida:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(stateLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(valueSpinner, gridBagConstraints);

        acceptButton.setText("Aceptar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 5);
        this.getContentPane().add(acceptButton, gridBagConstraints);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(cancelButton, gridBagConstraints);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        this.getRootPane().setDefaultButton(acceptButton);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
