package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SecurityInCharge extends User {
    private String securityId;

    public static ArrayList<IncidentLog> incidentLogs = new ArrayList<>();
    public static ArrayList<MaintenanceHazardReport> hazardReports = new ArrayList<>();
    public static ArrayList<ParkingViolationRecord> parkingViolations= new ArrayList<>();
    public static ArrayList<EmergencyAssistanceRequest> emergencyRequests = new ArrayList<>();
    public static ArrayList<Tenant> tenantList = new ArrayList<>();
    public static ArrayList<SilentAlarm> silentAlarms = new ArrayList<>();
    public static ArrayList<PropertyWarning> propertyWarnings = new ArrayList<>();
    public static ArrayList<ShiftSummary> shiftSummaries = new ArrayList<>();


    public SecurityInCharge() {
        super();
        this.securityId = "";
    }

    public SecurityInCharge(String userId, String name, String role, String password, boolean isLoggedIn, String securityId) {
        super(userId, name, role, password, isLoggedIn);
        this.securityId = securityId;

    }

    public static boolean fileIncidentLog(String name, LocalTime time, LocalDate date, String location, String description, String personInvolved) {

        String id = "INC-" + LocalTime.now().toString();
        IncidentLog log = new IncidentLog(id, name, time, date, location, description, personInvolved);
        return incidentLogs.add(log);
    }

    public static boolean reportMaintenanceHazard(String hazardName, LocalDate date, String location, String description) {
        String id = "HAZ-" + LocalTime.now().toString();
        MaintenanceHazardReport report = new MaintenanceHazardReport(id, hazardName, date, location, description);
        return hazardReports.add(report);
    }

    public static boolean logUnauthorizedParking(String licensePlate, String location, LocalTime time, LocalDate date) {

        String id = "PRK-" +LocalTime.now().toString();
        ParkingViolationRecord record = new ParkingViolationRecord(id, licensePlate, location, time, date);
        return parkingViolations.add(record);
    }

    public static boolean sendEmergencyAssistanceRequest(String currentLocation, String description) {

        String id = "EMG-" +LocalTime.now().toString();
        EmergencyAssistanceRequest req = new EmergencyAssistanceRequest(id, currentLocation, description, LocalDateTime.now());
        return emergencyRequests.add(req);
    }

    public static ArrayList<Tenant> checkTenantInformation(String searchQuery) {
        ArrayList<Tenant> results = new ArrayList<>();
        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            return results;
        }
        String query = searchQuery.toLowerCase().trim();
        for (Tenant tenant : tenantList) {
            if (tenant.getTenantId().toLowerCase().contains(query) || tenant.getName().toLowerCase().contains(query)) {
                results.add(tenant);
            }
        }
        return results;
    }

    public static ArrayList<SilentAlarm> reviewActiveSilentAlarms() {
        ArrayList<SilentAlarm> activeList = new ArrayList<>();
        for (SilentAlarm alarm : silentAlarms) {
            if (alarm.isActive()) {
                activeList.add(alarm);
            }
        }
        return activeList;
    }

    public static boolean notePropertyWarning(String address, LocalTime time, LocalDate date, String warningDetails) {

        String id = "WRN-" + LocalTime.now().toString();
        PropertyWarning warning = new PropertyWarning(id, address, time, date, warningDetails);
        return propertyWarnings.add(warning);
    }

    public static boolean submitShiftActivitySummary(String activitiesText) {

        String id = "SUM-" + LocalTime.now().toString();
        ShiftSummary summary = new ShiftSummary(id, activitiesText, LocalDateTime.now());
        return shiftSummaries.add(summary);
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    @Override
    public String toString() {
        return "SecurityInCharge{" +
                "securityId='" + securityId + '\'' +
                ", " + super.toString() +
                '}';
    }
}