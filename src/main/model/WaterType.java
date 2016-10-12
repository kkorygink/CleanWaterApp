package main.model;

/**
 * Created by Matt on 10/11/2016.
 */
public enum WaterType {

    BOTTLED("Bottled"),

    WELL("Well"),

    STREAM("Stream"),

    LAKE("Lake"),

    SPRING("String"),

    OTHER("Other");

    private String type;

    WaterType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
