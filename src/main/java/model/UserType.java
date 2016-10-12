package main.java.model;

/**
 * User types (User, Worker, Admin, etc.)
 */
public enum UserType {
    /**
     * User
     */
    USER("User"),

    /**
     * Worker
     */
    WORKER("Worker"),

    /**
     * Manager
     */
    MANAGER("Manager"),

    /**
     * Admin
     */
    ADMIN("Admin");

    private String name;

    private UserType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
