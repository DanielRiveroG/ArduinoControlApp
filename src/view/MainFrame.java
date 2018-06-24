/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionControler;
import control.ProgramController;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.Instruction;
import model.Program;
/**
 *
 * @author Daniel
 */
public class MainFrame extends javax.swing.JFrame {


    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MainFrame(ConnectionControler connectControl, DefaultTreeModel instModel, ProgramController programControl, Program program) {
        this.program = program;
        this.instModel = instModel;
        initComponents();
        this.setLocationRelativeTo(null);
        this.connectControl = connectControl;
        this.programControl = programControl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        ProgramList = new javax.swing.JList<Instruction>();
        jScrollPane2 = new javax.swing.JScrollPane();
        InstTree = new javax.swing.JTree();
        jToolBar2 = new javax.swing.JToolBar();
        AddBut = new javax.swing.JButton();
        DelBut = new javax.swing.JButton();
        EditBut = new javax.swing.JButton();
        ClearBut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        StartBut = new javax.swing.JButton();
        StopBut = new javax.swing.JButton();
        ProgLabel = new javax.swing.JLabel();
        InstLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ConectInfoLabel = new javax.swing.JLabel();
        ConectLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        NameVariableLabel = new javax.swing.JLabel();
        VariableComboBox = new javax.swing.JComboBox<>();
        VariableValueLabel = new javax.swing.JLabel();
        ValueLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenItm = new javax.swing.JMenuItem();
        SaveItm = new javax.swing.JMenuItem();
        ConectMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        CloseConnectionItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arduino Control App");
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        ProgramList.setModel(program.getInstructions());
        jScrollPane1.setViewportView(ProgramList);
        ProgramList.getAccessibleContext().setAccessibleName("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        InstTree.setModel(instModel);
        InstTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                InstTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(InstTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        AddBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        AddBut.setToolTipText("Añadir instrucción al programa");
        AddBut.setFocusable(false);
        AddBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AddBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButActionPerformed(evt);
            }
        });
        jToolBar2.add(AddBut);

        DelBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.png"))); // NOI18N
        DelBut.setToolTipText("Borrar instrucción seleccionada");
        DelBut.setFocusable(false);
        DelBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DelBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DelBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelButActionPerformed(evt);
            }
        });
        jToolBar2.add(DelBut);

        EditBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        EditBut.setToolTipText("Editar valor de instrucción");
        EditBut.setFocusable(false);
        EditBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButActionPerformed(evt);
            }
        });
        jToolBar2.add(EditBut);

        ClearBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        ClearBut.setToolTipText("Borrar programa completo");
        ClearBut.setFocusable(false);
        ClearBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ClearBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ClearBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButActionPerformed(evt);
            }
        });
        jToolBar2.add(ClearBut);
        jToolBar2.add(jSeparator1);

        StartBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        StartBut.setToolTipText("Ejecutar programa");
        StartBut.setFocusable(false);
        StartBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StartBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StartBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButActionPerformed(evt);
            }
        });
        jToolBar2.add(StartBut);

        StopBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stop.png"))); // NOI18N
        StopBut.setToolTipText("Parar ejecución");
        StopBut.setFocusable(false);
        StopBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StopBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StopBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButActionPerformed(evt);
            }
        });
        jToolBar2.add(StopBut);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jToolBar2, gridBagConstraints);

        ProgLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ProgLabel.setText("Programa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(ProgLabel, gridBagConstraints);

        InstLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        InstLabel.setText("Instrucciones:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(InstLabel, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del hardware", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        ConectInfoLabel.setForeground(new java.awt.Color(255, 51, 51));
        ConectInfoLabel.setText("No hay hardware conectado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(ConectInfoLabel, gridBagConstraints);

        ConectLabel.setText("Estado de la conexión:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(ConectLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado de la ejecución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        NameVariableLabel.setText("Variable:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel2.add(NameVariableLabel, gridBagConstraints);

        VariableComboBox.setModel(program.getVariableNames());
        VariableComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VariableComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(VariableComboBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(VariableValueLabel, gridBagConstraints);

        ValueLabel.setText("Valor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 1);
        jPanel2.add(ValueLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel4, gridBagConstraints);

        FileMenu.setText("Archivo");

        OpenItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenItm.setText("Cargar");
        OpenItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenItmActionPerformed(evt);
            }
        });
        FileMenu.add(OpenItm);

        SaveItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveItm.setText("Guardar");
        SaveItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveItmActionPerformed(evt);
            }
        });
        FileMenu.add(SaveItm);

        jMenuBar1.add(FileMenu);

        ConectMenu.setText("Conexión");

        jMenuItem1.setText("Configurar conexión con hardware");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionConfig(evt);
            }
        });
        ConectMenu.add(jMenuItem1);

        CloseConnectionItem.setText("Cerrar conexión con hardware");
        CloseConnectionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseConnectionItemActionPerformed(evt);
            }
        });
        ConectMenu.add(CloseConnectionItem);

        jMenuBar1.add(ConectMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionConfig(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionConfig
        // TODO add your handling code here:
        try{
            if(connectControl.establishConnection()){
                ConectInfoLabel.setText("Conexión establecida");
                ConectInfoLabel.setForeground(Color.green);
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectionConfig

    private void InstTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_InstTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) InstTree.getLastSelectedPathComponent();
        try {
            selectedTree = (Instruction)node.getUserObject();
        } catch (Exception e) {
            selectedTree = null;
        }
    }//GEN-LAST:event_InstTreeValueChanged

    private void AddButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButActionPerformed
        if(selectedTree != null){
            try{
                programControl.addInstruction(selectedTree, ProgramList.getSelectedIndex());
                ProgramList.clearSelection();
            }catch(Exception e){
                programControl.addInstruction(selectedTree, -1);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar una instrucción para poder añadirla", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AddButActionPerformed

    private void DelButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelButActionPerformed
        try{
            programControl.deleteInstruction(ProgramList.getSelectedIndex());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar una instrucción para poder borrar", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DelButActionPerformed

    private void StartButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButActionPerformed
        programControl.executeProgram();
    }//GEN-LAST:event_StartButActionPerformed

    private void SaveItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveItmActionPerformed
        try {
            programControl.saveProgram();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido guardar el fichero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveItmActionPerformed

    private void OpenItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenItmActionPerformed
        try {
            programControl.loadProgram();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido abrir el fichero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenItmActionPerformed

    private void ClearButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButActionPerformed
        programControl.clearProgram();
    }//GEN-LAST:event_ClearButActionPerformed

    private void CloseConnectionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseConnectionItemActionPerformed
        try {
            if(connectControl.closeConnection()){
                ConectInfoLabel.setText("No hay hardware conectado");
                ConectInfoLabel.setForeground(Color.red);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CloseConnectionItemActionPerformed

    private void EditButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButActionPerformed
        try{
            int pos = ProgramList.getSelectedIndex();
            if(programControl.addInstruction(ProgramList.getSelectedValue(), pos)){
                programControl.deleteInstruction(pos+1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar una instrucción para poder editar", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditButActionPerformed

    private void StopButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButActionPerformed
        programControl.stopProgram();
    }//GEN-LAST:event_StopButActionPerformed

    private void VariableComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VariableComboBoxActionPerformed
        ValueLabel.setText(programControl.getVariableValue((String) VariableComboBox.getSelectedItem()));
    }//GEN-LAST:event_VariableComboBoxActionPerformed
    
    private final Program program;
    private final ConnectionControler connectControl;
    private final ProgramController programControl;
    private final DefaultTreeModel instModel;
    private Instruction selectedTree;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBut;
    private javax.swing.JButton ClearBut;
    private javax.swing.JMenuItem CloseConnectionItem;
    private javax.swing.JLabel ConectInfoLabel;
    private javax.swing.JLabel ConectLabel;
    private javax.swing.JMenu ConectMenu;
    private javax.swing.JButton DelBut;
    private javax.swing.JButton EditBut;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel InstLabel;
    private javax.swing.JTree InstTree;
    private javax.swing.JLabel NameVariableLabel;
    private javax.swing.JMenuItem OpenItm;
    private javax.swing.JLabel ProgLabel;
    private javax.swing.JList<Instruction> ProgramList;
    private javax.swing.JMenuItem SaveItm;
    private javax.swing.JButton StartBut;
    private javax.swing.JButton StopBut;
    private javax.swing.JLabel ValueLabel;
    private javax.swing.JComboBox<String> VariableComboBox;
    private javax.swing.JLabel VariableValueLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
