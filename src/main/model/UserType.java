package main.model;

/**
 * Created by random on 9/20/16.
 */
public enum UserType {
    USER("User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");

    private String name;

    private UserType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
