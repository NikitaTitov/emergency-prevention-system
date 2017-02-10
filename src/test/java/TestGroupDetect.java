import TestUtils.DefaultGroups;
import TestUtils.FieldCreator;
import workingzone.MonitoredField;
import org.junit.Test;
import utils.DetectorOfGroups;
import utils.EmergencyStatus;

import java.util.*;

import static org.junit.Assert.*;
import static utils.EmergencyStatus.*;


public class TestGroupDetect {
    @Test
    public void difficultFieldDetect() {
        MonitoredField field = FieldCreator.createFieldFromString(
                "x o o x x x x x\n" +
                "o x o x o x o x\n" +
                "o o x o o x o x\n" +
                "o x o x o x o x\n" +
                "x x o o x o o x\n" +
                "x x o o o x o x\n" +
                "o o x o x o x o\n" +
                "x x x o x o o x\n"
        );

        DetectorOfGroups detector = new DetectorOfGroups(field);

        Map<EmergencyStatus, Integer> expectedGroups = DefaultGroups.createExpected();

        expectedGroups.put(NONE, 9);
        expectedGroups.put(MINOR, 1);
        expectedGroups.put(NORMAL, 1);
        expectedGroups.put(MAJOR, 0);
        expectedGroups.put(CRITICAL, 1);

        assertEquals(expectedGroups, detector.detect());
    }

    @Test
    public void simpleFillFieldsDetect(){
        MonitoredField field = FieldCreator.createFieldFromString(
                "x"
        );

        DetectorOfGroups detector = new DetectorOfGroups(field);

        Map<EmergencyStatus, Integer> expectedGroups = DefaultGroups.createExpected();

        expectedGroups.put(NONE,1);

        assertEquals(expectedGroups,detector.detect());
    }

    @Test
    public void simpleEmptyFieldsDetect(){
        MonitoredField field = FieldCreator.createFieldFromString(
                "o"
        );

        DetectorOfGroups detector = new DetectorOfGroups(field);

        Map<EmergencyStatus, Integer> expectedGroups = DefaultGroups.createExpected();

        expectedGroups.put(NONE,0);

        assertEquals(expectedGroups,detector.detect());
    }

}
