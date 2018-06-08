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

public class VariableDialog extends JDialog {
    
    private JButton acceptButton;
    private JButton cancelButton;
    private JTextField nameField;
    private JTextField immediateField;
    private JLabel nameLabel;
    private ButtonGroup optionsGroup;
    private JRadioButton immediateRadio;
    private JRadioButton digitalRadio;
    private JRadioButton analogRadio;
    private JRadioButton byteRadio;
    private JLabel immediateLabel;
    private JLabel digitalLabel;
    private JLabel analogLabel;
    private JLabel byteLabel;
    private JSpinner digitalSpinner;
    private JSpinner analogSpinner;
    private String[] result;
    
    public VariableDialog() {
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
        if(immediateRadio.isSelected()){
            try{
                Double.parseDouble(immediateField.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Debe escribir un número válido", "Atención", JOptionPane.WARNING_MESSAGE);
                result = null;
                dispose();
            }
            result[1] = "0";
            result[2] = immediateField.getText();
        }else if(digitalRadio.isSelected()){
            result[1] = "1";
            result[2] = digitalSpinner.getValue().toString();
        }else if(analogRadio.isSelected()){
            result[1] = "2";
            result[2] = analogSpinner.getValue().toString();
        }else{
            result[1] = "3";
            result[2] = "";
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
        immediateField = new JTextField();
        optionsGroup = new ButtonGroup();
        immediateRadio = new JRadioButton();
        digitalRadio = new JRadioButton();
        analogRadio = new JRadioButton();
        byteRadio = new JRadioButton();
        immediateLabel = new JLabel();
        digitalLabel = new JLabel();
        analogLabel = new JLabel();
        byteLabel = new JLabel();
        digitalSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 7, 1));
        analogSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
        acceptButton = new JButton();
        cancelButton = new JButton();
        
        this.setSize(new Dimension(450, 250));
        this.setTitle("Variable");
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setModal(true);

        nameLabel.setText("Escriba el nombre de la variable:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(nameField, gridBagConstraints);
        
        optionsGroup.add(immediateRadio);
        immediateRadio.setSelected(true);
        immediateRadio.setText("Valor");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(immediateRadio, gridBagConstraints);

        optionsGroup.add(digitalRadio);
        digitalRadio.setText("Pin digital");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(digitalRadio, gridBagConstraints);
        
        optionsGroup.add(analogRadio);
        analogRadio.setText("Pin analógico");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(analogRadio, gridBagConstraints);
        
        optionsGroup.add(byteRadio);
        byteRadio.setText("Byte");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(byteRadio, gridBagConstraints);
        
        immediateLabel.setText("Valor");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(immediateLabel, gridBagConstraints);
        
        digitalLabel.setText("Pin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(digitalLabel, gridBagConstraints);
        
        analogLabel.setText("Pin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(analogLabel, gridBagConstraints);
        
        byteLabel.setText("-");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        this.getContentPane().add(byteLabel, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(immediateField, gridBagConstraints);
        
        JFormattedTextField tf = ((JSpinner.DefaultEditor) digitalSpinner.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(digitalSpinner, gridBagConstraints);
        
        JFormattedTextField tf1 = ((JSpinner.DefaultEditor) analogSpinner.getEditor()).getTextField();
        tf1.setEditable(false);
        tf1.setBackground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(5, 5, 5, 0);
        this.getContentPane().add(analogSpinner, gridBagConstraints);

        acceptButton.setText("Aceptar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
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
        gridBagConstraints.gridx = 2;
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
