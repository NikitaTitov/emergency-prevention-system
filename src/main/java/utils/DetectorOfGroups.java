package utils;

import workingzone.MonitoredField;
import workingzone.CellState;

import java.util.Map;
import java.util.TreeMap;


public class DetectorOfGroups {
    private MonitoredField monitoredField;
    private RankRiskDetector groupRisk;


    public DetectorOfGroups(MonitoredField field) {
        this.monitoredField = field.clone();
    }

    public Map<EmergencyStatus, Integer> detect() {
        Map<EmergencyStatus, Integer> groups = new TreeMap<EmergencyStatus, Integer>();

        fillGroups(groups);
        findGroups(groups);

        return groups;
    }

    private Map<EmergencyStatus, Integer> fillGroups(Map<EmergencyStatus, Integer> groups) {
        for (EmergencyStatus group : EmergencyStatus.values()) {
            groups.put(group, 0);
        }
        return groups;
    }

    private void findGroups(Map<EmergencyStatus, Integer> groups) {
        for (int row = 0; row < monitoredField.getHeightOfField(); row++) {
            for (int column = 0; column < monitoredField.getWidthOfField(); column++) {
                if (hasHuman(row, column)) {
                    int groupSize = findNeighbors(row, column);
                    EmergencyStatus riskGroup = groupRisk.getGroupRisk(groupSize);
                    groups.put(riskGroup, groups.get(riskGroup) + 1);
                }
            }
        }
    }

    public int findNeighbors(int row, int column) {
        int groupSize = 0;
        if (inBound(row, column)) {
            if (hasHuman(row, column)) {
                groupSize++;

                monitoredField.setCellValue(row, column, CellState.FREE);

                groupSize += findNeighbors(row, column + 1);
                groupSize += findNeighbors(row + 1, column);
                groupSize += findNeighbors(row, column - 1);
                groupSize += findNeighbors(row - 1, column);
            }
        }
        return groupSize;
    }

    private boolean inBound(int row, int column) {
        return (0 <= row && row < monitoredField.getHeightOfField() && 0 <= column && column < monitoredField.getWidthOfField());
    }

    private boolean hasHuman(int row, int column){
        return (monitoredField.getCellState(row, column) == CellState.FILL);
    }
}
