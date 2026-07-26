package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import java.time.LocalDate;

public class PreRegisteredGuest {
    private String preRegId;
    private String licensePlate;
    private String hostResidentName;
    private LocalDate expectedDate;

    public PreRegisteredGuest() {
    }

    public PreRegisteredGuest(String preRegId, String licensePlate, String hostResidentName, LocalDate expectedDate) {
        this.preRegId = preRegId;
        this.licensePlate = licensePlate;
        this.hostResidentName = hostResidentName;
        this.expectedDate = expectedDate;
    }

    public String getPreRegId() {
        return preRegId;
    }

    public void setPreRegId(String preRegId) {
        this.preRegId = preRegId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getHostResidentName() {
        return hostResidentName;
    }

    public void setHostResidentName(String hostResidentName) {
        this.hostResidentName = hostResidentName;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public String toString() {
        return "PreRegisteredGuest{" +
                "preRegId='" + preRegId + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", hostResidentName='" + hostResidentName + '\'' +
                ", expectedDate=" + expectedDate +
                '}';
    }
}