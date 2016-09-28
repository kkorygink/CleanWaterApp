package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import main.model.User;

/**
 * Created by random on 9/20/16.
 */
public class MainController {
    private User user;

    @FXML
    Text nameText;

    @FXML
    Button logoutButton;

    public void initUser(User user) {
        this.user = user;
        nameText.setText(user.getName());
    }

    public void initManager(final LoginManager loginManager) {
        logoutButton.setOnAction((ActionEvent event) -> {
            loginManager.logout();
        });
    }
}