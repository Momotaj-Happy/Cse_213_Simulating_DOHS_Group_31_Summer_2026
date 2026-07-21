package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class IncidentLog {
    private String logId;
    private String name;
    private LocalTime time;
    private LocalDate date;
    private String location;
    private String description;
    private String personInvolved;

    public IncidentLog() {
    }

    public IncidentLog(String logId, String name, LocalTime time, LocalDate date, String location, String description, String personInvolved) {
        this.logId = logId;
        this.name = name;
        this.time = time;
        this.date = date;
        this.location = location;
        this.description = description;
        this.personInvolved = personInvolved;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonInvolved() {
        return personInvolved;
    }

    public void setPersonInvolved(String personInvolved) {
        this.personInvolved = personInvolved;
    }

    @Override
    public String toString() {
        return "IncidentLog{" +
                "logId='" + logId + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", personInvolved='" + personInvolved + '\'' +
                '}';
    }
}