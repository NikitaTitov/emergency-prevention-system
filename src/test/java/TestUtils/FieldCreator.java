package TestUtils;

import workingzone.CellState;
import workingzone.MonitoredField;



public class FieldCreator {

    public static MonitoredField createFieldFromString(String str) {
        String stringWithoutDash = str.replace(" ", "");
        String[] rows = stringWithoutDash.split("\n");
        MonitoredField res = new MonitoredField(rows[0].length(), rows.length);
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[0].length(); x++) {
                res.setCellValue(x, y, symbolToState(rows[x].charAt(y)));
            }
        }
        return res;
    }

    private static CellState symbolToState(char symbol) {
        return symbol == 'x' ? CellState.FILL : CellState.FREE;
    }
}
