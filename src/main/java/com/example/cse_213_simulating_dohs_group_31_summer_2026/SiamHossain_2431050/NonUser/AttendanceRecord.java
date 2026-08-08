package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceRecord {
    private String staffName;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private String status; // Present / Late / Absent / On Leave

    public AttendanceRecord() {
    }

    public AttendanceRecord(String staffName, LocalDate date, LocalTime checkIn, LocalTime checkOut, String status) {
        this.staffName = staffName;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "staffName='" + staffName + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
