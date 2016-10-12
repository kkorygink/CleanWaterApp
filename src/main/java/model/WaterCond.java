package main.java.model;

/**
 * Created by Matthew on 10/11/2016.
 */
public enum WaterCond {

    WASTE("Waste"),

    TREATABLECLEAR("Treatable-Clear"),

    TREATABLEMUDDY("Treatable-Muddy"),

    POTABLE("Potable");

    private String cond;

    WaterCond(String cond) {
        this.cond = cond;
    }

    @Override
    public String toString() {
        return this.cond;
    }
}
