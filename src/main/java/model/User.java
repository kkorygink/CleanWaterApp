package main.java.model;

/**
 * A user of the application
 */
public class User {

    /**
     * The user's type (user, worker, admin, etc.)
     */
    private UserType accountType;

    /**
     * The user's ID
     */
    private String userID;

    /**
     * The user's name
     */
    private String name;

    /**
     * The user's password
     */
    private String password;

    /**
     * The user's email
     */
    private String email;

    /**
     * The user's address
     */
    private String address;

    /**
     * Constructs a user from their name, ID, and password
     * @param name The user's name
     * @param userID The user's ID
     * @param password The user's password
     */
    public User(String name, String userID, String password) {
        this.name = name;
        this.userID = userID;
        this.password = password;
    }

    /**
     * Constructs a user from their ID and password
     * @param userID The user's ID
     * @param password The user's password
     */
    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    /**
     * Constructs a user from their name, ID, password, and account type
     * @param name The user's name
     * @param userID The user's ID
     * @param password The user's password
     * @param accountType The user's account type or UserType
     */
    public User(
        String name,
        String userID,
        String password,
        UserType accountType) {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.accountType = accountType;
    }

    /**
     * Gets the user's ID
     * @return The user's ID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user's ID
     * @param userID The user's new ID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Gets the user's name
     * @return The user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name The user's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's password
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password
     * @param password The user's new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's email
     * @return The user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email
     * @param email The user's new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's address
     * @return The user's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address
     * @param address The user's new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the user's account type or UserType
     * @return The user's account type or UserType
     */
    public UserType getAccountType() {
        return accountType;
    }

    /**
     * Sets the user's account type or UserType
     * @param standing The user's new account type or UserType
     */
    public void setAccountType(UserType standing) {
        this.accountType = standing;
    }

    @Override
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
