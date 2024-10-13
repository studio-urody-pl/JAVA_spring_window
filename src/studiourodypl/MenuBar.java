package studiourodypl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class MenuBar extends JMenuBar implements ActionListener {


    private JMenu fileMenu, editMenu, helpMenu;
    private JMenuItem newMenuItem, saveMenuItem, printMenuItem, exitMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem, helpMenuItem, aboutMenuItem;
    private MainFrame mainFrame;
    private StatusBar statusBar;

    public MenuBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        createMenuBar();
        addActionListeners();
    }

    private void createMenuBar() {

//        ----create FileMenu----
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+f activates menu file

//        -----create new menuItem-----
        ImageIcon newIcon = new ImageIcon("resources/new24.png");
        newMenuItem = new JMenuItem("New", newIcon);
        newMenuItem.setIcon(newIcon);
        newMenuItem.setIconTextGap(10);

//        ----crate save menuItem-----
        ImageIcon saveIcon = new ImageIcon("resources/save24.png");
        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setIcon(saveIcon);
        saveMenuItem.setIconTextGap(10);

//        ----- create print menuItem -----
        ImageIcon printIcon = new ImageIcon("resources/print24.png");
        printMenuItem = new JMenuItem("Print");
        printMenuItem.setIcon(printIcon);
        printMenuItem.setIconTextGap(10);

//        ----create exit menuItem-----
        ImageIcon exitIcon = new ImageIcon("resources/exit24.png");
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setIcon(exitIcon);
        exitMenuItem.setIconTextGap(10);

//        -----add menuItems to fileMenu-----
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.add(exitMenuItem);

////        -----create editMenu----
//        editMenu = new JMenu("Edit");
//        editMenu.setMnemonic(KeyEvent.VK_E);

////        -----create cut menuItem-----
//        ImageIcon cutIcon = new ImageIcon("resources/cut24.png");
//        cutMenuItem = new JMenuItem("Cut");
//        cutMenuItem.setIcon(cutIcon);
//        cutMenuItem.setIconTextGap(10);
//
////        ----create copy menuItem-----
//        ImageIcon copyIcon = new ImageIcon("resources/copy24.png");
//        copyMenuItem = new JMenuItem("Copy");
//        copyMenuItem.setIcon(copyIcon);
//        copyMenuItem.setIconTextGap(10);
//
////        -----create paste menuItem-----
//        ImageIcon pasteIcon = new ImageIcon("resources/paste24.png");
//        pasteMenuItem = new JMenuItem("Paste");
//        pasteMenuItem.setIcon(pasteIcon);
//        pasteMenuItem.setIconTextGap(10);

////        -----add menuItems to editMenu----
//        editMenu.add(cutMenuItem);
//        editMenu.add(copyMenuItem);
//        editMenu.add(pasteMenuItem);

//        -----create helpMenu-----
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

//        -----create help menuItem----
        ImageIcon helpIcon = new ImageIcon("resources/help24.png");
        helpMenuItem = new JMenuItem("Help");
        helpMenuItem.setIcon(helpIcon);
        helpMenuItem.setIconTextGap(10);

//        -----create about menuItem-----
        ImageIcon aboutIcon = new ImageIcon("resources/about24.png");
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setIcon(aboutIcon);
        aboutMenuItem.setIconTextGap(10);

//        -----add menuItems to helpMenu-----
        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);

//        -----add file, edit, help menus to menuBar-----
        this.add(fileMenu);
//        this.add(editMenu);
        this.add(helpMenu);

    }

//    ----- add action listeners -----
    private void addActionListeners() {
//        ----- add newMenu listener -----
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(),"New button clicked");
                if (mainFrame != null) {
                    mainFrame.restart();
                }
                if (statusBar != null) {
                    statusBar.setInfoTextField("New button clicked");
                }
            }
    });
//        ----- add saveMenu listener -----
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(mainFrame.getFrame());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(mainFrame.getFrame(),
                            "Selected file: " + selectedFile.getAbsolutePath());
                }

            }
        });

//        ----- add printMenu listener -----
        printMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_P);
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_P);
                    JOptionPane.showMessageDialog(mainFrame.getFrame(),"Print action performed");
                } catch (AWTException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });

//        ----- add exitMenu listener -----
        exitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit menu item clicked");
                System.exit(0);
            }
        });
////        ----- add cutMenu listener -----
//        cutMenuItem.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Robot robot = new Robot();
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_X);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.keyRelease(KeyEvent.VK_X);
//                    System.out.println("Cut menu item clicked");
//                } catch (AWTException ex) {
//                    System.err.println(ex.getMessage());
//                }
//            }
//        });
////        ----- add copyMenu listener -----
//        copyMenuItem.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Robot robot = new Robot();
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_C);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.keyRelease(KeyEvent.VK_C);
//                    System.out.println("Copy menu item clicked");
//                } catch (AWTException ex) {
//                    System.err.println(ex.getMessage());
//                }
//            }
//        });
////        ----- add pasteMenu listener -----
//        pasteMenuItem.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Robot robot = new Robot();
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.keyRelease(KeyEvent.VK_V);
//                    System.out.println("Paste menu item clicked");
//                } catch (AWTException ex) {
//                    System.err.println(ex.getMessage());
//                }
//            }
//        });

//        ----- add about dialog listener -----
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              AboutDialog aboutDialog = new AboutDialog();
              aboutDialog.setVisible(true);
            }
        });

//        ----- add help dialog listener -----
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            HelpDialog helpDialog = new HelpDialog();
            helpDialog.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
