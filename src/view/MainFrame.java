/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionControler;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.Instruction;
/**
 *
 * @author Daniel
 */
public class MainFrame extends javax.swing.JFrame {


    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MainFrame(ConnectionControler connectControl, DefaultTreeModel instModel) {
        program = new DefaultListModel<>();
        this.instModel = instModel;
        initComponents();
        this.setLocationRelativeTo(null);
        this.connectControl = connectControl;
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
        jSeparator1 = new javax.swing.JToolBar.Separator();
        StartBut = new javax.swing.JButton();
        PauseBut = new javax.swing.JButton();
        StopBut = new javax.swing.JButton();
        ProgLabel = new javax.swing.JLabel();
        InstLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DOut3 = new javax.swing.JLabel();
        DOut5 = new javax.swing.JLabel();
        DOut2 = new javax.swing.JLabel();
        DOut1 = new javax.swing.JLabel();
        DOut4 = new javax.swing.JLabel();
        DigOutLabel = new javax.swing.JLabel();
        DIn3 = new javax.swing.JLabel();
        DIn2 = new javax.swing.JLabel();
        DIn5 = new javax.swing.JLabel();
        DIn1 = new javax.swing.JLabel();
        DigInLabel = new javax.swing.JLabel();
        DIn4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ConectInfoLabel = new javax.swing.JLabel();
        ConectLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewItm = new javax.swing.JMenuItem();
        OpenItm = new javax.swing.JMenuItem();
        SaveItm = new javax.swing.JMenuItem();
        ConectMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arduino Control App");
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        ProgramList.setModel(program);
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
        jToolBar2.add(DelBut);

        EditBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        EditBut.setToolTipText("Editar valor de instrucción");
        EditBut.setFocusable(false);
        EditBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(EditBut);
        jToolBar2.add(jSeparator1);

        StartBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        StartBut.setToolTipText("Ejecutar programa");
        StartBut.setFocusable(false);
        StartBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StartBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(StartBut);

        PauseBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        PauseBut.setToolTipText("Pausar ejecución");
        PauseBut.setFocusable(false);
        PauseBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PauseBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(PauseBut);

        StopBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stop.png"))); // NOI18N
        StopBut.setToolTipText("Parar ejecución");
        StopBut.setFocusable(false);
        StopBut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StopBut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        jPanel2.setLayout(new java.awt.GridBagLayout());

        DOut3.setBackground(new java.awt.Color(51, 102, 0));
        DOut3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOut3.setText("3");
        DOut3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DOut3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DOut3, gridBagConstraints);

        DOut5.setBackground(new java.awt.Color(51, 102, 0));
        DOut5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOut5.setText("5");
        DOut5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DOut5.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DOut5, gridBagConstraints);

        DOut2.setBackground(new java.awt.Color(51, 102, 0));
        DOut2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOut2.setText("2");
        DOut2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DOut2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DOut2, gridBagConstraints);

        DOut1.setBackground(new java.awt.Color(51, 102, 0));
        DOut1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOut1.setText("1");
        DOut1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DOut1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DOut1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DOut1, gridBagConstraints);

        DOut4.setBackground(new java.awt.Color(51, 102, 0));
        DOut4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOut4.setText("4");
        DOut4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DOut4.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DOut4, gridBagConstraints);

        DigOutLabel.setText("Salidas digitales:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DigOutLabel, gridBagConstraints);

        DIn3.setBackground(new java.awt.Color(51, 102, 0));
        DIn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DIn3.setText("3");
        DIn3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DIn3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DIn3, gridBagConstraints);

        DIn2.setBackground(new java.awt.Color(51, 102, 0));
        DIn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DIn2.setText("2");
        DIn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DIn2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DIn2, gridBagConstraints);

        DIn5.setBackground(new java.awt.Color(51, 102, 0));
        DIn5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DIn5.setText("5");
        DIn5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DIn5.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DIn5, gridBagConstraints);

        DIn1.setBackground(new java.awt.Color(51, 102, 0));
        DIn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DIn1.setText("1");
        DIn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DIn1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DIn1, gridBagConstraints);

        DigInLabel.setText("Entradas digitales:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DigInLabel, gridBagConstraints);

        DIn4.setBackground(new java.awt.Color(51, 102, 0));
        DIn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DIn4.setText("4");
        DIn4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DIn4.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(DIn4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

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

        FileMenu.setText("Archivo");

        NewItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewItm.setText("Nuevo");
        FileMenu.add(NewItm);

        OpenItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenItm.setText("Abrir");
        FileMenu.add(OpenItm);

        SaveItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveItm.setText("Guardar");
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

        jMenuBar1.add(ConectMenu);

        HelpMenu.setText("Ayuda");
        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionConfig(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionConfig
        // TODO add your handling code here:
        String port = JOptionPane.showInputDialog("Indique el puerto al que está conectado el controlador:");
        try {
            if(connectControl.establishConnection(port)){
                ConectInfoLabel.setText("Conexión establecida");
                ConectInfoLabel.setForeground(Color.green);
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectionConfig

    private void InstTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_InstTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) InstTree.getLastSelectedPathComponent();
        try {
            selected = (Instruction)node.getUserObject();
        } catch (Exception e) {
            selected = null;
        }
    }//GEN-LAST:event_InstTreeValueChanged

    private void AddButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButActionPerformed
        program.addElement(selected);
    }//GEN-LAST:event_AddButActionPerformed
    
    private  DefaultListModel<Instruction> program;
    private final ConnectionControler connectControl;
    private final DefaultTreeModel instModel;
    private Instruction selected;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBut;
    private javax.swing.JLabel ConectInfoLabel;
    private javax.swing.JLabel ConectLabel;
    private javax.swing.JMenu ConectMenu;
    private javax.swing.JLabel DIn1;
    private javax.swing.JLabel DIn2;
    private javax.swing.JLabel DIn3;
    private javax.swing.JLabel DIn4;
    private javax.swing.JLabel DIn5;
    private javax.swing.JLabel DOut1;
    private javax.swing.JLabel DOut2;
    private javax.swing.JLabel DOut3;
    private javax.swing.JLabel DOut4;
    private javax.swing.JLabel DOut5;
    private javax.swing.JButton DelBut;
    private javax.swing.JLabel DigInLabel;
    private javax.swing.JLabel DigOutLabel;
    private javax.swing.JButton EditBut;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JLabel InstLabel;
    private javax.swing.JTree InstTree;
    private javax.swing.JMenuItem NewItm;
    private javax.swing.JMenuItem OpenItm;
    private javax.swing.JButton PauseBut;
    private javax.swing.JLabel ProgLabel;
    private javax.swing.JList<Instruction> ProgramList;
    private javax.swing.JMenuItem SaveItm;
    private javax.swing.JButton StartBut;
    private javax.swing.JButton StopBut;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
