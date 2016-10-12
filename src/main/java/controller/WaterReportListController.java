package main.java.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.java.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Created by Matt on 10/12/2016.
 */
public class WaterReportListController {

    private User user;

    @FXML
    private TableView<WaterReport> waterReportTable;

    @FXML
    private TableColumn reportNumberCol;

    @FXML
    private TableColumn userCol;

    @FXML
    private TableColumn LocCol;

    @FXML
    private TableColumn TypeCol;

    @FXML
    private TableColumn CondCol;

    @FXML
    private TableColumn DateCol;

    @FXML
    private TableColumn TimeCol;

    @FXML
    Button returnButton;

    public void initialize() {
        ObservableList<WaterReport> waterReport = FXCollections.observableArrayList();
        waterReport.setAll(WaterReportList.getReports());
        reportNumberCol.setCellValueFactory(new PropertyValueFactory<WaterReport, Integer>("reportNumber"));
        waterReportTable.setItems(waterReport);

    }
    public void initPage(User user) {
        this.user = user;
    }
    public void initManager(final LoginManager loginManager) {
        returnButton.setOnAction((ActionEvent event) -> {
            loginManager.showMain(user);
        });
    }






}
