package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SecurityInCharge extends User implements Serializable {
    private String securityId;

    public static ArrayList<IncidentLog> incidentLogs = new ArrayList<>();
    public static ArrayList<MaintenanceHazardReport> hazardReports = new ArrayList<>();
    public static ArrayList<ParkingViolationRecord> parkingViolations = new ArrayList<>();
    public static ArrayList<EmergencyAssistanceRequest> emergencyRequests = new ArrayList<>();
    public static ArrayList<Tenant> tenantList = new ArrayList<>();
    public static ArrayList<SilentAlarm> silentAlarms = new ArrayList<>();
    public static ArrayList<PropertyWarning> propertyWarnings = new ArrayList<>();
    public static ArrayList<ShiftSummary> shiftSummaries = new ArrayList<>();

    static {
        loadIncidentLogsFromFile();
        loadHazardReportsFromFile();
        loadParkingViolationsFromFile();
        loadEmergencyRequestsFromFile();
        loadTenantListFromFile();
        loadSilentAlarmsFromFile();
        loadPropertyWarningsFromFile();
        loadShiftSummariesFromFile();
    }

    public SecurityInCharge() {
        super();
        this.securityId = "";
    }

    public SecurityInCharge(String userId, String name, String role, String password, boolean isLoggedIn, String securityId) {
        super(userId, name, role, password, isLoggedIn);
        this.securityId = securityId;
    }


    public static void loadIncidentLogsFromFile() {
        incidentLogs = new ArrayList<>();
        File file = new File("IncidentLog.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    IncidentLog log = (IncidentLog) ois.readObject();
                    incidentLogs.add(log);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveIncidentLogToFile(IncidentLog log) {
        File file = new File("IncidentLog.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(log);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadHazardReportsFromFile() {
        hazardReports = new ArrayList<>();
        File file = new File("MaintenanceHazardReport.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    MaintenanceHazardReport report = (MaintenanceHazardReport) ois.readObject();
                    hazardReports.add(report);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveHazardReportToFile(MaintenanceHazardReport report) {
        File file = new File("MaintenanceHazardReport.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(report);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadParkingViolationsFromFile() {
        parkingViolations = new ArrayList<>();
        File file = new File("ParkingViolationRecord.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    ParkingViolationRecord record = (ParkingViolationRecord) ois.readObject();
                    parkingViolations.add(record);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveParkingViolationToFile(ParkingViolationRecord record) {
        File file = new File("ParkingViolationRecord.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(record);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadEmergencyRequestsFromFile() {
        emergencyRequests = new ArrayList<>();
        File file = new File("EmergencyAssistanceRequest.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    EmergencyAssistanceRequest req = (EmergencyAssistanceRequest) ois.readObject();
                    emergencyRequests.add(req);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveEmergencyRequestToFile(EmergencyAssistanceRequest req) {
        File file = new File("EmergencyAssistanceRequest.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(req);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadTenantListFromFile() {
        tenantList = new ArrayList<>();
        File file = new File("Tenant.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Tenant tenant = (Tenant) ois.readObject();
                    tenantList.add(tenant);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveTenantToFile(Tenant tenant) {
        File file = new File("Tenant.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(tenant);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadSilentAlarmsFromFile() {
        silentAlarms = new ArrayList<>();
        File file = new File("SilentAlarm.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    SilentAlarm alarm = (SilentAlarm) ois.readObject();
                    silentAlarms.add(alarm);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveSilentAlarmToFile(SilentAlarm alarm) {
        File file = new File("SilentAlarm.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(alarm);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadPropertyWarningsFromFile() {
        propertyWarnings = new ArrayList<>();
        File file = new File("PropertyWarning.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    PropertyWarning warning = (PropertyWarning) ois.readObject();
                    propertyWarnings.add(warning);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean savePropertyWarningToFile(PropertyWarning warning) {
        File file = new File("PropertyWarning.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(warning);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadShiftSummariesFromFile() {
        shiftSummaries = new ArrayList<>();
        File file = new File("ShiftSummary.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    ShiftSummary summary = (ShiftSummary) ois.readObject();
                    shiftSummaries.add(summary);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveShiftSummaryToFile(ShiftSummary summary) {
        File file = new File("ShiftSummary.bin");
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(summary);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean fileIncidentLog(String name, LocalTime time, LocalDate date, String location, String description, String personInvolved) {
        String id = "INC-" + LocalTime.now().toString();
        IncidentLog log = new IncidentLog(
                id,
                name,
                time,
                date,
                location,
                description,
                personInvolved
        );
        boolean added = incidentLogs.add(log);
        if (added) {
            saveIncidentLogToFile(log);
        }
        return added;
    }

    public static boolean reportMaintenanceHazard(String hazardName, LocalDate date, String location, String description) {
        String id = "HAZ-" + LocalTime.now().toString();
        MaintenanceHazardReport report = new MaintenanceHazardReport(
                id,
                hazardName,
                date,
                location,
                description
        );
        boolean added = hazardReports.add(report);
        if (added) {
            saveHazardReportToFile(report);
        }
        return added;
    }

    public static boolean logUnauthorizedParking(String licensePlate, String location, LocalTime time, LocalDate date) {
        String id = "PRK-" + LocalTime.now().toString();
        ParkingViolationRecord record = new ParkingViolationRecord(
                id,
                licensePlate,
                location,
                time,
                date
        );
        boolean added = parkingViolations.add(record);
        if (added) {
            saveParkingViolationToFile(record);
        }
        return added;
    }

    public static boolean sendEmergencyAssistanceRequest(String currentLocation, String description) {
        String id = "EMG-" + LocalTime.now().toString();
        EmergencyAssistanceRequest req = new EmergencyAssistanceRequest(
                id,
                currentLocation,
                description,
                LocalDateTime.now()
        );
        boolean added = emergencyRequests.add(req);
        if (added) {
            saveEmergencyRequestToFile(req);
        }
        return added;
    }

    public static ArrayList<Tenant> checkTenantInformation(String searchQuery) {
        ArrayList<Tenant> filterList = new ArrayList<>();
        for (Tenant tenant : tenantList) {
            if (tenant.getTenantId().equalsIgnoreCase(searchQuery) || tenant.getName().equalsIgnoreCase(searchQuery)) {
                filterList.add(tenant);
            }
        }
        return filterList;
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
        PropertyWarning warning = new PropertyWarning(
                id,
                address,
                time,
                date,
                warningDetails
        );
        boolean added = propertyWarnings.add(warning);
        if (added) {
            savePropertyWarningToFile(warning);
        }
        return added;
    }

    public static boolean submitShiftActivitySummary(String activitiesText) {
        String id = "SUM-" + LocalTime.now().toString();
        ShiftSummary summary = new ShiftSummary(
                id,
                activitiesText,
                LocalDateTime.now()
        );
        boolean added = shiftSummaries.add(summary);
        if (added) {
            saveShiftSummaryToFile(summary);
        }
        return added;
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