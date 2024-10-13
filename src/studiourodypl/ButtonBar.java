package studiourodypl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class ButtonBar extends JToolBar implements ActionListener {

    private JButton newBtn, saveBtn, printBtn, exitBtn, helpBtn, aboutBtn;
    private MainFrame mainFrame;
    private TableSupport tableSupport;

    public ButtonBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        createButtonBar();
        addActionListeners();
    }

    private void createButtonBar() {
        setRollover(true);

        ImageIcon newIcon = new ImageIcon("resources/new48.png");
        newBtn = new JButton();
        newBtn.setIcon(newIcon);
        newBtn.setToolTipText("File->New");
        add(newBtn);
        addSeparator();

        ImageIcon saveIcon = new ImageIcon("resources/save48.png");
        saveBtn = new JButton();
        saveBtn.setIcon(saveIcon);
        saveBtn.setToolTipText("File->Save");
        add(saveBtn);
        addSeparator();

        ImageIcon printIcon = new ImageIcon("resources/print48.png");
        printBtn = new JButton();
        printBtn.setIcon(printIcon);
        printBtn.setToolTipText("File->Print");
        add(printBtn);
        addSeparator();

        ImageIcon exitIcon = new ImageIcon("resources/exit48.png");
        exitBtn = new JButton();
        exitBtn.setIcon(exitIcon);
        exitBtn.setToolTipText("File->Exit");
        add(exitBtn);
        addSeparator();

        ImageIcon helpIcon = new ImageIcon("resources/help48.png");
        helpBtn = new JButton();
        helpBtn.setIcon(helpIcon);
        helpBtn.setToolTipText("Help");
        add(helpBtn);
        addSeparator();

        ImageIcon aboutIcon = new ImageIcon("resources/about48.png");
        aboutBtn = new JButton();
        aboutBtn.setIcon(aboutIcon);
        aboutBtn.setToolTipText("About");
        add(aboutBtn);
        addSeparator();

    }

    private void addActionListeners() {
        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(),"New button clicked");
                if (mainFrame != null) {
                    mainFrame.restart();
                }
            }
        });

        saveBtn.addActionListener(new ActionListener() {
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

        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(),"Print action performed");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(),"Exit action performed");
                System.exit(0);
            }
        });


        helpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpDialog helpDialog = new HelpDialog();
                helpDialog.setVisible(true);
            }
        });

        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.setVisible(true);
            }
        });


   }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This can be left empty or used if needed.
    }
}
