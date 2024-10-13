package studiourodypl;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {

    public AboutDialog() {

        super((Frame) null, "About", true);

//        ----- Set the size and center about dialog -----
        setSize(500, 350);
        setLocationRelativeTo(null); // Center on screen
        setResizable(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        String columnSpecs = "pref, 10dlu, fill:pref:grow";
        String rowSpecs = "pref, 10dlu, pref, 10dlu, fill:pref:grow, 10dlu, pref";

        FormLayout layout = new FormLayout(columnSpecs, rowSpecs);
        setLayout(layout);

        CellConstraints cc = new CellConstraints();

//        ----- set title label on north -----
        JLabel titleLabel = new JLabel("GUI project app", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel, cc.xyw(1, 1, 3, "center, center"));

//        ----- add separator under title label -----
        JSeparator northSeparator = new JSeparator();
        add(northSeparator, cc.xyw(1,2,3));

//        ----- set image on west -----
        ImageIcon logoIcon = new ImageIcon("resources/studio-urody-logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel, cc.xy(1, 3));

//        ----- set text labels on east -----
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        JLabel l1 = new JLabel("Politechnika Koszalińska");
        l1.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel l2 = new JLabel("WEiI");
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel l3 = new JLabel("Informatyka niestacj. 4 se.");
        l3.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel l4 = new JLabel("Tomasz Uroda, U-19974");
        l4.setFont(new Font("Arial", Font.PLAIN, 14));

        eastPanel.add(l1);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        eastPanel.add(l2);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        eastPanel.add(l3);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        eastPanel.add(l4);

        add(eastPanel, cc.xy(3, 3));

//        ----- add separator over south labels -----
        JSeparator southSeparator = new JSeparator();
        add(southSeparator, cc.xyw(1, 6, 3));

//        ----- set text labels on south -----
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        JLabel l5 = new JLabel("Copyright (C) 2024 by studiourodypl");
        l5.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel l6 = new JLabel("contact: tomasz.uroda@tu.koszalin.pl");
        l6.setFont(new Font("Arial", Font.PLAIN, 12));

        southPanel.add(l5);
        southPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        southPanel.add(l6);
        southPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        add(southPanel, cc.xyw(1, 7, 3, "center, center"));
    }
}