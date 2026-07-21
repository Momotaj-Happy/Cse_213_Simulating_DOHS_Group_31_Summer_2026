package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GateMan extends User {
    private String gateManId;

    public GateMan() {
        super();
    }

    public GateMan(String userId, String name, String role, boolean isLoggedIn, String gateManId) {
        super(userId, name, role, isLoggedIn);
        this.gateManId = gateManId;
    }

    public ResidentVehicle searchResidentVehiclePlate(String licensePlate) {
        return new ResidentVehicle();
    }

    public boolean logVisitorEntry(String guestName, LocalTime time, int gateNo, String vehicleNumber) {
        return true;
    }

    public boolean verifyPreRegisteredGuest(String licensePlate) {
        return true;
    }

    public EmergencyRequest denyBlacklistedVehicle(String licensePlate) {
        return new EmergencyRequest();
    }

    public boolean toggleEmergencyGateBypass() {
        return true;
    }

    public boolean logVehicleExit(String licensePlate) {
        return true;
    }

    public boolean registerWalkInPedestrian(String pedestrianName, String identification, LocalTime time) {
        return true;
    }

    public List<VisitorEntry> viewGuestListSummary(LocalDate targetDate) {
        return new ArrayList<>();
    }

    public String getGateManId() {
        return gateManId;
    }

    public void setGateManId(String gateManId) {
        this.gateManId = gateManId;
    }

    @Override
    public String toString() {
        return "GateMan{" +
                "gateManId='" + gateManId + '\'' +
                ", " + super.toString() +
                '}';
    }
}