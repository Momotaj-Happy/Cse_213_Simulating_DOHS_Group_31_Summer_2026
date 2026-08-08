package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class AttendanceRecord implements Serializable {
    private String staffName;
    private LocalDate date;
    private String status;

    public AttendanceRecord(String staffName, LocalDate date, String status) {
        this.staffName = staffName;
        this.date = date;
        this.status = status;
    }

    public String getStaffName() {return staffName;}

    public void setStaffName(String staffName) {this.staffName = staffName;}

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "staffName='" + staffName + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}

