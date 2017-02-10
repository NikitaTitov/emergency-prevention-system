import org.junit.Test;
import utils.EmergencyStatus;
import utils.RankRiskDetector;

import static org.junit.Assert.*;
public class TestRankDetector {

    @Test
    public void testAllRankFinder(){
        int groupSizeNONE = 1;
        int groupSizeMINOR = 3;
        int groupSizeNORMAL = 5;
        int groupSizeMAJOR = 13;
        int groupSizeCRITICAL = 500;

        RankRiskDetector riskDetector = new RankRiskDetector();

        assertEquals(riskDetector.getGroupRisk(groupSizeNONE), EmergencyStatus.NONE);
        assertEquals(riskDetector.getGroupRisk(groupSizeMINOR), EmergencyStatus.MINOR);
        assertEquals(riskDetector.getGroupRisk(groupSizeNORMAL), EmergencyStatus.NORMAL);
        assertEquals(riskDetector.getGroupRisk(groupSizeMAJOR), EmergencyStatus.MAJOR);
        assertEquals(riskDetector.getGroupRisk(groupSizeCRITICAL), EmergencyStatus.CRITICAL);
    }

}
