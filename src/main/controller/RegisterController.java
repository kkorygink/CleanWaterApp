package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.model.UserType;
import javafx.scene.control.Alert.AlertType;
<<<<<<< HEAD
import main.model.allUsers;
import main.model.User;
=======
import java.io.*;
import java.util.ArrayList;

>>>>>>> 16a555eada9771146268030c60a016d38f12ddf1

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

    public void initManager(final LoginManager loginManager){
        registerButton.setOnAction((ActionEvent event) -> {


            if (username.getText() == null || name.getText() == null || email.getText() == null
                    || password.getText() == null || confirmPassword.getText() == null ||
                    accountType.getSelectionModel().isEmpty()) {

                showError("All fields must be filled in");
                return;
            }

            if (!password.getText().equals(confirmPassword.getText())) {

                showError("The passwords don't match");
                return;
            }

            if (!IDTaken() && !emailTaken()) {

<<<<<<< HEAD
                User newUser = new User(name.getText(), username.getText(), password.getText());
                newUser.setEmail(email.getText());
                newUser.setAccountType(accountType.getSelectionModel().getSelectedItem());
                allUsers.addUser(newUser);
                loginManager.showMain(newUser);
=======
            if (emailTaken() == false && IDTaken() == false) {
                User user = new User(name.getText(), username.getText(), password.getText());
                user.setEmail(email.getText());
                user.setAccountType(accountType.getSelectionModel().getSelectedItem());


                try {
                    FileOutputStream fileOut = new FileOutputStream(fileName, true);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(user);
                    out.close();
                    fileOut.close();
                    loginManager.showMain(user);

                } catch (IOException i) {
                    i.printStackTrace();
                }


>>>>>>> 16a555eada9771146268030c60a016d38f12ddf1

            } else {
                showError("The username or email is already taken");
                return;

            }

        });
        cancelButton.setOnAction((ActionEvent event) -> {
            loginManager.showWelcome();
        });
    }

<<<<<<< HEAD
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
        User [] x = allUsers.getUsers();
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (x[i].getEmail().equals(email.getText())) {
                return true;
            }
        }
=======
    public boolean IDTaken() {
        User e = null;

        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

           while (in.available() > 0) {
               e = (User) in.readObject();
                if (e.getSerial().contains(username.toString())){
                    in.close();
                    fileIn.close();
                    return true;
                }
           }
            in.close();
            fileIn.close();
            return false;
        } catch (IOException i) {
            i.printStackTrace();
            return true;
        } catch (ClassNotFoundException c) {
            System.out.println("User class not found");
            c.printStackTrace();
            return true;
        }
    }

    public boolean emailTaken() {
//        User e = null;
//
//        try {
//            FileInputStream fileIn = new FileInputStream(fileName);
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
>>>>>>> 16a555eada9771146268030c60a016d38f12ddf1
        return false;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

    }

<<<<<<< HEAD
    private void showError(String x) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(x);

        alert.showAndWait();
    }

}
=======
}
>>>>>>> 16a555eada9771146268030c60a016d38f12ddf1
