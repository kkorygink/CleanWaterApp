package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import main.java.model.User;

/**
 * The main application controller
 */
public class MainController {

    /**
     * The user viewing the main controller
     */
    private User user;

    /**
     * The name of the user
     */
    @FXML
    private Text nameText;

    /**
     * Logs the user out
     */
    @FXML
    private Button logoutButton;

    /**
     * Shows the user's profile
     */
    @FXML
    private Button profileButton;

    /**
     * Shows water report form
     */
    @FXML
    private Button submitReportButton;

    /**
     * Shows List of Water Reports
     */
    @FXML
    private Button reportListButton;

    /**
     * Initializes the user's data
     * @param user The user
     */
    public void initUser(User user) {
        this.user = user;
        nameText.setText(user.getName());
    }

    /**
     * Initializes the LoginManager
     * @param loginManager The login manager
     */
    public void initManager(final LoginManager loginManager) {
        profileButton.setOnAction((ActionEvent event) -> {
                loginManager.showProfile(user);
            });

        logoutButton.setOnAction((ActionEvent event) -> {
                loginManager.logout();
            });

        submitReportButton.setOnAction((ActionEvent event) -> {
                loginManager.showWaterReport(user);
            });

        reportListButton.setOnAction((ActionEvent event) -> {
                loginManager.showWaterReportList(user);
            });
    }
}