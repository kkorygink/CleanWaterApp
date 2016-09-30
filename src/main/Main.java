package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.controller.LoginManager;
import java.io.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    LoginManager loginManager = new LoginManager(primaryStage);
    loginManager.showWelcome();
}


    public static void main(String[] args) {
        launch(args);
    }
}
