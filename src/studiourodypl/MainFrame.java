package studiourodypl;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {

    private JFrame frame;
    private JToolBar toolBar;
    private JPanel panel;
    private JSpinner spinner;
    private JTable table;
    private JButton button;
    private JOptionPane optionPane;
    private JList list;
    private StatusBar statusBar;
    private TableModel tableModel;
//    private VerticalButtonPanel verticalButtonPanel;



    public MainFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Application_Spring_Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 550);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setIconImage(new ImageIcon("resources/logo.png").getImage());
        frame.setLocationRelativeTo(null);

//        -----change font size for Menu and MenuItem-----
        Font f = new Font("sans-serif", Font.PLAIN, 18);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        UIManager.put("infoLabel.font", f);

//        -----add JMenuBar to JFrame-----
        MenuBar menuBar = new MenuBar(this);
        frame.setJMenuBar(menuBar);

//        ----- add buttonBar to JFrame ------
        ButtonBar buttonBar = new ButtonBar(this);
        frame.add(buttonBar, BorderLayout.NORTH);

//        -----add Table -----
        TablePane tablePane = new TablePane();
        frame.add(tablePane, BorderLayout.CENTER);

//        ----- add Vertical Buttons -----
//        verticalButtonPanel = new VerticalButtonPanel();
//        frame.add(verticalButtonPanel, BorderLayout.WEST);

//        -----add JPanel statusBar to JFrame-----
        StatusBar statusBar = new StatusBar();
        frame.add(statusBar, BorderLayout.SOUTH);

//        ----- TablePane and StatusBar connection
        tablePane.setStatusBar(statusBar);

        // Show Tip of the Day after a delay
        Timer timer = new Timer(1000, e -> showTipOfTheDay());
        timer.setRepeats(false); // Ensure it only runs once
        timer.start();
    }

//    ----- ButtonBar to set into JFrame -----
    public JFrame getFrame() {
        return frame;
    }

//    ----- show method -----
    public void show()
    {
        frame.setVisible(true);
    }

//    ----- show tipOfTheDay method -----
    private void showTipOfTheDay() {
        TipOfTheDay tipOfTheDay = new TipOfTheDay(this);
        tipOfTheDay.showTip();
    }

//    ----- restart method -----
    public void restart() {
        frame.dispose();
        Launcher.main(null);
    }

}