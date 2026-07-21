package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDateTime;

public class EmergencyAssistanceRequest {
    private String requestId;
    private String location;
    private String description;
    private LocalDateTime timestamp;

    public EmergencyAssistanceRequest() {
    }

    public EmergencyAssistanceRequest(String requestId, String location, String description, LocalDateTime timestamp) {
        this.requestId = requestId;
        this.location = location;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EmergencyAssistanceRequest{" +
                "requestId='" + requestId + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}