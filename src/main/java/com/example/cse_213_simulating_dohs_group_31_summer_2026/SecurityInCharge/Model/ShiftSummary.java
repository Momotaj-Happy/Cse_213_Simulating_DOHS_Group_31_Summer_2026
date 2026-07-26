package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalDateTime;

public class ShiftSummary {
    private String summaryId;
    private String activitiesText;
    private LocalDateTime timestamp;

    public ShiftSummary() {
    }

    public ShiftSummary(String summaryId, String activitiesText, LocalDateTime timestamp) {
        this.summaryId = summaryId;
        this.activitiesText = activitiesText;
        this.timestamp = timestamp;
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId;
    }

    public String getActivitiesText() {
        return activitiesText;
    }

    public void setActivitiesText(String activitiesText) {
        this.activitiesText = activitiesText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ShiftSummary{" +
                "summaryId='" + summaryId + '\'' +
                ", activitiesText='" + activitiesText + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}