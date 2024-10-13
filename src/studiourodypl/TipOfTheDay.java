package studiourodypl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TipOfTheDay {

    private JDialog dialog;
    private JLabel tipLabel;
    private List<String> tips;
    private int currentTipIndex;

    public TipOfTheDay(JFrame parentFrame) {
        tips = new ArrayList<>();
        tips.add("Tip 1: You can use Ctrl+C to copy text.");
        tips.add("Tip 2: Use Ctrl+V to paste text.");
        tips.add("Tip 3: Save your work frequently.");
        // Add more tips as needed

        dialog = new JDialog(parentFrame, "Tip of the Day", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(parentFrame);

        tipLabel = new JLabel("", JLabel.CENTER);
        tipLabel.setPreferredSize(new Dimension(280, 150));
        dialog.add(tipLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton nextTipButton = new JButton("Next Tip");
        nextTipButton.addActionListener(e -> showNextTip());
        buttonPanel.add(nextTipButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        currentTipIndex = 0;
    }

    public void showTip() {
        showNextTip();
        dialog.setVisible(true);
    }

    private void showNextTip() {
        if (!tips.isEmpty()) {
            tipLabel.setText(tips.get(currentTipIndex));
            currentTipIndex = (currentTipIndex + 1) % tips.size();
        }
    }
}
