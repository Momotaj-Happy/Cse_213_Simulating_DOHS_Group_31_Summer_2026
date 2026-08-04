package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class GateMan extends User {
    private String gateManId;

    public static ArrayList<ResidentVehicle> residentVehicles;
    public static ArrayList<VisitorEntry> visitorEntries;
    public static ArrayList<PreRegisteredGuest> preRegisteredGuests;
    public static ArrayList<BlacklistedVehicle> blacklistedVehicles;
    public static ArrayList<EmergencyRequest> emergencyRequests;
    public static GateControl gateControl;

    public GateMan() {
        super();
        this.gateManId = "";

    }

    public GateMan(String userId, String name, String role, String password, boolean isLoggedIn, String gateManId) {
        super(userId, name, role, password, isLoggedIn);
        this.gateManId = gateManId;
    }



    public static ArrayList<ResidentVehicle> searchResidentVehiclePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return null;
        }
        ArrayList<ResidentVehicle> filterArrayList = new ArrayList<>();
        for(ResidentVehicle rv : residentVehicles){
            if(rv.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())){
                filterArrayList.add(rv);
            }
        }
        return filterArrayList;
    }

    public static boolean logVisitorEntry(String guestName, LocalTime entryTime, int gateNo, String vehicleNo) {
        if (guestName == null || guestName.trim().isEmpty() || gateNo <= 0) {
            return false;
        }
        String entryId = "V-Entry-" + LocalTime.now().toString();
        VisitorEntry newVisitorEntry = new VisitorEntry(
                entryId,
                guestName,
                entryTime,
                null,
                gateNo,
                vehicleNo,
                "",
                "inside",
                "vehicle"

        );
        return visitorEntries.add(newVisitorEntry);

    }

    public static boolean verifyPreRegisteredGuest(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            return false;
        }
        for (PreRegisteredGuest guest : preRegisteredGuests) {
            if (guest.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return true;
            }
        }
        return false;
    }

    public static boolean denyBlacklistedVehicle(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return false;
        }
        for (BlacklistedVehicle blacklisted : blacklistedVehicles) {
            if (blacklisted.getLicensePlate().equalsIgnoreCase(licensePlate.trim())) {
                String reqId = "REQ-" + UUID.randomUUID().toString().substring(0, 6);
                EmergencyRequest request = new EmergencyRequest(reqId, licensePlate, LocalDateTime.now());
                emergencyRequests.add(request);
                return true;
            }
        }
        return false;
    }

    public static String toggleEmergencyGateBypass(boolean isSelected) {
        if (isSelected){
            gateControl.setCurrentStatus("Emergency Gate OPEN");
            gateControl.setBypassModeActive(true);
        }
        else {
            gateControl.setBypassModeActive(false);
        }
        return gateControl.getCurrentStatus();
    }

    public static boolean logVehicleExit(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return false;
        }
        for (VisitorEntry entry : visitorEntries) {
            if (entry.getVehicleNumber().equalsIgnoreCase(licensePlate) && "Inside".equalsIgnoreCase(entry.getStatus())) {
                entry.setStatus("Departed");
                entry.setTimeOut(LocalTime.now());
                return true;
            }
        }
        return false;
    }

    public static boolean registerWalkInPedestrian(String pedestrianName, String identification, LocalTime entryTime, int gateNo) {
        if (pedestrianName == null || pedestrianName.trim().isEmpty() || identification == null || identification.trim().isEmpty()) {
            return false;
        }
        String entryId = "P-Entry-" + LocalTime.now().toString();
        VisitorEntry newVisitorEntry = new VisitorEntry(
                entryId,
                pedestrianName,
                entryTime,
                null,
                gateNo,
                "N/A",
                identification,
                "inside",
                "pedestrian"
        );
        return visitorEntries.add(newVisitorEntry);
    }

    public static ArrayList<VisitorEntry> viewGuestListSummary(LocalDate targetDate) {
        return new ArrayList<>(visitorEntries);
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