package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GateMan extends User implements Serializable {
    private String gateManId;

    public static ArrayList<ResidentVehicle> residentVehicles = new ArrayList<>();
    public static ArrayList<VisitorEntry> visitorEntries = new ArrayList<>();
    public static ArrayList<PreRegisteredGuest> preRegisteredGuests = new ArrayList<>();
    public static ArrayList<BlacklistedVehicle> blacklistedVehicles = new ArrayList<>();
    public static ArrayList<EmergencyRequest> emergencyRequests = new ArrayList<>();
    public static GateControl gateControl = new GateControl();

    static {
        loadVisitorEntriesFromFile();
        loadResidentVehiclesFromFile();
        loadPreRegisteredGuestsFromFile();
        loadBlacklistedVehiclesFromFile();
        loadEmergencyRequestsFromFile();
    }

    public GateMan() {
        super();
        this.gateManId = "";
    }

    public GateMan(String userId, String name, String role, String password, boolean isLoggedIn, String gateManId) {
        super(userId, name, role, password, isLoggedIn);
        this.gateManId = gateManId;
    }


    public static void loadVisitorEntriesFromFile() {
        visitorEntries = new ArrayList<>();
        File file = new File("VisitorEntry.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    VisitorEntry entry = (VisitorEntry) ois.readObject();
                    visitorEntries.add(entry);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveVisitorEntryToFile(VisitorEntry newVisitorEntry) {
        File file = new File("VisitorEntry.bin");
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
            oos.writeObject(newVisitorEntry);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadResidentVehiclesFromFile() {
        residentVehicles = new ArrayList<>();
        File file = new File("ResidentVehicle.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    ResidentVehicle vehicle = (ResidentVehicle) ois.readObject();
                    residentVehicles.add(vehicle);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveResidentVehicleToFile(ResidentVehicle vehicle) {
        File file = new File("ResidentVehicle.bin");
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
            oos.writeObject(vehicle);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadPreRegisteredGuestsFromFile() {
        preRegisteredGuests = new ArrayList<>();
        File file = new File("PreRegisteredGuest.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    PreRegisteredGuest guest = (PreRegisteredGuest) ois.readObject();
                    preRegisteredGuests.add(guest);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean savePreRegisteredGuestToFile(PreRegisteredGuest guest) {
        File file = new File("PreRegisteredGuest.bin");
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
            oos.writeObject(guest);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadBlacklistedVehiclesFromFile() {
        blacklistedVehicles = new ArrayList<>();
        File file = new File("BlacklistedVehicle.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    BlacklistedVehicle vehicle = (BlacklistedVehicle) ois.readObject();
                    blacklistedVehicles.add(vehicle);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveBlacklistedVehicleToFile(BlacklistedVehicle vehicle) {
        File file = new File("BlacklistedVehicle.bin");
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
            oos.writeObject(vehicle);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void loadEmergencyRequestsFromFile() {
        emergencyRequests = new ArrayList<>();
        File file = new File("EmergencyRequest.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    EmergencyRequest request = (EmergencyRequest) ois.readObject();
                    emergencyRequests.add(request);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveEmergencyRequestToFile(EmergencyRequest request) {
        File file = new File("EmergencyRequest.bin");
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
            oos.writeObject(request);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public static ArrayList<ResidentVehicle> searchResidentVehiclePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return null;
        }
        ArrayList<ResidentVehicle> filterArrayList = new ArrayList<>();
        for (ResidentVehicle rv : residentVehicles) {
            if (rv.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())) {
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

        boolean added = visitorEntries.add(newVisitorEntry);
        if (added) {
            saveVisitorEntryToFile(newVisitorEntry);
        }
        return added;
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
                return true;
            }
        }
        return false;
    }

    public static String toggleEmergencyGateBypass(boolean isSelected) {
        if (isSelected) {
            gateControl.setCurrentStatus("Emergency Gate OPEN");
            gateControl.setBypassModeActive(true);
        } else {
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

        boolean added = visitorEntries.add(newVisitorEntry);
        if (added) {
            saveVisitorEntryToFile(newVisitorEntry);
        }
        return added;
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

