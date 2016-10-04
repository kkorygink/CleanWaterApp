package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import main.model.User;
import main.model.allUsers;

/**
 * Created by random on 9/20/16.
 */
public class ProfileController {
    @FXML
    Text usernameText;
    @FXML
    Text accountTypeText;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    Button saveButton;
    @FXML
    Button cancelButton;

    private User user;

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

    public void initManager(final LoginManager loginManager) {
        saveButton.setOnAction((ActionEvent event) -> {
            if(name.getText() != null || email.getText() != null || !emailTaken() ) {
                user.setEmail(email.getText());
                user.setName(name.getText());
                user.setAddress(address.getText());

            }
            if (emailTaken()) {
                showError("Email is already in use");
                return;
            }
            if (!password.getText().equals(confirmPassword.getText()) || password.getText().replaceAll("\\s+","").isEmpty()) {
                showError("The passwords don't match, please input a valid password");
                return;
            } else {
                user.setPassword(password.getText());
            }
            loginManager.showMain(user);
        });
        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showMain(user);
        });
    }

    private boolean emailTaken() {
        User[] x = allUsers.getUsers();
        if(!user.getEmail().equals(email.getText())) {
            for (int i = 0; i < allUsers.getSize(); i++) {
                if (x[i].getEmail().equals(email.getText())) {
                    return true;
                }
            }
        }
        else {
            return false;
        }

        return false;
    }
    private void showError(String x) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(x);

        alert.showAndWait();
    }

}

