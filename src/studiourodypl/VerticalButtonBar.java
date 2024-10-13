//package studiourodypl;
//
//import com.l2fprod.common.swing.JButtonBar;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class VerticalButtonBar extends JButtonBar {
//
//    private JButton setValueBtn, calculateBtn, clearTableBtn;
//
//    public VerticalButtonBar() {
//        createButtonBar();
//        addActionListeners();
//    }
//
//    private void createButtonBar() {
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        setValueBtn = new JButton("Set Value");
//        calculateBtn = new JButton("Calculate");
//        clearTableBtn = new JButton("Clear Table");
//
//        add(setValueBtn);
//        add(Box.createVerticalStrut(10)); // Add space between buttons
//        add(calculateBtn);
//        add(Box.createVerticalStrut(10));
//        add(clearTableBtn);
//    }
//
//    private void addActionListeners() {
//        setValueBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action for Set Value button
//                JOptionPane.showMessageDialog(null, "Set Value button clicked");
//            }
//        });
//
//        calculateBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action for Calculate button
//                JOptionPane.showMessageDialog(null, "Calculate button clicked");
//            }
//        });
//
//        clearTableBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action for Clear Table button
//                JOptionPane.showMessageDialog(null, "Clear Table button clicked");
//            }
//        });
//    }
//}
//
