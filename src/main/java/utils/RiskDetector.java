package utils;


public class RiskDetector {
    private static double riskTable[] = {2, 4, 7, 13};

    static EmergencyStatus getGroupRisk(int groupSize) {
        int position = 0;
        for (; position < riskTable.length; position++) {
            if (riskTable[position] >= groupSize) {
                return EmergencyStatus.values()[position];
            }
        }
        return EmergencyStatus.values()[position];
    }
}
