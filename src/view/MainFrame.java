package view;

import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Instruction;

public class MainFrame extends JFrame {
    
    private ArrayList<Instruction> insSet;
    
    // Variables of user interface                     
    private JMenuBar MenuBar;
    private JMenu Menu1;
    private JMenu Menu2;
    private JTabbedPane tabbedPane;
    // End of variables declaration     
    
    
    public MainFrame(ArrayList ins) {
        this.insSet = ins;
        initComponents();
        this.setSize(500,300);
        this.setTitle("Arduino Control App");
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height)/2);
    }

    private void initComponents() {

        this.setJMenuBar(initMenu());
        this.add(initTabs());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }  
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    private JMenuBar initMenu() {
        MenuBar = new JMenuBar();
        Menu1 = new JMenu("Opciones");
        Menu2 = new JMenu("Edición");
        MenuBar.add(Menu1);
        MenuBar.add(Menu2);
        return MenuBar;
    }

    private JTabbedPane initTabs() {
        tabbedPane = new JTabbedPane();
        JComponent panel1 = makeTextPanel("Panel #1");
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Programación",panel1);
        tabbedPane.addTab("Monitorización",panel2);
        return tabbedPane;
    }
}
