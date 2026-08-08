package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class OccasionSchedule implements Serializable {
    private String occasionName;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String serviceType;
    private String affectedAreas;
    private String status;


    public OccasionSchedule(String occasionName, LocalDate date, String startTime, String endTime, String serviceType, String affectedAreas, String status) {
        this.occasionName = occasionName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceType = serviceType;
        this.affectedAreas = affectedAreas;
        this.status = status;
    }

    public String getOccasionName() {
        return occasionName;
    }

    public void setOccasionName(String occasionName) {
        this.occasionName = occasionName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAffectedAreas() {
        return affectedAreas;
    }

    public void setAffectedAreas(String affectedAreas) {
        this.affectedAreas = affectedAreas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OccasionSchedule{" +
                "occasionName='" + occasionName + '\'' +
                ", date=" + date +
                '}';
    }
}
