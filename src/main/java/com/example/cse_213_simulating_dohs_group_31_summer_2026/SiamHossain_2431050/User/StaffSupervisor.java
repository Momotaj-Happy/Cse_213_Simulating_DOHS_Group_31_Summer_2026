package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class StaffSupervisor extends User {
    private final String supervisorId;


    public static final String TASK_FILE = "TaskData.bin";
    public static final String DUTY_ROTATION_FILE = "DutyRotationData.bin";
    public static final String PROBLEM_REPORT_FILE = "ProblemReportData.bin";
    public static final String SUPPLY_REQUEST_FILE = "SupplyRequestData.bin";
    public static final String ATTENDANCE_FILE = "AttendanceData.bin";
    public static final String LEAVE_FILE = "LeaveData.bin";
    public static final String OCCASION_FILE = "OccasionData.bin";
    public static final String NOTICE_FILE = "NoticeData.bin";

    public StaffSupervisor() {
        super();
        this.supervisorId = "";
    }

    public StaffSupervisor(int userId, String name, String role, String password, boolean isLoggedIn, String supervisorId) {
        super(userId, name, role, password, isLoggedIn);
        this.supervisorId = supervisorId;
    }

    // Deletes the file then re-writes every remaining record - used whenever an
    // existing record needs to be updated in place (append-only won't do).
    static <T extends Serializable> void rewriteAll(String fileName, ArrayList<T> list) {
        File file = new File(fileName);
        if (file.exists()) file.delete();
        for (T o : list) Utility.saveObject(fileName, o, true);
    }

    public static ArrayList<Task> generateSuggestedTasks(LocalDate forDate) {
        ArrayList<Task> suggested = new ArrayList<>();
        ArrayList<Task> existing = Utility.loadObject(TASK_FILE);
        String[][] sample = {
                {"Rakib", "Road Cleaning", "Road No 5"},
                {"Sumon", "Garbage Collection", "Block A Route"},
                {"Jashim", "Mosque Cleaning", "Central Mosque"},
                {"Karim", "Common Area Cleaning", "Lift Lobby, Building 3"},
                {"Xiam", "Drainage Cleaning", "Main Gate Avenue"},
                {"Rafiq", "Park Maintenance", "Community Park South"},
                {"Tariq", "Lawn Mowing", "Playground Zone B"},
                {"Salim", "Dustbin Emptying", "Sector 4 Market Area"},
                {"Habib", "Staircase Sweeping", "Building 2 - All Floors"},
                {"Arif", "Water Tank Inspection", "Rooftop, Building 1"},
                {"Sohan", "Glass Panel Cleaning", "Main Office Entrance"},
                {"Kabir", "Waste Segregation", "Central Transfer Station"}
        };
        for (String[] row : sample) {
            String id = "TSK-" + (existing.size() + suggested.size() + 1);
            Task t = new Task(id, row[0], row[1], row[2], "9:00 AM", "Pending", "Available");
            suggested.add(t);
        }
        return suggested;
    }

    public static boolean assignTasks(ArrayList<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return false;
        }
        for (Task t : tasks) {
            if (t.getStaffName() == null || t.getStaffName().isEmpty() ||
                    t.getLocation() == null || t.getLocation().isEmpty()) {
                return false;
            }
        }
        for (Task t : tasks) {
            Utility.saveObject(TASK_FILE, t, true);
        }
        return true;
    }

    public static ArrayList<DutyRotation> fetchStaffForRotation() {
        ArrayList<DutyRotation> list = new ArrayList<>();
        list.add(new DutyRotation("Rakib", "Cleaners", "Road Cleaning", 5, "Garbage Collection"));
        list.add(new DutyRotation("Sumon", "Collectors", "Garbage Collection", 4, "Mosque Duty"));
        list.add(new DutyRotation("Jashim", "Mosque Staff", "Mosque Cleaning", 6, "Garden Duty"));
        list.add(new DutyRotation("Karim", "Cleaners", "Common Area Cleaning", 3, "Road Cleaning"));
        list.add(new DutyRotation("Xiam", "Caretakers", "Drainage Cleaning", 4, "Common Area Cleaning"));
        list.add(new DutyRotation("Rafiq", "Gardeners", "Park Maintenance", 5, "Lawn Mowing"));
        list.add(new DutyRotation("Tariq", "Gardeners", "Lawn Mowing", 2, "Park Maintenance"));
        list.add(new DutyRotation("Salim", "Collectors", "Dustbin Emptying", 6, "Garbage Collection"));
        list.add(new DutyRotation("Habib", "Cleaners", "Staircase Sweeping", 3, "Common Area Cleaning"));
        list.add(new DutyRotation("Arif", "Liftmen", "Water Tank Inspection", 7, "Drainage Cleaning"));
        list.add(new DutyRotation("Sohan", "Caretakers", "Glass Panel Cleaning", 4, "Staircase Sweeping"));
        list.add(new DutyRotation("Kabir", "Collectors", "Waste Segregation", 5, "Dustbin Emptying"));
        return list;
    }

    public static boolean saveWeeklyRotation(ArrayList<DutyRotation> rotation) {
        if (rotation == null || rotation.isEmpty()) {
            return false;
        }
        rewriteAll(DUTY_ROTATION_FILE, rotation);
        return true;
    }

    public static boolean publishWeeklyRotation() {
        return !Utility.<DutyRotation>loadObject(DUTY_ROTATION_FILE).isEmpty();
    }


    public static ArrayList<Task> getTaskProgress(String statusFilter) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : Utility.<Task>loadObject(TASK_FILE)) {
            if (statusFilter == null || statusFilter.equals("All") || statusFilter.equals(t.getStatus())) {
                result.add(t);
            }
        }
        return result;
    }

    public static boolean sendReminder(Task task) {
        return task != null;
    }

    public static boolean reassignTask(Task task, String newStaffName) {
        if (task == null || newStaffName == null || newStaffName.isEmpty()) {
            return false;
        }
        ArrayList<Task> tasks = Utility.loadObject(TASK_FILE);
        for (Task t : tasks) {
            if (t.getTaskId() != null && t.getTaskId().equals(task.getTaskId())) {
                t.setStaffName(newStaffName);
                t.setStatus("Pending");
            }
        }
        rewriteAll(TASK_FILE, tasks);
        task.setStaffName(newStaffName);
        task.setStatus("Pending");
        return true;
    }


    public static boolean createOccasionSchedule(OccasionSchedule schedule) {
        if (schedule == null || schedule.getOccasionName() == null || schedule.getOccasionName().isEmpty()) {
            return false;
        }
        schedule.setStatus("Scheduled");
        Utility.saveObject(OCCASION_FILE, schedule, true);
        return true;
    }


    public static ArrayList<ProblemReport> getPendingProblemReports() {
        ArrayList<ProblemReport> result = new ArrayList<>();
        for (ProblemReport p : Utility.<ProblemReport>loadObject(PROBLEM_REPORT_FILE)) {
            if (!"Resolved".equals(p.getStatus())) {
                result.add(p);
            }
        }
        return result;
    }

    public static boolean applyActionToReport(ProblemReport report, String action, String remarks) {
        if (report == null || action == null || action.isEmpty()) {
            return false;
        }
        ArrayList<ProblemReport> reports = Utility.loadObject(PROBLEM_REPORT_FILE);
        for (ProblemReport p : reports) {
            if (p.getReportId() != null && p.getReportId().equals(report.getReportId())) {
                p.setStatus(action);
            }
        }
        rewriteAll(PROBLEM_REPORT_FILE, reports);
        report.setStatus(action);
        return true;
    }

    public static ArrayList<SupplyRequest> getPendingSupplyRequests() {
        ArrayList<SupplyRequest> result = new ArrayList<>();
        for (SupplyRequest s : Utility.<SupplyRequest>loadObject(SUPPLY_REQUEST_FILE)) {
            if ("Pending".equals(s.getStatus())) {
                result.add(s);
            }
        }
        return result;
    }

    public static boolean decideSupplyRequest(SupplyRequest request, String decision, String rejectionReason) {
        if (request == null || decision == null) {
            return false;
        }
        if (decision.equals("Reject") && (rejectionReason == null || rejectionReason.isEmpty())) {
            return false;
        }
        String newStatus = decision.equals("Approve") ? "Approved" : decision.equals("Reject") ? "Rejected" : "Forwarded";
        ArrayList<SupplyRequest> requests = Utility.loadObject(SUPPLY_REQUEST_FILE);
        for (SupplyRequest s : requests) {
            if (s.getRequestId() != null && s.getRequestId().equals(request.getRequestId())) {
                s.setStatus(newStatus);
            }
        }
        rewriteAll(SUPPLY_REQUEST_FILE, requests);
        request.setStatus(newStatus);
        return true;
    }

    public static ArrayList<AttendanceRecord> getTodayAttendance() {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord a : Utility.<AttendanceRecord>loadObject(ATTENDANCE_FILE)) {
            if (a.getDate() != null && a.getDate().equals(LocalDate.now())) {
                result.add(a);
            }
        }
        return result;
    }

    public static boolean correctAttendanceEntry(AttendanceRecord record, String reason) {
        if (record == null || reason == null || reason.isEmpty()) {
            return false;
        }
        return true;
    }

    public static ArrayList<LeaveApplication> getPendingLeaveApplications() {
        ArrayList<LeaveApplication> result = new ArrayList<>();
        for (LeaveApplication l : Utility.<LeaveApplication>loadObject(LEAVE_FILE)) {
            if ("Pending".equals(l.getStatus())) {
                result.add(l);
            }
        }
        return result;
    }

    public static boolean decideLeaveApplication(LeaveApplication application, String decision, String remarks) {
        if (application == null || decision == null) {
            return false;
        }
        ArrayList<LeaveApplication> leaves = Utility.loadObject(LEAVE_FILE);
        for (LeaveApplication l : leaves) {
            if (l.getLeaveId() != null && l.getLeaveId().equals(application.getLeaveId())) {
                l.setStatus(decision);
            }
        }
        rewriteAll(LEAVE_FILE, leaves);
        application.setStatus(decision);
        return true;
    }

    public static boolean sendStaffNotice(StaffNotice notice) {
        if (notice == null || notice.getTitle() == null || notice.getTitle().isEmpty() ||
                notice.getMessage() == null || notice.getMessage().isEmpty()) {
            return false;
        }
        notice.setDatePosted(LocalDate.now());
        Utility.saveObject(NOTICE_FILE, notice, true);
        return true;
    }

    @Override
    public String toString() {
        return "StaffSupervisor{" +
                "supervisorId='" + supervisorId + '\'' +
                ", " + super.toString() +
                '}';
    }
}
