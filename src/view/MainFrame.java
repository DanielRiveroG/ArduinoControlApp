package view;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Instruction;

public class MainFrame extends JFrame {
    // Variables of user interface                     
    private JMenuBar MenuBar;
    private JMenu Menu1;
    private JMenu Menu2;
    private JTabbedPane tabbedPane;
    private ProgramPanel program;
    private MonitorPanel monitor;
    // End of variables declaration     
    
    public MainFrame(ProgramPanel program, MonitorPanel monitor) {
        this.program = program;
        this.monitor = monitor;
        initComponents();
    }

    private void initComponents() {
        this.setJMenuBar(initMenu());
        this.add(initTabs());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arduino Control App");
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height)/2);
        setSize(500,300);
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
        tabbedPane.addTab("Programación",program);
        tabbedPane.addTab("Monitorización",monitor);
        return tabbedPane;
    }
}
