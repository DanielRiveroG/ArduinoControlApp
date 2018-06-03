/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Daniel
 */
public class DigitalIODialog3 extends JDialog{

    private ButtonGroup optionsGroup;
    private JButton acceptButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private JSpinner timeSpinner;
    private JLabel numberLabel;
    private JLabel stateLabel;
    private JLabel timeLabel;
    private JRadioButton offRadioButton;
    private JRadioButton onRadioButton;
    private String[] args;
    
    public DigitalIODialog3() {
        args = new String[3];
        initComponents();
    }
    
    public String[] showDialog() {
        this.setVisible(true);
        return args;
    }
    
    private void acceptButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        args[0] = portSpinner.getValue().toString();
        if(offRadioButton.isSelected()){
            args[1] = "0";
        }else{
            args[1] = "1";
        }
        args[2] = timeSpinner.getValue().toString();
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
        timeLabel = new JLabel();
        portSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));
        timeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        stateLabel = new JLabel();
        offRadioButton = new JRadioButton();
        onRadioButton = new JRadioButton();
        acceptButton = new JButton();
        cancelButton = new JButton();
        optionsGroup = new ButtonGroup();
        
        this.setSize(new Dimension(300, 300));
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
        
        timeLabel.setText("Duración del pulso entre 0 y 999:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(timeLabel, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(timeSpinner, gridBagConstraints);

        acceptButton.setText("Aceptar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
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
        gridBagConstraints.gridy = 6;
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
