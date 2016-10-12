package main.java.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.model.User;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login manager which takes care of switching between the application, the welcome screen,
 * login screen and registration screens.
 */
public class LoginManager {

    /**
     * The main stage for the LoginManager
     */
    private Stage primaryStage;

    /**
     * Creates the log in manager
     * @param primaryStage The stage the log in manager will be built on
     */
    public LoginManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Logs the user out by returning them to the welcome screen
     */
    public void logout() {
        showWelcome();
    }

    /**
     * Logs the user in by showing them the main window of the application
     * @param user The user
     */
    public void authenticated(User user) {
        showMain(user);
    }

    /**
     * Shows the welcome screen
     */
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

    /**
     * Shows the login screen
     */
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

    /**
     * Shows the registration screen
     */
    public void showRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/registration.fxml"));
            primaryStage.setTitle("Water App - Register");
            primaryStage.setScene(new Scene(loader.load(), 600, 500));
            primaryStage.show();

            RegisterController controller = loader.getController();
            controller.initManager(this);

        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Shows the main application for a user
     * @param user The user
     */
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

    /**
     * Shows the welcome screen for a user
     * @param user The user
     */
    public void showProfile(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/profile.fxml"));
            primaryStage.setTitle("Water App - Profile");
            primaryStage.setScene(new Scene(loader.load(), 500, 500));
            primaryStage.show();

            ProfileController controller = loader.getController();
            controller.initUser(user);
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showWaterReport(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/waterReport.fxml"));
            primaryStage.setTitle("Water App - Water Report");
            primaryStage.setScene(new Scene(loader.load(), 500, 500));
            primaryStage.show();

            WaterReportController controller = loader.getController();
            controller.initPage(user);
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
