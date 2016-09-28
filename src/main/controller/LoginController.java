package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.model.User;
import main.model.UserType;


public class LoginController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
    }

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction((ActionEvent event) -> {
            User user = authorize();
            if (user != null) {
                loginManager.authenticated(user);
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid username and password").show();
            }
        });

        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });
    }

    /**
     * Check authorization credentials.
     * <p>
     * If accepted, return a sessionID for the authorized session
     * otherwise, return null.
     */
    private User authorize() {
        return "user".equals(user.getText()) && "pass".equals(password.getText())
                ? new User("Test User", "user", "pass")
                : null;
    }
}
