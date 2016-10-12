package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import main.java.model.*;

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
    private TextField locWater;

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

    private LocalTime currTime;
    private LocalDate currDate;
    @FXML
    public void initialize() {
        typeWater.getItems().setAll(WaterType.values());
        condWater.getItems().setAll(WaterCond.values());
    }
    public void initPage(User user) {
        this.user = user;
        nameText.setText(user.getName());
        currTime = LocalTime.now();
        currDate = LocalDate.now();
        reportTime.setText(currTime.truncatedTo(MINUTES).toString() +  " on " + currDate.toString());
        reportNumber.setText((WaterReportList.getNumReports()+1) + "");
    }

    public void initManager(final LoginManager loginManager) {
        submitButton.setOnAction((ActionEvent event) -> {

            if(!locWater.getText().equals("") && condWater.getValue() != null && typeWater.getValue() != null ) {
                WaterReport report = WaterReportList.newReport(user);
                report.setTime(currTime);
                report.setDate(currDate);
                report.setLocation(locWater.getText());
                report.setWaterCond(condWater.getValue());
                report.setWaterType(typeWater.getValue());
                loginManager.showMain(user);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Water Report");
                alert.setHeaderText(null);
                alert.setContentText("Fill out the full Report");
                alert.showAndWait();
            }
        });
    }


}
