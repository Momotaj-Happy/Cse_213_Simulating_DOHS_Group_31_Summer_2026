package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class StaffSupervisor extends User {
    private String supervisorId;

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static ArrayList<DutyRotation> dutyRotationList = new ArrayList<>();
    public static ArrayList<ProblemReport> problemReportList = new ArrayList<>();
    public static ArrayList<SupplyRequest> supplyRequestList = new ArrayList<>();
    public static ArrayList<AttendanceRecord> attendanceList = new ArrayList<>();
    public static ArrayList<LeaveApplication> leaveList = new ArrayList<>();
    public static ArrayList<OccasionSchedule> occasionList = new ArrayList<>();
    public static ArrayList<StaffNotice> noticeList = new ArrayList<>();

    public StaffSupervisor() {
        super();
        this.supervisorId = "";
    }

    public StaffSupervisor(int userId, String name, String role, String password, boolean isLoggedIn, String supervisorId) {
        super(userId, name, role, password, isLoggedIn);
        this.supervisorId = supervisorId;
    }

    // Goal-1: build a suggested task list for a given day based on duty type.
    public static ArrayList<Task> generateSuggestedTasks(LocalDate forDate) {
        ArrayList<Task> suggested = new ArrayList<>();
        String[][] sample = {
                {"Rakib", "Road Cleaning", "Road No 5"},
                {"Sumon", "Garbage Collection", "Block A Route"},
                {"Jashim", "Mosque Cleaning", "Central Mosque"},
                {"Karim", "Common Area Cleaning", "Lift Lobby, Building 3"}
        };
        for (String[] row : sample) {
            String id = "TSK-" + (taskList.size() + suggested.size() + 1);
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
        taskList.addAll(tasks);
        return true;
    }

    public static ArrayList<DutyRotation> fetchStaffForRotation() {
        ArrayList<DutyRotation> list = new ArrayList<>();
        list.add(new DutyRotation("Rakib", "Cleaner", "Road Cleaning", 5, "Garbage Collection"));
        list.add(new DutyRotation("Sumon", "Collector", "Garbage Collection", 4, "Mosque Duty"));
        list.add(new DutyRotation("Jashim", "Mosque Staff", "Mosque Duty", 6, "Garden Duty"));
        return list;
    }

    public static boolean saveWeeklyRotation(ArrayList<DutyRotation> rotation) {
        if (rotation == null || rotation.isEmpty()) {
            return false;
        }
        dutyRotationList.clear();
        dutyRotationList.addAll(rotation);
        return true;
    }

    public static boolean publishWeeklyRotation() {
        return !dutyRotationList.isEmpty();
    }


    public static ArrayList<Task> getTaskProgress(String statusFilter) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : taskList) {
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
        task.setStaffName(newStaffName);
        task.setStatus("Pending");
        return true;
    }


    public static boolean createOccasionSchedule(OccasionSchedule schedule) {
        if (schedule == null || schedule.getOccasionName() == null || schedule.getOccasionName().isEmpty()) {
            return false;
        }
        schedule.setStatus("Scheduled");
        return occasionList.add(schedule);
    }


    public static ArrayList<ProblemReport> getPendingProblemReports() {
        ArrayList<ProblemReport> result = new ArrayList<>();
        for (ProblemReport p : problemReportList) {
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
        report.setStatus(action);
        return true;
    }

    public static ArrayList<SupplyRequest> getPendingSupplyRequests() {
        ArrayList<SupplyRequest> result = new ArrayList<>();
        for (SupplyRequest s : supplyRequestList) {
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
        request.setStatus(decision.equals("Approve") ? "Approved" : decision.equals("Reject") ? "Rejected" : "Forwarded");
        return true;
    }

    public static ArrayList<AttendanceRecord> getTodayAttendance() {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord a : attendanceList) {
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
        for (LeaveApplication l : leaveList) {
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
        application.setStatus(decision);
        return true;
    }

    public static boolean sendStaffNotice(StaffNotice notice) {
        if (notice == null || notice.getTitle() == null || notice.getTitle().isEmpty() ||
                notice.getMessage() == null || notice.getMessage().isEmpty()) {
            return false;
        }
        notice.setDatePosted(LocalDate.now());
        return noticeList.add(notice);
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public String toString() {
        return "StaffSupervisor{" +
                "supervisorId='" + supervisorId + '\'' +
                ", " + super.toString() +
                '}';
    }
}
