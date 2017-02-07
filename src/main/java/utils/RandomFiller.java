package utils;


import WorkingZone.MonitoredField;
import WorkingZone.CellState;

public class RandomFiller {

    public static void fill(MonitoredField field, double fillFactor) {
        for (int row = 0; row < field.getHeightOfField(); row++) {
            for (int column = 0; column < field.getWidthOfField(); column++) {
                field.setCellValue(row, column, getRandomState(fillFactor));
            }
        }
    }

    private static CellState getRandomState(double fillFactor) {
        return Math.random() <= fillFactor ? CellState.FILL : CellState.FREE;
    }
}
