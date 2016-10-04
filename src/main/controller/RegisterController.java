package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.model.UserType;
import javafx.scene.control.Alert.AlertType;
import main.model.allUsers;
import main.model.User;
import java.io.*;


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
    private ComboBox<UserType> accountType;

    /**
     * Confirmation of the user's password
     */
    @FXML
    private PasswordField confirmPassword;

    /**
     * Completes user registration
     */
    @FXML
    Button registerButton;

    /**
     * Cancels user registration
     */
    @FXML
    Button cancelButton;

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
    File fileName = new File("./src/main/Data/user.ser");

    /**
     * Initializes the login manager and attempt to register the user
     * @param loginManager The login manager
     */
    public void initManager(final LoginManager loginManager) {
        registerButton.setOnAction((ActionEvent event) -> {


            if (username.getText() == null || name.getText() == null || email.getText() == null
                    || password.getText().replaceAll("\\s+","").isEmpty()  || confirmPassword.getText().replaceAll("\\s+","").isEmpty() ||
                    accountType.getSelectionModel().isEmpty()) {

                showError("All fields must be filled in");
                return;
            }

            if (!password.getText().equals(confirmPassword.getText())) {

                showError("The passwords don't match");
                return;
            }

            if (!IDTaken() && !emailTaken()) {
                User newUser = new User(name.getText(), username.getText(), password.getText());
                newUser.setEmail(email.getText());
                newUser.setAccountType(accountType.getSelectionModel().getSelectedItem());
                allUsers.addUser(newUser);
                loginManager.showMain(newUser);
            }
            else {
                showError("The username or email is already taken");
                return;

            }

        });

        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });
    }

    /**
     * Checks if the ID is taken
     * @return true if it's taken
     */
    private boolean IDTaken() {
        User [] x = allUsers.getUsers();
        for (int i = 0; i < allUsers.getSize(); i++) {
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
        User[] x = allUsers.getUsers();
        for (int i = 0; i < allUsers.getSize(); i++) {
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
