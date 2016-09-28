package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    Button registerButton;
    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        accountType.getItems().setAll(UserType.values());
    }

    public void initManager(final LoginManager loginManager) {
//        registerButton.setOnAction((ActionEvent event) -> {
//            User user = authorize();
//            if (user != null) {
//                loginManager.authenticated(user);
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Please complete all fields").show();
//            }
//        });
        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });
    }
//
//    private User authorize() {
//        if (password.equals(confirmPassword)){
//            return null;
//        }
//        return null;
//    }
}
