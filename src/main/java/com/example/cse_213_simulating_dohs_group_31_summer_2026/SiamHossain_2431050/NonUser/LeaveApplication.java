package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class LeaveApplication implements Serializable {
    private String leaveId;
    private String staffName;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status; // Pending / Approved / Rejected
    private int totalDays;

    public LeaveApplication(String leaveId, String staffName, String leaveType, LocalDate startDate, LocalDate endDate, String reason, String status, int totalDays) {
        this.leaveId = leaveId;
        this.staffName = staffName;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
        this.totalDays = totalDays;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    @Override
    public String toString() {
        return "LeaveApplication{" +
                "leaveId='" + leaveId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
