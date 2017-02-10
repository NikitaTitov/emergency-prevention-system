package utils;


public class RankRiskDetector {

   public EmergencyStatus getGroupRisk(int groupSize) {
        int position = 0;
        for (; position < EmergencyStatus.values().length; position++) {
            if (EmergencyStatus.values()[position].getUpBound() >= groupSize) {
                return EmergencyStatus.values()[position];
            }
        }
        return EmergencyStatus.CRITICAL;
    }
}
