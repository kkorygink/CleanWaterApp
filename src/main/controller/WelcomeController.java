package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {
    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction((ActionEvent event) -> {
            loginManager.showLogin();
        });

        registerButton.setOnAction((ActionEvent event) -> {
            loginManager.showRegister();
        });
    }
}
