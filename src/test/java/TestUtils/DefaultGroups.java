package TestUtils;

import utils.EmergencyStatus;

import java.util.Map;
import java.util.TreeMap;

public class DefaultGroups {
    public static Map<EmergencyStatus, Integer> createExpected() {
        Map<EmergencyStatus, Integer> result = new TreeMap<>();
        for (EmergencyStatus group : EmergencyStatus.values()) {
            result.put(group, 0);
        }
        return result;
    }
}
