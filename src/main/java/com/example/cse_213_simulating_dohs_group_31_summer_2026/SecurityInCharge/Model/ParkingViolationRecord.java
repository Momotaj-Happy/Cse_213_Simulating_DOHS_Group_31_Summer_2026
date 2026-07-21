package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ParkingViolationRecord {
    private String violationId;
    private String licensePlateNumber;
    private String location;
    private LocalTime time;
    private LocalDate date;

    public ParkingViolationRecord() {
    }

    public ParkingViolationRecord(String violationId, String licensePlateNumber, String location, LocalTime time, LocalDate date) {
        this.violationId = violationId;
        this.licensePlateNumber = licensePlateNumber;
        this.location = location;
        this.time = time;
        this.date = date;
    }

    public String getViolationId() {
        return violationId;
    }

    public void setViolationId(String violationId) {
        this.violationId = violationId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ParkingViolationRecord{" +
                "violationId='" + violationId + '\'' +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", date=" + date +
                '}';
    }
}