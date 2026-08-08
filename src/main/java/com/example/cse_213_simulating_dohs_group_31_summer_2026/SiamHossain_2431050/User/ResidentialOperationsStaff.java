package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResidentialOperationsStaff extends User {
    private String staffId;
    private String dutyType;
    private String zoneLocation;
    private String shiftTime;
    private String supervisorName;
    private boolean checkedIn;

    public static final String COMPLAINT_FILE = "ComplaintData.bin";

    public ResidentialOperationsStaff() {
        super();
        this.staffId = "";
        this.checkedIn = false;
    }

    public ResidentialOperationsStaff(int userId, String name, String role, String password, boolean isLoggedIn, String staffId) {
        super(userId, name, role, password, isLoggedIn);
        this.staffId = staffId;
        this.dutyType = "Cleaner";
        this.zoneLocation = "Road No 5";
        this.shiftTime = "8:00 AM - 4:00 PM";
        this.supervisorName = "Staff Supervisor";
        this.checkedIn = false;
    }

    // Deletes the file then re-writes every remaining record - used whenever an
    // existing record needs to be updated in place (append-only won't do).
    private static <T extends Serializable> void rewriteAll(String fileName, ArrayList<T> list) {
        File file = new File(fileName);
        if (file.exists()) file.delete();
        for (T o : list) Utility.saveObject(fileName, o, true);
    }


    public ArrayList<Task> getMyTasks() {
        ArrayList<Task> myTasks = new ArrayList<>();
        for (Task t : Utility.<Task>loadObject(StaffSupervisor.TASK_FILE)) {
            if (t.getStaffName() != null && t.getStaffName().equalsIgnoreCase(getName())) {
                myTasks.add(t);
            }
        }
        return myTasks;
    }


    public boolean checkIn() {
        if (checkedIn) {
            return false;
        }
        checkedIn = true;
        String status = "Present";
        AttendanceRecord record = new AttendanceRecord(getName(), LocalDate.now(), status);
        Utility.saveObject(StaffSupervisor.ATTENDANCE_FILE, record, true);
        return true;
    }

    public boolean checkOut() {
        if (!checkedIn) {
            return false;
        }
        checkedIn = false;
        ArrayList<AttendanceRecord> records = Utility.loadObject(StaffSupervisor.ATTENDANCE_FILE);
        for (AttendanceRecord record : records) {
            if (record.getStaffName().equalsIgnoreCase(getName()) && record.getDate().equals(LocalDate.now())) {
                record.setStatus("Checked Out");
            }
        }
        rewriteAll(StaffSupervisor.ATTENDANCE_FILE, records);
        return true;
    }


    public boolean completeTask(Task task, String completionStatus, String notes) {
        if (task == null || completionStatus == null) {
            return false;
        }
        ArrayList<Task> tasks = Utility.loadObject(StaffSupervisor.TASK_FILE);
        for (Task t : tasks) {
            if (t.getTaskId() != null && t.getTaskId().equals(task.getTaskId())) {
                t.setNotes(notes);
                t.setCompletionTime(LocalDate.now().toString());
                if (completionStatus.equals("Issue Found")) {
                    t.setStatus("Issue Reported");
                } else {
                    t.setStatus("Done");
                }
            }
        }
        rewriteAll(StaffSupervisor.TASK_FILE, tasks);

        task.setNotes(notes);
        task.setCompletionTime(LocalDate.now().toString());
        if (completionStatus.equals("Issue Found")) {
            task.setStatus("Issue Reported");
            int reportCount = Utility.<ProblemReport>loadObject(StaffSupervisor.PROBLEM_REPORT_FILE).size();
            ProblemReport report = new ProblemReport("PR-" + (reportCount + 1),
                    "Task Issue", task.getLocation(), getName(), "Pending", notes);
            Utility.saveObject(StaffSupervisor.PROBLEM_REPORT_FILE, report, true);
        } else {
            task.setStatus("Done");
        }
        return true;
    }

    public boolean reportProblem(String problemType, String location, String description) {
        if (problemType == null || location == null || location.isEmpty()) {
            return false;
        }
        int reportCount = Utility.<ProblemReport>loadObject(StaffSupervisor.PROBLEM_REPORT_FILE).size();
        ProblemReport report = new ProblemReport("PR-" + (reportCount + 1),
                problemType, location, getName(), "Pending", description);
        Utility.saveObject(StaffSupervisor.PROBLEM_REPORT_FILE, report, true);
        return true;
    }

    public boolean requestSupplies(String item, int quantity, String reason) {
        if (item == null || item.isEmpty() || quantity <= 0) {
            return false;
        }
        int requestCount = Utility.<SupplyRequest>loadObject(StaffSupervisor.SUPPLY_REQUEST_FILE).size();
        SupplyRequest request = new SupplyRequest("SR-" + (requestCount + 1), getName(), item, quantity, reason, "Normal", "Pending");
        Utility.saveObject(StaffSupervisor.SUPPLY_REQUEST_FILE, request, true);
        return true;
    }

    public DutyRotation getMyDutyRotation() {
        for (DutyRotation d : Utility.<DutyRotation>loadObject(StaffSupervisor.DUTY_ROTATION_FILE)) {
            if (d.getStaffName() != null && d.getStaffName().equalsIgnoreCase(getName())) {
                return d;
            }
        }
        DutyRotation fallback = new DutyRotation(getName(), dutyType, "-", 0, "Not published yet");
        fallback.setZoneLocation(zoneLocation);
        fallback.setShiftTime(shiftTime);
        fallback.setSupervisorName(supervisorName);
        return fallback;
    }

    public LeaveApplication applyForLeave(String leaveType, LocalDate startDate, LocalDate endDate, String reason) {
        if (leaveType == null || startDate == null || endDate == null || endDate.isBefore(startDate)) {
            return null;
        }
        int totalDays = 0;
        LocalDate day = startDate;
        while (!day.isAfter(endDate)) {
            if (day.toEpochDay() % 7 != 1) { // skips Fridays (1970-01-01 was a Thursday, so Friday = epochDay % 7 == 1)
                totalDays++;
            }
            day = day.plusDays(1);
        }
        int leaveCount = Utility.<LeaveApplication>loadObject(StaffSupervisor.LEAVE_FILE).size();
        LeaveApplication application = new LeaveApplication("LV-" + (leaveCount + 1),
                getName(), leaveType, startDate, endDate, reason, "Pending", totalDays);
        Utility.saveObject(StaffSupervisor.LEAVE_FILE, application, true);
        return application;
    }

    public ArrayList<LeaveApplication> getMyLeaveHistory() {
        ArrayList<LeaveApplication> history = new ArrayList<>();
        for (LeaveApplication l : Utility.<LeaveApplication>loadObject(StaffSupervisor.LEAVE_FILE)) {
            if (l.getStaffName() != null && l.getStaffName().equalsIgnoreCase(getName())) {
                history.add(l);
            }
        }
        return history;
    }

    public ArrayList<AttendanceRecord> getMyAttendance() {
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        for (AttendanceRecord a : Utility.<AttendanceRecord>loadObject(StaffSupervisor.ATTENDANCE_FILE)) {
            if (a.getStaffName() != null && a.getStaffName().equalsIgnoreCase(getName())
                    && a.getDate().getMonth() == LocalDate.now().getMonth()) {
                records.add(a);
            }
        }
        return records;
    }

    public boolean submitComplaint(String complaintType, LocalDate incidentDate, String details) {
        if (complaintType == null || details == null || details.isEmpty()) {
            return false;
        }
        StaffComplaint complaint = new StaffComplaint(getName(), complaintType, incidentDate, details, "Submitted");
        Utility.saveObject(COMPLAINT_FILE, complaint, true);
        return true;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType;
    }

    public String getZoneLocation() {
        return zoneLocation;
    }

    public void setZoneLocation(String zoneLocation) {
        this.zoneLocation = zoneLocation;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    @Override
    public String toString() {
        return "ResidentialOperationsStaff{" +
                "staffId='" + staffId + '\'' +
                ", " + super.toString() +
                '}';
    }
}
