package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import model.WaterReport;
import model.WaterReportList;
import model.WaterType;
import model.WaterCond;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Created by Matt on 10/12/2016.
 */
public class WaterReportListController {
    /**
     * user accessing list
     */
    private User user;

    /**
     * Table containing reports
     */
    @FXML
    private TableView<WaterReport> waterReportTable;

    /**
     * Column of report numbers
     */
    @FXML
    private TableColumn reportNumberCol;

    /**
     * Column of usernames
     */
    @FXML
    private TableColumn userCol;

    /**
     * Column of locations
     */
    @FXML
    private TableColumn locCol;

    /**
     * Column of Water types
     */
    @FXML
    private TableColumn typeCol;
    /**
     * Column of Water Condition
     */
    @FXML
    private TableColumn condCol;
    /**
     * Column of Dates
     */
    @FXML
    private TableColumn dateCol;
    /**
     * Column of Time
     */
    @FXML
    private TableColumn timeCol;
    /**
     * Button to return to main page
     */
    @FXML
    private Button returnButton;

    /**
     * Initializes table to contain reports
     */
    public void initialize() {
        ObservableList<WaterReport> waterReport = WaterReportList.getReports();
        reportNumberCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, Integer>("reportNumber"));
        userCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, String>("username"));
        locCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, String>("locationStr"));
        typeCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, WaterType>("waterType"));
        condCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, WaterCond>("waterCond"));
        dateCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, LocalDate>("date"));
        timeCol.setCellValueFactory(
                new PropertyValueFactory<WaterReport, LocalTime>("time"));
        waterReportTable.setItems(waterReport);

    }

    /**
     * Requires being a user to open page
     * @param user user accessing page
     */
    public void initPage(User user) {
        this.user = user;
    }

    /**
     * Initializes the manager for the page to control buttons
     * @param loginManager manager for the page
     */
    public void initManager(final LoginManager loginManager) {
        returnButton.setOnAction((ActionEvent event) -> {
                loginManager.showMain(user);
            });
    }
}
