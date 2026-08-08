package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.io.Serializable;

public class DutyRotation implements Serializable {
    private String staffName;
    private String currentRole;
    private String previousDuty;
    private int workloadCount;
    private String suggestedDuty;
    private String zoneLocation;
    private String shiftTime;
    private String supervisorName;
    private String nextWeekDuty;


    public DutyRotation(String staffName, String currentRole, String previousDuty, int workloadCount, String suggestedDuty) {
        this.staffName = staffName;
        this.currentRole = currentRole;
        this.previousDuty = previousDuty;
        this.workloadCount = workloadCount;
        this.suggestedDuty = suggestedDuty;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public String getPreviousDuty() {
        return previousDuty;
    }

    public void setPreviousDuty(String previousDuty) {
        this.previousDuty = previousDuty;
    }

    public int getWorkloadCount() {
        return workloadCount;
    }

    public void setWorkloadCount(int workloadCount) {
        this.workloadCount = workloadCount;
    }

    public String getSuggestedDuty() {
        return suggestedDuty;
    }

    public void setSuggestedDuty(String suggestedDuty) {
        this.suggestedDuty = suggestedDuty;
    }

    public String getZoneLocation() {
        return zoneLocation;
    }

    public void setZoneLocation(String zoneLocation) {
        this.zoneLocation = zoneLocation;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getNextWeekDuty() {
        return nextWeekDuty;
    }

    public void setNextWeekDuty(String nextWeekDuty) {
        this.nextWeekDuty = nextWeekDuty;
    }

    @Override
    public String toString() {
        return "DutyRotation{" +
                "staffName='" + staffName + '\'' +
                ", suggestedDuty='" + suggestedDuty + '\'' +
                '}';
    }
}
