package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.model.User;
import main.model.UserType;

/**
 * Created by random on 9/20/16.
 */
public class RegisterController {
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField email;;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<UserType> accountType;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelButton1;

    @FXML
    public void initialize() {
        accountType.getItems().setAll(UserType.values());
    }

    public void initManager(final LoginManager loginManager) {
        cancelButton1.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });

        registerButton.setOnAction((ActionEvent event) -> {
            loginManager.showLogin();
        });
    }

}
