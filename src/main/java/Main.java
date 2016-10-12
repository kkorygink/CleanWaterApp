import javafx.application.Application;
import javafx.stage.Stage;
import main.java.controller.LoginManager;

/**
 * The main class and entry point of the application.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginManager loginManager = new LoginManager(primaryStage);
        loginManager.showWelcome();
    }

    /**
     * The entry point to the application
     * @param args The arguments to the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
