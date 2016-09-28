package main.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.User;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login managern which takes care of switching between the application, the welcome screen,
 * login screen and registration screens.
 */
public class LoginManager {
    private Stage primaryStage;

    public LoginManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void logout() {
        showWelcome();
    }

    public void authenticated(User user) {
        showMain(user);
    }

    public void showWelcome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/welcome.fxml"));
            primaryStage.setTitle("Water App - Welcome");
            primaryStage.setScene(new Scene(loader.load(), 500, 400));
            primaryStage.show();

            WelcomeController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
            primaryStage.setTitle("Water App - Login");
            primaryStage.setScene(new Scene(loader.load(), 600, 300));
            primaryStage.show();

            LoginController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showRegister() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/registration.fxml"));
            primaryStage.setTitle("Water App - Register");
            primaryStage.setScene(new Scene(root, 600, 500));
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMain(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/main.fxml"));
            primaryStage.setTitle("Water App");
            primaryStage.setScene(new Scene(loader.load(), 500, 500));
            primaryStage.show();

            MainController controller = loader.getController();
            controller.initUser(user);
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
