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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author danie
 */
public class ConditionalJumpDialog extends JDialog{
    
    private JButton acceptButton;
    private JButton cancelButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField labelField;
    private JLabel labelLabel;
    private ButtonGroup optionsGroup;
    private JRadioButton equalsRadio;
    private JRadioButton greaterRadio;
    private JRadioButton lessRadio;
    private JLabel immediateLabel;
    private JLabel pinLabel;
    private JSpinner immediateSpinner;
    private JSpinner pinSpinner;
    private String[] result;
    
    public ConditionalJumpDialog() {
        result = new String[3];
        initComponents();
    }
    
    public String[] showDialog() {
        this.setVisible(true);
        return result;
    }
    
    private void acceptButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        if(nameField.getText().equals("")){
            result = null;
            dispose();
        }
        result[0] = nameField.getText();
        if(greaterRadio.isSelected()){
            result[1] = "0";
            result[2] = immediateSpinner.getValue().toString();
        }else{
            result[1] = "1";
            result[2] = pinSpinner.getValue().toString();
        }
        dispose();
    }
    
    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        result = null;
        dispose();
    }
    
    @SuppressWarnings("Convert2Lambda")
    private void initComponents(){
        GridBagConstraints gridBagConstraints;
        nameLabel = new JLabel();
        nameField = new JTextField();
        labelLabel = new JLabel();
        labelField = new JTextField();
        optionsGroup = new ButtonGroup();
        equalsRadio = new JRadioButton();
        greaterRadio = new JRadioButton();
        lessRadio = new JRadioButton();
        immediateLabel = new JLabel();
        pinLabel = new JLabel();
        immediateSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1, 1));
        pinSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 7, 1));
        acceptButton = new JButton();
        cancelButton = new JButton();
        
        this.setSize(new Dimension(250, 300));
        this.setTitle("Salto condicional");
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setModal(true);

        nameLabel.setText("Escriba el nombre de la variable:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameField, gridBagConstraints);
        
        labelLabel.setText("Escriba el nombre de la etiqueta:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(labelLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(labelField, gridBagConstraints);
        
        optionsGroup.add(equalsRadio);
        equalsRadio.setSelected(true);
        equalsRadio.setText("=");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(equalsRadio, gridBagConstraints);

        optionsGroup.add(lessRadio);
        lessRadio.setText("<");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(lessRadio, gridBagConstraints);
        
        optionsGroup.add(greaterRadio);
        greaterRadio.setText(">");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(greaterRadio, gridBagConstraints);
        
        immediateLabel.setText("Valor");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(immediateLabel, gridBagConstraints);
        
        pinLabel.setText("Pin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(pinLabel, gridBagConstraints);
        
        JFormattedTextField tf = ((JSpinner.DefaultEditor) immediateSpinner.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(immediateSpinner, gridBagConstraints);
        
        JFormattedTextField tf1 = ((JSpinner.DefaultEditor) pinSpinner.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(pinSpinner, gridBagConstraints);

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
    }
    
}
