package main.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Matt on 10/11/2016.
 */
public class WaterReport {

    private User user;

    private String location;

    private WaterType waterType;

    private WaterCond waterCond;

    private LocalDate date;

    private LocalTime time;

    private int reportNumber;

    public WaterReport(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
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
