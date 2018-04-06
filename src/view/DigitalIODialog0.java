package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DigitalIODialog0 extends JDialog{

    private ButtonGroup optionsGroup;
    private JButton acceptButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private JLabel numberLabel;
    private JLabel stateLabel;
    private JRadioButton offRadioButton;
    private JRadioButton onRadioButton;
    private int[] args;
    
    public DigitalIODialog0() {
        args = new int[2];
        initComponents();
    }
    
    public int[] showDialog() {
        this.setVisible(true);
        return args;
    }
    
    private void acceptButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        args[0] = (int) portSpinner.getValue();
        if(offRadioButton.isSelected()){
            args[1] = 0;
        }else{
            args[1] = 1;
        }
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
        stateLabel = new JLabel();
        offRadioButton = new JRadioButton();
        onRadioButton = new JRadioButton();
        acceptButton = new JButton();
        cancelButton = new JButton();
        optionsGroup = new ButtonGroup();
        
        this.setSize(new Dimension(250, 200));
        this.setTitle("Argumentos");
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setModal(true);

        numberLabel.setText("Seleccione el puerto:");
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

        stateLabel.setText("Estado de la Salida:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(stateLabel, gridBagConstraints);

        optionsGroup.add(offRadioButton);
        offRadioButton.setSelected(true);
        offRadioButton.setText("Apagada");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(offRadioButton, gridBagConstraints);

        optionsGroup.add(onRadioButton);
        onRadioButton.setText("Encendida");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(onRadioButton, gridBagConstraints);

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
    }
}
