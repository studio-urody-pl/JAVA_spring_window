//package studiourodypl;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class VerticalButtonPanel extends JPanel {
//
//    private JButton setValueButton;
//    private JButton calculateButton;
//    private JButton clearButton;
//
//    public VerticalButtonPanel() {
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        createButtons();
//        setButtonSizes();
//        addButtonsToPanel();
//        addActionListeners();
//    }
//
//    private void createButtons() {
//        // Set Value button
//        ImageIcon setValueIcon = new ImageIcon("resources/setValue24.png");
//        setValueButton = new JButton("Set value");
//        setValueButton.setToolTipText("Set value");
//        setValueButton.setIcon(setValueIcon);
//
//        // Calculate button
//        ImageIcon calculateIcon = new ImageIcon("resources/calculate24.png");
//        calculateButton = new JButton("Calculate");
//        calculateButton.setToolTipText("Calculate");
//        calculateButton.setIcon(calculateIcon);
//        calculateButton.setBackground(Color.CYAN);
//
//        // Clear Table button
//        ImageIcon cleanIcon = new ImageIcon("resources/clean24.png");
//        clearButton = new JButton("Clear table");
//        clearButton.setToolTipText("Clear table");
//        clearButton.setIcon(cleanIcon);
//    }
//
//    private void setButtonSizes() {
//        Dimension buttonSize = clearButton.getPreferredSize(); // Get size of clearButton
//        setValueButton.setPreferredSize(buttonSize); // Set size for setValueButton
//        calculateButton.setPreferredSize(buttonSize); // Set size for calculateButton
//        clearButton.setPreferredSize(buttonSize); // Set size for clearButton
//    }
//
//    private void addButtonsToPanel() {
//        add(setValueButton);
//        add(Box.createVerticalStrut(10)); // Add space between buttons
//        add(calculateButton);
//        add(Box.createVerticalStrut(10));
//        add(clearButton);
//    }
//
//    private void addActionListeners() {
//        setValueButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Set Value button clicked");
//            }
//        });
//
//        calculateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Calculate button clicked");
//            }
//        });
//
//        clearButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Clear Table button clicked");
//            }
//        });
//    }
//}
