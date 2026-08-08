package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import java.io.Serializable;

public class BlacklistedVehicle implements Serializable {
    private String licensePlate;
    private String reasonForBlacklist;

    public BlacklistedVehicle() {
    }

    public BlacklistedVehicle(String licensePlate, String reasonForBlacklist) {
        this.licensePlate = licensePlate;
        this.reasonForBlacklist = reasonForBlacklist;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getReasonForBlacklist() {
        return reasonForBlacklist;
    }

    public void setReasonForBlacklist(String reasonForBlacklist) {
        this.reasonForBlacklist = reasonForBlacklist;
    }

    @Override
    public String toString() {
        return "BlacklistedVehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", reasonForBlacklist='" + reasonForBlacklist + '\'' +
                '}';
    }
}