package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ResidentialOperationsStaff extends User {

    private String staffId;
    private String dutyType;
    private String zoneLocation;
    private String shiftTime;
    private String supervisorName;
    private boolean checkedIn;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;




    public static ArrayList<StaffComplaint>complaintList = new ArrayList<>();


    public ResidentialOperationsStaff() {
        super();
        this.staffId = "";
        this.checkedIn = false;
    }

    public ResidentialOperationsStaff(int userId, String name, String role, String password, boolean isLoggedIn, String staffId, String dutyType, String zoneLocation, String shiftTime, String supervisorName, boolean checkedIn) {
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
        checkInTime = LocalTime.now();
        checkedIn = true;
        String status = checkInTime.isAfter(LocalTime.of(8, 15)) ? "Late" : "Present";
        AttendanceRecord record = new AttendanceRecord(getName(), LocalDate.now(), checkInTime, null, status);
        StaffSupervisor.attendanceList.add(record);
        return true;
    }

    public String checkOut() {
        if (!checkedIn) {
            return null;
        }
        checkOutTime = LocalTime.now();
        checkedIn = false;
        for (AttendanceRecord record : StaffSupervisor.attendanceList) {
            if (record.getStaffName().equalsIgnoreCase(getName()) && record.getDate().equals(LocalDate.now())) {
                record.setCheckOut(checkOutTime);
            }
        }
        long minutes = ChronoUnit.MINUTES.between(checkInTime, checkOutTime);
        return String.format("%d hr %d min", minutes / 60, minutes % 60);
    }

    public boolean completeTask(Task task, String completionStatus, String notes) {
        if (task == null || completionStatus == null) {
            return false;
        }
        task.setNotes(notes);
        task.setCompletionTime(LocalTime.now().toString());
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
            if (day.getDayOfWeek() != DayOfWeek.FRIDAY) {
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



    public String getStaffId() {return staffId;}

    public String getDutyType() {return dutyType;}

    public String getZoneLocation() {return zoneLocation;}

    public String getShiftTime() {return shiftTime;}

    public String getSupervisorName() {return supervisorName;}

    public boolean isCheckedIn() {return checkedIn;}

    public LocalTime getCheckInTime() {return checkInTime;}

    public LocalTime getCheckOutTime() {return checkOutTime;}

    public void setStaffId(String staffId) {this.staffId = staffId;}

    public void setDutyType(String dutyType) {this.dutyType = dutyType;}

    public void setZoneLocation(String zoneLocation) {this.zoneLocation = zoneLocation;}

    public void setShiftTime(String shiftTime) {this.shiftTime = shiftTime;}

    public void setSupervisorName(String supervisorName) {this.supervisorName = supervisorName;}

    @Override
    public String toString() {
        return "ResidentialOperationsStaff{" +
                "staffId='" + staffId + '\'' +
                '}';
    }
}
