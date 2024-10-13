package studiourodypl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Launcher {

    public static void main(String[] args) {
        // Run this program on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.show();

            }
        });


    }
}
