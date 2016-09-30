package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable {

    private UserType accountType;
    private final transient StringProperty userID = new SimpleStringProperty();
    private final transient StringProperty name = new SimpleStringProperty();
    private final transient StringProperty password = new SimpleStringProperty();
    private final transient StringProperty email = new SimpleStringProperty();
    private final transient StringProperty address = new SimpleStringProperty();
    private final ArrayList<String> serial = new ArrayList();

    public User(String name, String userID, String password) {
        this.name.set(name);
        this.userID.set(userID);
        this.password.set(password);
        serial.add(name.toString());
        serial.add(userID.toString());
        serial.add(password.toString());
    }

    public User(String name, String userID, String password, UserType accountType) {
        this.name.set(name);
        this.userID.set(userID);
        this.password.set(password);
        this.accountType = accountType;
        serial.add(name.toString());
        serial.add(userID.toString());
        serial.add(password.toString());
        serial.add(accountType.toString());
    }

    public String getUserID() {
        return userID.get();
    }
    public void setUserID(String userid) { userID.set(userid); }


    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.serial.remove(name.toString());
        this.name.set(name);
        this.serial.add(name.toString());
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.serial.remove(email.toString());
        this.email.set(email);
        this.serial.add(email.toString());
    }

    public String getAddress() {
        return address.get();
    }
    public void setAddress(String address) {
        this.address.set(address);
    }

    public UserType getAccountType() {
        return accountType;
    }
    public void setAccountType(UserType standing) {
        this.accountType = standing;
        this.serial.add(accountType.toString());
    }

    public String toString() {
        return new StringBuffer(" userID : ")
                .append(this.userID)
                .append(" name : ")
                .append(this.name)
                .append(" password : ")
                .append(this.password)
                .append(" email : ")
                .append(this.email)
                .append(" accountType : ")
                .append(this.accountType).toString();
    }
    public ArrayList<String> getSerial() {
        return serial;
    }


}
