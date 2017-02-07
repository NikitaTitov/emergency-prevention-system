import WorkingZone.MonitoredField;
import org.junit.Test;
import utils.DetectorOfGroups;
import utils.EmergencyStatus;
import utils.RiskDetector;

import java.util.Map;
import java.util.TreeMap;

import static WorkingZone.CellState.*;

import static org.junit.Assert.*;


public class TestEmergencySystem {
    @Test
    public void detect(){
        MonitoredField field = new MonitoredField(4,4);
        field.setCellValue(0,0,FILL);// x - - -
        field.setCellValue(1,1,FILL);// - x x -
        field.setCellValue(1,2,FILL);// - x - -
        field.setCellValue(2,1,FILL);// - - - -

        DetectorOfGroups detector = new DetectorOfGroups(field);

        Map<EmergencyStatus,Integer> expectedGroups = new TreeMap<EmergencyStatus, Integer>();
        for (EmergencyStatus group : EmergencyStatus.values()) {
            expectedGroups.put(group, 0);
        }
        expectedGroups.put(EmergencyStatus.MINOR, 1);
        expectedGroups.put(EmergencyStatus.NORMAL, 1);

        assertEquals(expectedGroups, detector.detect());
    }

    @Test
    public void getGroupRisk(){
        EmergencyStatus status = RiskDetector.getGroupRisk(3);
        EmergencyStatus expectedStatus = EmergencyStatus.NORMAL;
        assertEquals(status,expectedStatus);
    }

    @Test
    public void emergencyStatus(){
        EmergencyStatus status = EmergencyStatus.CRITICAL;
        int expectedGrade = 13;
        int expectedSize = 5;

        assertEquals(status.getRiskGrade(),expectedGrade);
        assertEquals(EmergencyStatus.getSizeStatuses(),expectedSize);
    }
}