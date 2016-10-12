package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 10/11/2016.
 */
public class WaterReportList {

    private static List<WaterReport> reports = new ArrayList<WaterReport>();

    private static int numReports = 0;

    public static List<WaterReport> getReports() {
        return reports;
    }

    public static int getNumReports() {
        return numReports;
    }

    public static WaterReport newReport(User user) {
        numReports++;
        WaterReport report = new WaterReport(user);
        report.setReportNumber(numReports);
        reports.add(report);
        return report;
    }

}
