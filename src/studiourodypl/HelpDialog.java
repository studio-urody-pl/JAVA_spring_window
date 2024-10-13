package studiourodypl;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class HelpDialog extends JDialog {
    public HelpDialog() {
        super((Frame) null, "Help", true);

//        ----- set size and center help dialog -----
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        String columnSpecs = "pref, 10dlu, fill:pref:grow";
        String rowSpecs = "pref, 2dlu, pref, 2dlu, fill:pref:grow, 2dlu, pref";

        FormLayout layout = new FormLayout(columnSpecs, rowSpecs);
        setLayout(layout);

        CellConstraints cc = new CellConstraints();

        //        ----- set title label on north -----
        JLabel titleLabel = new JLabel("If you need any help", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel, cc.xyw(1, 1, 3, "center, center"));

        //        ----- add separator under title label -----
        JSeparator northSeparator = new JSeparator();
        add(northSeparator, cc.xyw(1,2,3));

//        ----- add texarea for help text -----
        JTextArea helpTextArea = new JTextArea();
        helpTextArea.setText("\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla iaculis libero erat. Praesent a justo nec nisi commodo vehicula vitae eu quam. Etiam ut odio quam. Vestibulum tempor, leo eu aliquam consectetur, est lectus tempor lectus, ut faucibus erat nisl id ligula. Aliquam euismod augue tortor, eget convallis tortor pretium ac. Fusce et nunc sit amet lorem congue egestas eget eu lorem. Fusce et dictum sem.\n" +
                "\n" +
                "Sed ac justo nunc. Praesent vehicula condimentum massa, at porta purus blandit a. Phasellus eros dolor, sagittis et quam molestie, viverra auctor neque. Donec ac diam tincidunt, gravida arcu nec, tristique dolor. Sed a nunc eu lorem bibendum malesuada. Pellentesque a egestas ex. Duis id quam leo. Etiam et turpis lectus.\n" +
                "\n" +
                "Morbi vehicula aliquet diam, ut varius leo bibendum id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec tincidunt dui porttitor orci pulvinar, ac feugiat mauris aliquam. Mauris sapien est, mattis rhoncus convallis ac, malesuada vitae velit. Sed placerat enim a nibh vehicula, ut sagittis sapien ultricies. Aliquam in porta augue. Aenean in condimentum erat. Suspendisse a lacinia metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n" +
                "\n" +
                "Nunc a dictum felis, a hendrerit erat. Phasellus elit leo, commodo quis ornare in, lacinia eu odio. Quisque mi sapien, finibus ac nulla eget, finibus vulputate risus. Nunc sit amet sem bibendum velit maximus dictum. Curabitur non sem sagittis, laoreet nunc non, commodo augue. Integer massa sem, venenatis ut convallis quis, tincidunt rutrum ligula. Integer placerat erat libero, quis aliquam dolor facilisis eget.\n" +
                "\n" +
                "Phasellus fringilla, velit eu bibendum blandit, lacus sem ullamcorper ligula, vel commodo purus mauris eu erat. Etiam at nisi vitae dolor tempus ornare eu ac quam. In purus mi, hendrerit sit amet elementum at, tincidunt sit amet felis. Ut ac dictum mauris. Curabitur ut odio in magna porttitor maximus. Nullam vel rutrum felis. Nullam semper justo in pellentesque finibus. Aenean non nibh et justo placerat aliquam ac quis nisi. Proin vulputate ullamcorper lacus ut ornare. Praesent vulputate, felis in aliquet iaculis, nisl nisl ornare nibh, vitae commodo arcu lectus eu ligula. Morbi pharetra turpis vitae elit congue volutpat. Donec pharetra purus quis dolor hendrerit porttitor. Aenean dui tellus, aliquam at nisl in, malesuada feugiat ex. Nunc risus felis, suscipit nec lacinia imperdiet, viverra quis ligula. Suspendisse gravida fringilla ipsum, sed mattis sem elementum eget. Aliquam erat volutpat. ");
        helpTextArea.setEditable(false);
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        helpTextArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(helpTextArea);
        add(scrollPane, cc.xyw(1, 5, 3, "fill, fill"));

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

