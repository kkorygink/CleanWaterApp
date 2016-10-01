package main.model;


public class User {

    private UserType accountType;

    private String userID;
    private String name;
    private String password;
    private String email;
    private String address;


    public User(String name, String userID, String password) {
        this.name = name;
        this.userID = userID;
        this.password = password;
    }
    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public User(String name, String userID, String password, UserType accountType) {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.accountType = accountType;

    }

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getAccountType() {
        return accountType;
    }
    public void setAccountType(UserType standing) {
        this.accountType = standing;
    }

    public String toString() {
        return new StringBuffer(" userID: ")
                .append(this.userID)
                .append(" name: ")
                .append(this.name)
                .append(" password: ")
                .append(this.password)
                .append(" email: ")
                .append(this.email)
                .append(" accountType: ")
                .append(this.accountType).toString();
    }


}
