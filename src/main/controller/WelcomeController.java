package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * The controller for the welcome screen
 */
public class WelcomeController {
    /**
     * Brings the user to the login screen
     */
    @FXML
    Button loginButton;

    /**
     * Brings the user to the registration screen
     */
    @FXML
    Button registerButton;

    /**
     * Prepares to log in by either showing the login
     * screen or the registration screen
     * @param loginManager The login manager
     */
    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction((ActionEvent event) -> {
            loginManager.showLogin();
        });

        registerButton.setOnAction((ActionEvent event) -> {
            loginManager.showRegister();
        });
    }
}
