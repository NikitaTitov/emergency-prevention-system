package WorkingZone;


public class MonitoredField implements Cloneable {
    private StateForCell[][] monitoredField;

    public MonitoredField(int height, int width) {
        monitoredField = new StateForCell[height][width];
    }

    public void setCellValue(int row, int column, StateForCell cellValue) {
        monitoredField[row][column] = cellValue;
    }

    public StateForCell getStatusOfCell(int row, int column) {
        return monitoredField[row][column];
    }

    public int getHeightOfField() {
        return monitoredField.length;
    }

    public int getWidthOfField() {
        return monitoredField[0].length;
    }

    @Override
    public MonitoredField clone() {
        MonitoredField clone = new MonitoredField(getHeightOfField(), getWidthOfField());
        for (int row = 0; row < clone.getHeightOfField(); row++) {
            for (int column = 0; column < clone.getWidthOfField(); column++) {
                clone.setCellValue(row, column, monitoredField[row][column]);
            }
        }

        return clone;
    }

}
