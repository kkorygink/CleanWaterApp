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
 * Created by random on 9/20/16.
 */
public class RegisterController {


    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<UserType> accountType;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    Button registerButton;
    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        accountType.getItems().setAll(UserType.values());

    }
    File fileName = new File("./src/main/Data/user.ser");

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




    private boolean IDTaken() {
        User [] x = allUsers.getUsers();
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (x[i].getUserID().equals(username.getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean emailTaken() {
        User[] x = allUsers.getUsers();
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (x[i].getEmail().equals(email.getText())) {
                return true;
            }
        }
        return false;
    }

    private void showError(String x) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(x);

        alert.showAndWait();
    }

}

