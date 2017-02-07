package utils;


public enum EmergencyStatus {
    NONE(0),
    MINOR(2),
    NORMAL(4),
    MAJOR(7),
    CRITICAL(13);

    EmergencyStatus(int riskGrade) {
        this.riskGrade = riskGrade;
    }

    private int riskGrade;

    public int getRiskGrade() {
        return riskGrade;
    }

    public static int getSizeStatuses() {
        return EmergencyStatus.values().length;
    }
}
