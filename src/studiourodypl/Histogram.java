package studiourodypl;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class Histogram extends JDialog {
    private Integer[][] data;

    public Histogram(JFrame parentFrame, Integer[][] data) {
        super(parentFrame, "Histogram", true);
        this.data = data;
        setSize(800, 600);
        setLocationRelativeTo(parentFrame);
    }

    public void showHistogram() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Integer value = data[row][col];
                if (value != null) {
                    String cellLabel = String.format("(%d,%d)", row + 1, col + 1);
                    dataset.addValue(value, "Values", cellLabel);
                }
            }
        }

        JFreeChart histogram = ChartFactory.createBarChart(
                "Histogram wartości tabeli",
                "Komórki",
                "Wartości",
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false
        );

        CategoryPlot plot = histogram.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(histogram);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
        setVisible(true);
    }
}
