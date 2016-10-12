package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import main.java.model.User;
import main.java.model.WaterReport;
import main.java.model.WaterReportList;
import main.java.model.WaterType;
import main.java.model.WaterCond;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Created by Matthew Lemons on 10/11/2016.
 */
public class WaterReportController {

    /**
     * The user submitting the report
     */
    private User user;


    /**
     * Holds the users name
     */
    @FXML
    private Text nameText;

    /**
     * Holds the report number
     */

    @FXML
    private Text reportNumber;
    /**
     * Holds the time of the report
     */

    @FXML
    private Text reportTime;

    /**
     * Holds the water's location
     */
    @FXML
    private TextField latitude;

    /**
     * Holds the water's location
     */
    @FXML
    private TextField longitude;
    /**
     * Holds the type of water
     */
    @FXML
    private ComboBox<WaterType> typeWater;

    /**
     * Holds the condition of water
     */
    @FXML
    private ComboBox<WaterCond> condWater;

    /**
     * Submits Report
     */
    @FXML
    private Button submitButton;

    /**
     * Cancels Report
     */
    @FXML
    private Button cancelButton;
    /**
     * Holds the time information from when opening the page
     */
    private LocalTime currTime;
    private LocalDate currDate;

    /**
     * Initializes comboboxes
     */
    @FXML
    public void initialize() {
        typeWater.getItems().setAll(WaterType.values());
        condWater.getItems().setAll(WaterCond.values());
    }

    /**
     * Initializes the time and user information
     * @param user user accessing the page
     */
    public void initPage(User user) {
        this.user = user;
        nameText.setText(user.getName());
        currTime = LocalTime.now();
        currDate = LocalDate.now();
        reportTime.setText(currTime.truncatedTo(MINUTES).toString() + " on "
                + currDate.toString());
        reportNumber.setText((WaterReportList.getNumReports() + 1) + "");
    }

    /**
     * Initializes the button functions
     * @param loginManager manager for the page
     */
    public void initManager(final LoginManager loginManager) {
        submitButton.setOnAction((ActionEvent event) -> {
                Double latit = null;
                Double longit = null;
                try {
                    latit = Double.parseDouble(latitude.getText());
                    longit = Double.parseDouble(longitude.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Water Report");
                    alert.setHeaderText(null);
                    alert.setContentText("Latitude and Longitude must be "
                            + "numeric");
                    alert.showAndWait();
                }
                if (latit != null && longit != null
                        && condWater.getValue() != null
                        && typeWater.getValue() != null) {
                    WaterReport report = WaterReportList.newReport(user);
                    report.setTime(currTime);
                    report.setDate(currDate);
                    double[] loc = new double[2];
                    loc[0] = Double.parseDouble(latitude.getText());
                    loc[1] = Double.parseDouble(longitude.getText());
                    report.setLocation(loc);
                    report.setWaterCond(condWater.getValue());
                    report.setWaterType(typeWater.getValue());
                    loginManager.showMain(user);
                } else if (latit != null && longit != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Water Report");
                    alert.setHeaderText(null);
                    alert.setContentText("Fill out the full Report");
                    alert.showAndWait();
                }
            });
        cancelButton.setOnAction((ActionEvent event) -> {
                loginManager.showMain(user);
            });
    }


}
