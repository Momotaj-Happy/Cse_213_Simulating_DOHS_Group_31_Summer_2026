package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import java.time.LocalDateTime;

public class EmergencyRequest {
    private String requestId;
    private String plateNumber;
    private LocalDateTime timestamp;

    public EmergencyRequest() {
    }

    public EmergencyRequest(String requestId, String plateNumber, LocalDateTime timestamp) {
        this.requestId = requestId;
        this.plateNumber = plateNumber;
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EmergencyRequest{" +
                "requestId='" + requestId + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}