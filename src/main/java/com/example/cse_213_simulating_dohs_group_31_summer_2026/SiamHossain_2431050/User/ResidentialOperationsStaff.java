package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.StaffComplaint;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

import java.time.LocalTime;
import java.util.ArrayList;

public class ResidentialOperationsStaff extends User {

    private String staffId;
    private String dutyType;
    private String zoneLocation;
    private String shiftTime;
    private String supervisorName;
    private boolean checkedIn;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;


    public ResidentialOperationsStaff() {
        super();
        this.staffId = "";
        this.checkedIn = false;
    }

    public ResidentialOperationsStaff(int userId, String name, String role, String password, boolean isLoggedIn, String staffId, String dutyType, String zoneLocation, String shiftTime, String supervisorName, boolean checkedIn) {
        super(userId, name, role, password, isLoggedIn);
        this.staffId = staffId;
        this.dutyType = "Cleaner";
        this.zoneLocation = "Road No 5";
        this.shiftTime = "8:00 AM - 4:00 PM";
        this.supervisorName = "Staff Supervisor";
        this.checkedIn = false;
    }
    public static ArrayList<StaffComplaint> complaintList = new ArrayList<>();

    public String getStaffId() {return staffId;}

    public String getDutyType() {return dutyType;}

    public String getZoneLocation() {return zoneLocation;}

    public String getShiftTime() {return shiftTime;}

    public String getSupervisorName() {return supervisorName;}

    public boolean isCheckedIn() {return checkedIn;}

    public LocalTime getCheckInTime() {return checkInTime;}

    public LocalTime getCheckOutTime() {return checkOutTime;}

    public void setStaffId(String staffId) {this.staffId = staffId;}

    public void setDutyType(String dutyType) {this.dutyType = dutyType;}

    public void setZoneLocation(String zoneLocation) {this.zoneLocation = zoneLocation;}

    public void setShiftTime(String shiftTime) {this.shiftTime = shiftTime;}

    public void setSupervisorName(String supervisorName) {this.supervisorName = supervisorName;}

    @Override
    public String toString() {
        return "ResidentialOperationsStaff{" +
                "staffId='" + staffId + '\'' +
                ", dutyType='" + dutyType + '\'' +
                ", zoneLocation='" + zoneLocation + '\'' +
                ", shiftTime='" + shiftTime + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                ", checkedIn=" + checkedIn +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
