package studiourodypl;

import javax.swing.*;
import java.awt.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class StatusBar extends JPanel {
    private static final long serialVersionUID = 1L;
    private static JLabel infoLabel, statusLabel;
    private static JTextField infoTextField, statusTextField;

    public StatusBar() {
        setLayout(new BorderLayout());
        initGUI();
        add(CreateCenterPanel(), BorderLayout.CENTER);
    }

    private void initGUI() {
        infoLabel = new JLabel("Info");
        statusLabel = new JLabel("Status");
        infoTextField = new JTextField("Start of application");
        statusTextField = new JTextField("ON");
        infoTextField.setHorizontalAlignment(JTextField.LEFT);
        statusTextField.setHorizontalAlignment(JTextField.LEFT);
    }

    private JPanel CreateCenterPanel() {
        JPanel panel = new JPanel();
//        panel.setBackground(Color.LIGHT_GRAY);
        FormLayout formLayout = new FormLayout(
                "4dlu, pref, 5dlu, 150dlu, pref:grow, pref, 5dlu, 150dlu, 4dlu",
                "2dlu, 15dlu, 2dlu");
        panel.setLayout(formLayout);
        CellConstraints cc = new CellConstraints();
        panel.add(infoLabel, cc.xy(2, 2, CellConstraints.FILL, CellConstraints.FILL));
        panel.add(infoTextField, cc.xy(4, 2, CellConstraints.FILL, CellConstraints.FILL));
        panel.add(statusLabel, cc.xy(6, 2, CellConstraints.FILL, CellConstraints.FILL));
        panel.add(statusTextField, cc.xy(8, 2, CellConstraints.FILL, CellConstraints.FILL));
        return panel;
    }

//    ----- statusTextField getter -----
    public void getStatusTextField(String text) {
        statusTextField.getText();
    }

//    ----- statusTextField setter -----
    public void setStatusTextField (String text) {
        statusTextField.setText(text);
    }

//    ----- infoTextField getter -----
    public void getInfoTextField (String text) {
        infoTextField.getText();
    }

//    ----- infoTextField setter -----
    public void setInfoTextField (String text) {
        infoTextField.setText(text);
    }
}
