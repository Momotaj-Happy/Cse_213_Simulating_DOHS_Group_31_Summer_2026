package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import java.time.LocalTime;

public class VisitorEntry {
    private String entryId;
    private String guestName;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private int gateNo;
    private String vehicleNumber;
    private String identification;
    private String status;
    private String entryType;

    public VisitorEntry() {
    }

    public VisitorEntry(String entryId, String guestName, LocalTime timeIn, LocalTime timeOut, int gateNo, String vehicleNumber, String identification, String status, String entryType) {
        this.entryId = entryId;
        this.guestName = guestName;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.gateNo = gateNo;
        this.vehicleNumber = vehicleNumber;
        this.identification = identification;
        this.status = status;
        this.entryType = entryType;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    @Override
    public String toString() {
        return "VisitorEntry{" +
                "entryId='" + entryId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", gateNo=" + gateNo +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", identification='" + identification + '\'' +
                ", status='" + status + '\'' +
                ", entryType='" + entryType + '\'' +
                '}';
    }
}
