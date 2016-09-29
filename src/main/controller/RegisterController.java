package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.model.User;
import main.model.UserType;
import javafx.scene.control.Alert.AlertType;
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

    public void initManager(final LoginManager loginManager) {
        registerButton.setOnAction((ActionEvent event) -> {

            if (username.getText() == null || name.getText() == null || email.getText() == null
                    || password.getText() == null || confirmPassword.getText() == null ||
                    accountType.getSelectionModel().isEmpty()) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("All fields must be filled in");

                alert.showAndWait();
                return;
            }

            if (!password.getText().equals(confirmPassword.getText())) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Passwords don't match");

                alert.showAndWait();
                return;
            }


            if (emailTaken() == false && IDTaken() == false) {
                User user = new User(name.getText(), username.getText(), password.getText());
                user.setEmail(email.getText());
                user.setAccountType(accountType.getSelectionModel().getSelectedItem());


                try {
                    FileOutputStream fileOut = new FileOutputStream("../view/user.txt");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(user);
                    out.close();
                    fileOut.close();
                    loginManager.showMain(user);

                } catch (IOException i) {
                    i.printStackTrace();
                }



            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Email or Username already in use");

                alert.showAndWait();
                return;
            }


        });
        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });
    }

    public boolean IDTaken() {
//        User e = null;
//
//        try {
//            FileInputStream fileIn = new FileInputStream("../view/user.txt");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            while (e != null) {
//                e = (User) in.readObject();
//                if (e.getUserID().equals(username.getText())){
//                    in.close();
//                    fileIn.close();
//                    return true;
//                }
//            }
//            in.close();
//            fileIn.close();
//            return false;
//        } catch (IOException i) {
//            i.printStackTrace();
//            return true;
//        } catch (ClassNotFoundException c) {
//            System.out.println("Employee class not found");
//            c.printStackTrace();
//            return true;
//        }
        return false;
    }

    public boolean emailTaken() {
//        User e = null;
//
//        try {
//            FileInputStream fileIn = new FileInputStream("../view/user.txt");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            while (e != null) {
//                e = (User) in.readObject();
//                if (e.getEmail().equals(email.getText())){
//                    in.close();
//                    fileIn.close();
//                    return true;
//                }
//            }
//            in.close();
//            fileIn.close();
//            return false;
//        } catch (IOException i) {
//            i.printStackTrace();
//            return true;
//        } catch (ClassNotFoundException c) {
//            System.out.println("Employee class not found");
//            c.printStackTrace();
//            return true;
//        }
//    }
        return false;

    }
}