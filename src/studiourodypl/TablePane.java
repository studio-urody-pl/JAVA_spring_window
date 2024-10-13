package studiourodypl;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TablePane extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField numberField;
    private JSpinner rowSpinner;
    private JSpinner columnSpinner;
    private JTable table;
    private JTextArea resultsArea;
    private JList<String> operationsList;
    private JButton calculateButton;
    private final TableSupport tableSupport;
    private StatusBar statusBar;
    private JDateChooser dateChooser;
    private Histogram histogram;


    public TablePane() {
        setLayout(new BorderLayout());

        // ----- top panel with cell options -----
        JPanel topPanel = new JPanel();

        //        ----- create date chooser -----
        topPanel.add(new JLabel("Select date:"));
        ImageIcon calendarIcon = new ImageIcon("resources/calendar24.png");
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setIcon(calendarIcon);
        topPanel.add(dateChooser);

        topPanel.add(new JLabel("Enter int number:"));
        numberField = new JTextField(5);
        numberField.setToolTipText("Enter int number");
        topPanel.add(numberField);

        topPanel.add(new JLabel("Select row:"));
        rowSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        rowSpinner.setToolTipText("Select row");
        topPanel.add(rowSpinner);

        topPanel.add(new JLabel("Column:"));
        columnSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        columnSpinner.setToolTipText("Select column");
        topPanel.add(columnSpinner);


        add(topPanel, BorderLayout.NORTH);

//        ----- add JTable -----
        tableSupport = new TableSupport();
        table = new JTable(tableSupport);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setDefaultEditor(Object.class, null);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

//        ----- ustawienie wyrownania do prawej w tabeli -----
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(rightRenderer);
        }

        add(tableScrollPane, BorderLayout.CENTER);


//        ----- add bottom panel -----
        JPanel bottomPanel = new JPanel(new BorderLayout());

//         ----- panel with buttons -----
        JPanel buttonsPanel = new JPanel();

//        ----- create setValue button -----
        ImageIcon setValueIcon = new ImageIcon("resources/setValue24.png");
        JButton setValueButton = new JButton("Set value");
        setValueButton.setToolTipText("Set value");
        setValueButton.setIcon(setValueIcon);

//        ----- create random fill button -----
        ImageIcon randomIcon = new ImageIcon("resources/random24.png");
        JButton randomFillButton = new JButton("Random numbers");
        randomFillButton.setToolTipText("Fill the table with random numbers");
        randomFillButton.setIcon(randomIcon);

//        ----- create calculate button -----
        ImageIcon calculateIcon = new ImageIcon("resources/calculate24.png");
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setToolTipText("Calculate");
        calculateButton.setIcon(calculateIcon);
        calculateButton.setBackground(Color.CYAN);

//        ----- create clean button -----
        ImageIcon cleanIcon = new ImageIcon("resources/clean24.png");
        JButton clearButton = new JButton("Clear table");
        clearButton.setToolTipText("Clear table");
        clearButton.setIcon(cleanIcon);

//        ----- create save button -----
        ImageIcon saveIcon = new ImageIcon("resources/save24.png");
        JButton saveButton = new JButton("Save to file");
        saveButton.setToolTipText("Save to file");
        saveButton.setIcon(saveIcon);

//        ----- create histogram button -----
        ImageIcon histogramIcon = new ImageIcon("resources/histogram24.png");
        JButton histogramButton = new JButton("Histogram");
        histogramButton.setToolTipText("Open histogram");
        histogramButton.setIcon(histogramIcon);

//        ----- add buttons to buttonsPanel -----
        buttonsPanel.add(setValueButton);
        buttonsPanel.add(randomFillButton);
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(saveButton);
        buttonsPanel.add(histogramButton);


        bottomPanel.add(buttonsPanel, BorderLayout.NORTH);

//        -----GridBagLayout for JList abd Text -----
        JPanel listAndResultsPanel = new JPanel(new GridBagLayout());
        bottomPanel.add(listAndResultsPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

//        ----- calculations list -----
        String[] calculations = {"Sum", "Average", "MAX", "MIN"};
        operationsList = new JList<>(calculations);
        operationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        operationsList.setToolTipText("Select operation you want to proceed");
        operationsList.setSelectionBackground(Color.lightGray);
        JScrollPane calculationsScrollPane = new JScrollPane(operationsList);
        gbc.gridx = 0;
        gbc.gridy = 0;
        listAndResultsPanel.add(calculationsScrollPane, gbc);


//        ----- results textArea -----
        resultsArea = new JTextArea(5, 40);
        resultsArea.setToolTipText("Here you'll see the results");
        JScrollPane resultsScrollPane = new JScrollPane(resultsArea);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        listAndResultsPanel.add(resultsScrollPane, gbc);

        add(bottomPanel, BorderLayout.SOUTH);


        // ----- button ActionListeners -----
        dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dateChooser.getDate());
            resultsArea.append("Selected date: " + date + "\n");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableSupport.clearData();
                if (statusBar != null) {
                    statusBar.setStatusTextField("Table cleared");
                }
            }
        });


//        ----- button ActionListeners -----
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableSupport.clearData();
                if (statusBar != null) {
                    statusBar.setStatusTextField("Table cleared");
                }
            }
        });

        setValueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String numberStr = numberField.getText();
//                    ----- convert text to int -----
                    int number = Integer.parseInt(numberStr);
                    int row = (int) rowSpinner.getValue()-1;
                    int column = (int) columnSpinner.getValue()-1;
                    tableSupport.setValueAt(number, row, column);
                    if (statusBar != null){
                        statusBar.setStatusTextField("Value set for cell (" + row + ", " + column + ")");
                    }
                } catch (NumberFormatException ex) {
                    // Wyświetlenie okna dialogowego z informacją o błędzie
                    JOptionPane.showMessageDialog(TablePane.this,
                            "Wrong number format. Please input int number.",
                            "Błąd Wprowadzania",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        randomFillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    RandomFill.fillTable((TableSupport) table.getModel());
                    statusBar.setStatusTextField("Table filled with random numbers");

            }

        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter writer = new FileWriter("table_data.txt")) {
                    for (int i = 0; i < tableSupport.getRowCount(); i++) {
                        for (int j = 0; j < tableSupport.getColumnCount(); j++) {
                            Object value = tableSupport.getValueAt(i, j);
                            writer.write((value == null ? "" : value.toString()) + "\t");
                        }
                        writer.write("\n");
                    }
                    if (statusBar != null) {
                        statusBar.setStatusTextField("Saved to table_data.txt");
                    }
                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(TablePane.this,
                            "File save error.",
                            "File error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        histogramButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            showHistogram();
            }
        });

//        ----- calculateButton actionListener -----
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = operationsList.getSelectedValue();
                if (selectedOption != null) {
                    switch (selectedOption) {
                        case "Sum":
                            resultsArea.append("Sum: " + calculateSum());
                            break;
                        case "Average":
                            resultsArea.append("Average: " + calculateAverage());
                            break;
                        case "MAX":
                            resultsArea.append("MAX: " + findMax());
                            break;
                        case "MIN":
                            resultsArea.append("MIN: " + findMin());
                            break;
                        default:
                            resultsArea.append("Please pick the operation from list.");
                            break;
                    }
                    if (statusBar != null) {
                        statusBar.setStatusTextField("Calculated results for " + selectedOption);
                    }
                } else {
                    resultsArea.append("Please pick the operation from list.");
                }
            }
        });



    }

//    ----- Setter method for StatusBar -----
    public void setStatusBar(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

    private int calculateSum() {
        int sum = 0;
        for (int i = 0; i < tableSupport.getRowCount(); i++) {
            for (int j = 0; j < tableSupport.getColumnCount(); j++) {
                Object value = tableSupport.getValueAt(i, j);
                if (value != null && value instanceof Integer) {
                    sum += (Integer) value;
                }
            }
        }
        return sum;
    }

    private double calculateAverage() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < tableSupport.getRowCount(); i++) {
            for (int j = 0; j < tableSupport.getColumnCount(); j++) {
                Object value = tableSupport.getValueAt(i, j);
                if (value != null && value instanceof Integer) {
                    sum += (Integer) value;
                    count++;
                }
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    private int findMax() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < tableSupport.getRowCount(); i++) {
            for (int j = 0; j < tableSupport.getColumnCount(); j++) {
                Object value = tableSupport.getValueAt(i, j);
                if (value != null && value instanceof Integer) {
                    values.add((Integer) value);
                }
            }
        }
        return values.isEmpty() ? 0 : Collections.max(values);
    }

    private int findMin() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < tableSupport.getRowCount(); i++) {
            for (int j = 0; j < tableSupport.getColumnCount(); j++) {
                Object value = tableSupport.getValueAt(i, j);
                if (value != null && value instanceof Integer) {
                    values.add((Integer) value);
                }
            }
        }
        return values.isEmpty() ? 0 : Collections.min(values);
    }

    public void showHistogram() {
        Histogram histogramChart = new Histogram((JFrame) SwingUtilities.getWindowAncestor(this), tableSupport.getData());
        histogramChart.showHistogram();
    }
}

