package main.java.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Matt on 10/11/2016.
 */
public class WaterReport {

    /**
     * User who made the report
     */
    private User user;
    /**
     * location of water
     */
    private String location;
    /**
     * water type
     */
    private WaterType waterType;
    /**
     * Water condition
     */
    private WaterCond waterCond;
    /**
     * Date of report
     */
    private LocalDate date;
    /**
     * Time of report
     */
    private LocalTime time;
    /**
     * Report number
     */
    private int reportNumber;
    /**
     * User's username
     */
    private String username;

    /**
     * sets user
     * @param user user who made report
     */
    public WaterReport(User user) {
        this.user = user;
        username = user.getUserID();
    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public String getLocation() {
        return location;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public WaterCond getWaterCond() {
        return waterCond;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public void setWaterCond(WaterCond waterCond) {
        this.waterCond = waterCond;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
