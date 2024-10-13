package studiourodypl;

import javax.swing.table.DefaultTableModel;
import java.util.Random;

public class RandomFill {

    public static void fillTable(TableSupport tableSupport) {
        Random random = new Random();

        int rowCount = tableSupport.getRowCount();
        int columnCount = tableSupport.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                int randomNumber = random.nextInt(1001); // Generates a random number between 0 and 1000 (inclusive)
                tableSupport.setValueAt(randomNumber, row, col);
            }
        }
    }
}
