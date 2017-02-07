package WorkingZone.utils;


import WorkingZone.MonitoredField;
import WorkingZone.CellState;

public class MonitoredFieldPrinter {

    private MonitoredFieldPrinter(){

    }

    public static String print(MonitoredField field) {
        StringBuilder result = new StringBuilder();
        result.append('\t');
        for (int columnNumber = 0; columnNumber < field.getWidthOfField(); columnNumber++) {
            result.append(" " + columnNumber + " ");
        }
        result.append('\n');

        for (int row = 0; row < field.getHeightOfField(); row++) {
            result.append(row + "\t");
            for (int column = 0; column < field.getWidthOfField(); column++) {
                if (field.getCellState(row, column) == CellState.FILL)
                    result.append("|X|");
                else
                    result.append(" - ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
