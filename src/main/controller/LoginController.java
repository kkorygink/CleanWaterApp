package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.model.User;
import main.model.allUsers;


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
            User user1 = authorize();
            if (user1 != null) {
                loginManager.authenticated(user1);
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
        for (User i : allUsers.getUsers()
                ) {
            if (user.getText().equals(i.getUserID()) && password.getText().equals(i.getPassword())) {
                return i;
            } else {
                return null;
            }
        }
        return null;
    }
}


