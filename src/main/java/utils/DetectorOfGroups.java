package utils;

import WorkingZone.MonitoredField;
import WorkingZone.StateForCell;
import java.util.HashMap;

import static utils.RiskDetector.getGroupRisk;

public class DetectorOfGroups {
    private MonitoredField monitoredField;


    public DetectorOfGroups(MonitoredField field) {
        this.monitoredField = field.clone();
    }

    public HashMap<EmergencyStatus, Integer> detect() {
        HashMap<EmergencyStatus, Integer> groups = new HashMap<EmergencyStatus, Integer>();
        for (EmergencyStatus group : EmergencyStatus.values()) {
            groups.put(group, 0);
        }

        findGroups(groups);

        return groups;
    }

    private void findGroups(HashMap<EmergencyStatus, Integer> groups) {
        for (int row = 0; row < monitoredField.getHeightOfField(); row++) {
            for (int column = 0; column < monitoredField.getWidthOfField(); column++) {
                if (monitoredField.getStatusOfCell(row, column) == StateForCell.FILL) {
                    int groupSize = findGroupSize(row, column);
                    EmergencyStatus riskGroup = getGroupRisk(groupSize);
                    groups.put(riskGroup, groups.get(riskGroup) + 1);
                }
            }
        }
    }

    private int findGroupSize(int row, int column) {
        int groupSize = 0;
        if (0 <= row && row < monitoredField.getHeightOfField() && 0 <= column && column < monitoredField.getWidthOfField()) {
            if (monitoredField.getStatusOfCell(row, column) == StateForCell.FILL) {
                groupSize++;

                monitoredField.setCellValue(row, column, StateForCell.FREE);

                groupSize += findGroupSize(row, column + 1);
                groupSize += findGroupSize(row + 1, column);
                groupSize += findGroupSize(row, column - 1);
                groupSize += findGroupSize(row - 1, column);
            }
        }
        return groupSize;
    }
}
