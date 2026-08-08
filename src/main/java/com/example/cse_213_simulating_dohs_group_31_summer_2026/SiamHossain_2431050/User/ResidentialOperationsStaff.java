package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResidentialOperationsStaff extends User {
    private String staffId;
    private String dutyType;
    private String zoneLocation;
    private String shiftTime;
    private String supervisorName;
    private boolean checkedIn;

    public static ArrayList<StaffComplaint> complaintList = new ArrayList<>();


    public ResidentialOperationsStaff(int userId, String name, String role, String password, boolean isLoggedIn, String staffId) {
        super(userId, name, role, password, isLoggedIn);
        this.staffId = staffId;
        this.dutyType = "Cleaner";
        this.zoneLocation = "Road No 5";
        this.shiftTime = "8:00 AM - 4:00 PM";
        this.supervisorName = "Staff Supervisor";
        this.checkedIn = false;
    }



    public ArrayList<Task> getMyTasks() {
        ArrayList<Task> myTasks = new ArrayList<>();
        for (Task t : StaffSupervisor.taskList) {
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
        StaffSupervisor.attendanceList.add(record);
        return true;
    }

    public boolean checkOut() {
        if (!checkedIn) {
            return false;
        }
        checkedIn = false;
        for (AttendanceRecord record : StaffSupervisor.attendanceList) {
            if (record.getStaffName().equalsIgnoreCase(getName()) && record.getDate().equals(LocalDate.now())) {
                record.setStatus("Checked Out");
            }
        }
        return true;
    }


    public boolean completeTask(Task task, String completionStatus, String notes) {
        if (task == null || completionStatus == null) {
            return false;
        }
        task.setNotes(notes);
        task.setCompletionTime(LocalDate.now().toString());
        if (completionStatus.equals("Issue Found")) {
            task.setStatus("Issue Reported");
            ProblemReport report = new ProblemReport("PR-" + (StaffSupervisor.problemReportList.size() + 1),
                    "Task Issue", task.getLocation(), getName(), "Pending", notes);
            StaffSupervisor.problemReportList.add(report);
        } else {
            task.setStatus("Done");
        }
        return true;
    }

    public boolean reportProblem(String problemType, String location, String description) {
        if (problemType == null || location == null || location.isEmpty()) {
            return false;
        }
        ProblemReport report = new ProblemReport("PR-" + (StaffSupervisor.problemReportList.size() + 1),
                problemType, location, getName(), "Pending", description);
        return StaffSupervisor.problemReportList.add(report);
    }

    public boolean requestSupplies(String item, int quantity, String reason) {
        if (item == null || item.isEmpty() || quantity <= 0) {
            return false;
        }
        SupplyRequest request = new SupplyRequest(getName(), item, quantity, reason, "Normal", "Pending");
        return StaffSupervisor.supplyRequestList.add(request);
    }

    public DutyRotation getMyDutyRotation() {
        for (DutyRotation d : StaffSupervisor.dutyRotationList) {
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
        LeaveApplication application = new LeaveApplication("LV-" + (StaffSupervisor.leaveList.size() + 1),
                getName(), leaveType, startDate, endDate, reason, "Pending", totalDays);
        StaffSupervisor.leaveList.add(application);
        return application;
    }

    public ArrayList<LeaveApplication> getMyLeaveHistory() {
        ArrayList<LeaveApplication> history = new ArrayList<>();
        for (LeaveApplication l : StaffSupervisor.leaveList) {
            if (l.getStaffName() != null && l.getStaffName().equalsIgnoreCase(getName())) {
                history.add(l);
            }
        }
        return history;
    }

    public ArrayList<AttendanceRecord> getMyAttendance() {
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        for (AttendanceRecord a : StaffSupervisor.attendanceList) {
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
        return complaintList.add(complaint);
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
