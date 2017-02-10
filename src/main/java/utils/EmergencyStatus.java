package utils;


public enum EmergencyStatus {
    NONE(2),
    MINOR(4),
    NORMAL(7),
    MAJOR(13),
    CRITICAL(Integer.MAX_VALUE);

    EmergencyStatus(int upBound) {
        this.upBound = upBound;
    }

    private int upBound;

    public int getUpBound() {
        return upBound;
    }
}
