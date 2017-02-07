package utils;


import WorkingZone.MonitoredField;
import java.util.Map;
import WorkingZone.utils.MonitoredFieldPrinter;

public class ReportPrinter {
    private MonitoredField field;
    private Map<EmergencyStatus, Integer> groups;

    public ReportPrinter(MonitoredField field, Map<EmergencyStatus, Integer> groups) {
        this.field = field;
        this.groups = groups;
    }

    public String buildReport() {
        StringBuilder report = new StringBuilder();
        report.append(title());
        report.append(splitLine());
        report.append(splitLine());
        report.append(MonitoredFieldPrinter.print(field));
        report.append(splitLine());
        report.append(riskGroupsTitle());
        report.append(splitLine());
        report.append(riskGroups());

        return report.toString();
    }

    private String title() {
        return "EMERGENCY PREVENTION SYSTEM";
    }

    private String riskGroupsTitle() {
        return "Risk groups report:";
    }

    private String riskGroups() {
        StringBuilder builder = new StringBuilder();
        for (EmergencyStatus group : groups.keySet()) {
            builder.append(group + ": " + groups.get(group) + ";");
            builder.append("\n");
        }

        return builder.toString();
    }

    private String splitLine() {
        int amountOfDash = 24;
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int actualSize = 0; actualSize < amountOfDash; actualSize++) {
            builder.append("-");
        }
        builder.append("\n");
        return builder.toString();
    }


}
