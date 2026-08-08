package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class MaintenanceReport implements Serializable {
    private int reportId;
    private String reportDescription;
    private LocalDate reportGenerateTime;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public LocalDate getReportGenerateTime() {
        return reportGenerateTime;
    }

    public void setReportGenerateTime(LocalDate reportGenerateTime) {
        this.reportGenerateTime = reportGenerateTime;
    }

    public MaintenanceReport(int reportId, String reportDescription, LocalDate reportGenerateTime) {
        this.reportId = reportId;
        this.reportDescription = reportDescription;
        this.reportGenerateTime = reportGenerateTime;
    }

    @Override
    public String toString() {
        return "MaintenanceReport{" +
                "reportId=" + reportId +
                ", reportDescription='" + reportDescription + '\'' +
                ", reportGenerateTime=" + reportGenerateTime +
                '}';
    }
}
