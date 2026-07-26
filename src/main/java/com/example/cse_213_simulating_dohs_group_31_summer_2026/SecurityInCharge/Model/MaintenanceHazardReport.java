package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDate;

public class MaintenanceHazardReport {
    private String reportId;
    private String hazardName;
    private LocalDate date;
    private String location;
    private String description;

    public MaintenanceHazardReport() {
    }

    public MaintenanceHazardReport(String reportId, String hazardName, LocalDate date, String location, String description) {
        this.reportId = reportId;
        this.hazardName = hazardName;
        this.date = date;
        this.location = location;
        this.description = description;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getHazardName() {
        return hazardName;
    }

    public void setHazardName(String hazardName) {
        this.hazardName = hazardName;
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

    @Override
    public String toString() {
        return "MaintenanceHazardReport{" +
                "reportId='" + reportId + '\'' +
                ", hazardName='" + hazardName + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}