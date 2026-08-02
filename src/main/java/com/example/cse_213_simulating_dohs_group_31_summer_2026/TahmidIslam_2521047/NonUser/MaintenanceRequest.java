package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.time.LocalDate;

public class MaintenanceRequest {
    private int requestId;
    private String residentName, requestType, residentAddress, requestDescription;
    private LocalDate taskGivenDate;


    public int getRequestId() {
        return requestId;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    public LocalDate getTaskGivenDate() {
        return taskGivenDate;
    }

    public void setTaskGivenDate(LocalDate taskGivenDate) {
        this.taskGivenDate = taskGivenDate;
    }

    public MaintenanceRequest(int requestId, String residentName, String requestType, String residentAddress, String requestDescription, LocalDate taskGivenDate) {
        this.requestId = requestId;
        this.residentName = residentName;
        this.requestType = requestType;
        this.residentAddress = residentAddress;
        this.requestDescription = requestDescription;
        this.taskGivenDate = taskGivenDate;
    }
}
