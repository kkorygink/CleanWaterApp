package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import model.allUsers;

/**
 * The controller for logins
 */
public class LoginController {

    /**
     * Holds the user's name
     */
    @FXML
    private TextField user;

    /**
     * Holds the user's password
     */
    @FXML
    private PasswordField password;

    /**
     * Logs the user in
     */
    @FXML
    private Button loginButton;

    /**
     * Cancels the log-in form
     */
    @FXML
    private Button cancelButton;

    /**
     * Run on initialization
     */
    @FXML
    public void initialize() {
    }

    /**
     * Authorizes a user with the login manager. Fails
     * with an alert if the user cannot be authenticated.
     * @param loginManager The LoginManager
     */
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
     * Check authorization credentials and return an authorized user
     * @return The authorized user. Returns null upon failure.
     */
    private User authorize() {
        for (User i : allUsers.getUsers()) {
            if (user.getText().equals(i.getUserID()) && password.getText().equals(i.getPassword())) {
                return i;
            } else {
                return null;
            }
        }
        return null;
    }
}
