import WorkingZone.MonitoredField;
import org.apache.commons.cli.ParseException;
import utils.DetectorOfGroups;
import utils.EmergencyStatus;
import utils.RandomFiller;
import utils.ReportPrinter;
import utils.cli.CLIParser;
import utils.cli.IncomeData;

import java.util.Map;

public class Application {
    public static void main(String args[]) {


        try {
            CLIParser parser = new CLIParser();
            IncomeData incomeData = parser.parse(args);
            MonitoredField field = new MonitoredField(incomeData.getHeight(), incomeData.getWidth());
            RandomFiller.fill(field, incomeData.getFillFactor());
            DetectorOfGroups detector = new DetectorOfGroups(field);
            Map<EmergencyStatus, Integer> groups = detector.detect();
            ReportPrinter reportPrinter = new ReportPrinter(field, groups);
            System.out.println(reportPrinter.buildReport());
        } catch (ParseException e) {
            System.out.println("ParseException in main class");
        }
    }
}
