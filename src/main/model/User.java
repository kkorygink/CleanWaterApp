package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;


public class User implements Serializable {

    private UserType accountType;
    private final StringProperty userID = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();

    public User(String name, String userID, String password) {
        this.name.set(name);
        this.userID.set(userID);
        this.password.set(password);
    }

    public User(String name, String userID, String password, UserType accountType) {
        this.name.set(name);
        this.userID.set(userID);
        this.password.set(password);
        this.accountType = accountType;
    }

    public String getUserID() {
        return userID.get();
    }
    public void setUserID(String userid) { userID.set(userid); }


    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
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
        this.email.set(email);
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
        this.accountType = accountType;
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
}
