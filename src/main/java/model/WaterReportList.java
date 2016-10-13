package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Created by Matt on 10/11/2016.
 */
public class WaterReportList {

    /**
     * A list of all reports
     */
    private static ObservableList<WaterReport> reports =
            FXCollections.observableArrayList();

    private static int numReports = 0;

    public static ObservableList<WaterReport> getReports() {
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
