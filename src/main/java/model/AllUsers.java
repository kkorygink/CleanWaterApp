package main.java.model;

/**
 * This class is used to implement the RegisterController
 */
public class AllUsers {

    /**
     * Holds the users
     */
    private static User[] x = new User[100];

    /**
     * The number of registered users
     */
    private static int size = 0;

    /**
     * Gets the array of users
     * @return The array of users
     */
    public static User[] getUsers() {
        return x;
    }

    /**
     * Adds a user
     * @param user The user to add
     */
    public static void addUser(User user) {
        x[size] = user;
        size++;
    }

    /**
     * Gets the number of users in the system
     * @return The number of users in the system
     */
    public static int getSize() {
        return size;
    }

}
