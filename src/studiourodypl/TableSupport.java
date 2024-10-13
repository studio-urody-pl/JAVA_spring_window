package studiourodypl;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;

public class TableSupport extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private Integer[][] data;
    private final String[] columnNames = {"A", "B", "C", "D", "E"};

    public TableSupport() {
        data = new Integer[5][5];
        for (Integer[] row : data) {
            Arrays.fill(row, null);
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = (Integer) value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Integer[][] getData() {
        return data;
    }

    public void clearData() {
        for (Integer[] row : data) {
            Arrays.fill(row, null);
        }
        fireTableDataChanged();
    }
}