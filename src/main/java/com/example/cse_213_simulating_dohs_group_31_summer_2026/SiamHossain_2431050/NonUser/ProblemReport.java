package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;


public class ProblemReport {
    private String reportId;
    private String type;
    private String location;
    private String reportingStaff;
    private String status; // Pending / Assigned / Escalated / Resolved
    private String description;


    public ProblemReport(String reportId, String type, String location, String reportingStaff, String status, String description) {
        this.reportId = reportId;
        this.type = type;
        this.location = location;
        this.reportingStaff = reportingStaff;
        this.status = status;
        this.description = description;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReportingStaff() {
        return reportingStaff;
    }

    public void setReportingStaff(String reportingStaff) {
        this.reportingStaff = reportingStaff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProblemReport{" +
                "reportId='" + reportId + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
