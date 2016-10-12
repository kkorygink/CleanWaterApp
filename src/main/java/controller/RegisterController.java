package main.java.controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import main.java.model.UserType;
import main.java.model.AllUsers;
import main.java.model.User;


/**
 * The controller for user registration
 */
public class RegisterController {

    /**
     * User's desired username
     */
    @FXML
    private TextField username;

    /**
     * User's name
     */
    @FXML
    private TextField name;

    /**
     * User's email
     */
    @FXML
    private TextField email;

    /**
     * User's password
     */
    @FXML
    private PasswordField password;

    /**
     * Type of account (user, worker, admin, etc.)
     */
    @FXML
    private ComboBox<main.java.model.UserType> accountType;

    /**
     * Confirmation of the user's password
     */
    @FXML
    private PasswordField confirmPassword;

    /**
     * Completes user registration
     */
    @FXML
    private Button registerButton;

    /**
     * Cancels user registration
     */
    @FXML
    private Button cancelButton;

    /**
     * Initializes the UI components
     */
    @FXML
    public void initialize() {
        accountType.getItems().setAll(UserType.values());

    }

    /**
     * The file containing all the users' data
     */
    private File fileName = new File("./src/main/Data/user.ser");

    /**
     * Initializes the login manager and attempt to register the user
     * @param loginManager The login manager
     */
    public void initManager(final LoginManager loginManager) {
        registerButton.setOnAction(
            (ActionEvent event) -> {
                String passwordText = password.getText();
                String confirmedPasswordText = confirmPassword.getText();
                if (username.getText() == null
                    || name.getText() == null
                    || email.getText() == null
                    || passwordText.replaceAll("\\s+", "").isEmpty()
                    || confirmedPasswordText.replaceAll("\\s+", "").isEmpty()
                    || accountType.getSelectionModel().isEmpty()) {
                    showError("All fields must be filled in");
                    return;
                }

                if (!password.getText().equals(confirmPassword.getText())) {
                    showError("The passwords don't match");
                    return;
                }

                if (!idTaken() && !emailTaken()) {
                    User newUser = new User(
                        name.getText(),
                        username.getText(),
                        password.getText());
                    newUser.setEmail(email.getText());
                    newUser.setAccountType(
                        accountType.getSelectionModel().getSelectedItem());
                    AllUsers.addUser(newUser);
                    loginManager.showMain(newUser);
                } else {
                    showError("The username or email is already taken");
                    return;
                }
            });

        cancelButton.setOnAction(
            (ActionEvent event) -> {
                loginManager.showWelcome();
            });
    }

    /**
     * Checks if the ID is taken
     * @return true if it's taken
     */
    private boolean idTaken() {
        User [] x = AllUsers.getUsers();
        for (int i = 0; i < AllUsers.getSize(); i++) {
            if (x[i].getUserID().equals(username.getText())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the Email is taken
     * @return true if it's taken
     */
    private boolean emailTaken() {
        User[] x = AllUsers.getUsers();
        for (int i = 0; i < AllUsers.getSize(); i++) {
            if (x[i].getEmail().equals(email.getText())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Shows the user an error
     * @param x The string to show the user
     */
    private void showError(String x) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(x);

        alert.showAndWait();
    }

}
