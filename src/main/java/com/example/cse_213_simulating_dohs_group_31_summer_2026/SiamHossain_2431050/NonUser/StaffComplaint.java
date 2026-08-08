package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.time.LocalDate;

public class StaffComplaint {
    private String staffName;
    private String complaintType;
    private LocalDate incidentDate;
    private String details;
    private String status; // Submitted / Reviewed


    public StaffComplaint(String staffName, String complaintType, LocalDate incidentDate, String details, String status) {
        this.staffName = staffName;
        this.complaintType = complaintType;
        this.incidentDate = incidentDate;
        this.details = details;
        this.status = status;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StaffComplaint{" +
                "staffName='" + staffName + '\'' +
                ", complaintType='" + complaintType + '\'' +
                '}';
    }
}
