package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import model.User;
import model.AllUsers;

/**
 * The controller for user profiles
 */
public class ProfileController {

    /**
     * The username
     */
    @FXML
    private Text usernameText;

    /**
     * The type of account (user, worker, admin, etc)
     */
    @FXML
    private Text accountTypeText;

    /**
     * The user's name
     */
    @FXML
    private TextField name;

    /**
     * The user's email
     */
    @FXML
    private TextField email;

    /**
     * The user's address
     */
    @FXML
    private TextField address;

    /**
     * The user's password
     */
    @FXML
    private PasswordField password;

    /**
     * The user's password confirmation
     */
    @FXML
    private PasswordField confirmPassword;

    /**
     * Save's the user's profile
     */
    @FXML
    private Button saveButton;

    /**
     * Cancels editing the user's profile
     */
    @FXML
    private Button cancelButton;

    /**
     * The user
     */
    private User user;

    /**
     * Initializes the user's data into the controller
     * @param user The user
     */
    public void initUser(User user) {
        this.user = user;
        usernameText.setText(user.getUserID());
        accountTypeText.setText(user.getAccountType().toString());
        name.setText(user.getName());
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        confirmPassword.setText(user.getPassword());
        address.setText(user.getAddress());

    }

    /**
     * Initializes the LoginManager and verifies that the user's
     * password is correct.
     * @param loginManager Manages the login
     */
    public void initManager(final LoginManager loginManager) {
        saveButton.setOnAction(
            (ActionEvent event) -> {
                if (name.getText() != null
                    || email.getText() != null
                    || !emailTaken()) {
                    user.setEmail(email.getText());
                    user.setName(name.getText());
                    user.setAddress(address.getText());
                }
                if (emailTaken()) {
                    showError("Email is already in use");
                    return;
                }
                if (!password.getText().equals(confirmPassword.getText())
                    || password.getText().replaceAll("\\s+", "").isEmpty()) {
                    showError("The passwords don't match,"
                        + " please input a valid password");
                    return;
                } else {
                    user.setPassword(password.getText());
                }
                loginManager.showMain(user);
            });
        cancelButton.setOnAction(
            (ActionEvent event) -> {
                loginManager.showMain(user);
            });
    }

    /**
     * Determines if the email is taken
     * @return true if the email is taken
     */
    private boolean emailTaken() {
        User[] x = AllUsers.getUsers();
        if (!user.getEmail().equals(email.getText())) {
            for (int i = 0; i < AllUsers.getSize(); i++) {
                if (x[i].getEmail().equals(email.getText())) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    /**
     * Displays an error to the user
     * @param x The string to display to the user
     */
    private void showError(String x) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(x);

        alert.showAndWait();
    }

}
