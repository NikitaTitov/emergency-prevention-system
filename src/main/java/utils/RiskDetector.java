package utils;


public class RiskDetector {

   public static EmergencyStatus getGroupRisk(int groupSize) {
        int position = 0;
        for (; position < EmergencyStatus.getSizeStatuses(); position++) {
            if (EmergencyStatus.values()[position].getRiskGrade() >= groupSize) {
                return EmergencyStatus.values()[position];
            }
        }
        return EmergencyStatus.values()[position];
    }
}
