package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class MaintenanceTask implements Serializable {
    private int requestId;
    private String residentName, requestType, residentAddress, requestDescription;
    private LocalDate taskGivenDate;
    private boolean isCompleted;


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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public MaintenanceTask(int requestId, String residentName, String requestType, String residentAddress, String requestDescription, LocalDate taskGivenDate, boolean isCompleted) {
        this.requestId = requestId;
        this.residentName = residentName;
        this.requestType = requestType;
        this.residentAddress = residentAddress;
        this.requestDescription = requestDescription;
        this.taskGivenDate = taskGivenDate;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "requestId=" + requestId +
                ", residentName='" + residentName + '\'' +
                ", requestType='" + requestType + '\'' +
                ", residentAddress='" + residentAddress + '\'' +
                ", requestDescription='" + requestDescription + '\'' +
                ", taskGivenDate=" + taskGivenDate +
                '}';
    }
}
