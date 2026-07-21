package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class PropertyWarning {
    private String warningId;
    private String propertyAddress;
    private LocalTime time;
    private LocalDate date;
    private String warningDetails;

    public PropertyWarning() {
    }

    public PropertyWarning(String warningId, String propertyAddress, LocalTime time, LocalDate date, String warningDetails) {
        this.warningId = warningId;
        this.propertyAddress = propertyAddress;
        this.time = time;
        this.date = date;
        this.warningDetails = warningDetails;
    }

    public String getWarningId() {
        return warningId;
    }

    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
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

    public String getWarningDetails() {
        return warningDetails;
    }

    public void setWarningDetails(String warningDetails) {
        this.warningDetails = warningDetails;
    }

    @Override
    public String toString() {
        return "PropertyWarning{" +
                "warningId='" + warningId + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", warningDetails='" + warningDetails + '\'' +
                '}';
    }
}