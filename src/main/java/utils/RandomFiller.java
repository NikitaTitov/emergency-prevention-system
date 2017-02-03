package utils;


import WorkingZone.MonitoredField;
import WorkingZone.StateForCell;

public class RandomFiller {

    public static void fill(MonitoredField field, double fillFactor) {
        for (int row = 0; row < field.getHeightOfField(); row++) {
            for (int column = 0; column < field.getWidthOfField(); column++) {
                if (Math.random() <= fillFactor) {
                    field.setCellValue(row, column, StateForCell.FILL);
                } else {
                    field.setCellValue(row, column, StateForCell.FREE);
                }
            }
        }
    }
}
