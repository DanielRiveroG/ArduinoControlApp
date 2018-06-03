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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

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
    private JLabel valueLabel;
    private JLabel pinLabel;
    private JTextField valueField;
    private String[] result;
    
    public ConditionalJumpDialog() {
        result = new String[4];
        initComponents();
    }
    
    public String[] showDialog() {
        this.setVisible(true);
        return result;
    }
    
    private void acceptButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        if(nameField.getText().equals("") || labelField.getText().equals("") || valueField.getText().equals("")){
            result = null;
            dispose();
        }
        try{
            Double.parseDouble(valueField.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe escribir un número válido", "Atención", JOptionPane.WARNING_MESSAGE);
            result = null;
            dispose();
        }
        result[0] = nameField.getText();
        result[1] = labelField.getText().toUpperCase();
        result[2] = valueField.getText();
        if(equalsRadio.isSelected()){
            result[3] = "=";
        }else if(greaterRadio.isSelected()){
            result[3] = ">";
        }else{
            result[3] = "<";
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
        valueLabel = new JLabel();
        pinLabel = new JLabel();
        valueField = new JTextField();
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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameField, gridBagConstraints);
        
        labelLabel.setText("Escriba el nombre de la etiqueta:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(labelLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(labelField, gridBagConstraints);
        
        optionsGroup.add(equalsRadio);
        equalsRadio.setSelected(true);
        equalsRadio.setText("=");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(equalsRadio, gridBagConstraints);

        optionsGroup.add(lessRadio);
        lessRadio.setText("<");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(lessRadio, gridBagConstraints);
        
        optionsGroup.add(greaterRadio);
        greaterRadio.setText(">");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(greaterRadio, gridBagConstraints);
        
        valueLabel.setText("Escriba el valor de comparación:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(valueLabel, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(valueField, gridBagConstraints);
        
        acceptButton.setText("Aceptar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
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
