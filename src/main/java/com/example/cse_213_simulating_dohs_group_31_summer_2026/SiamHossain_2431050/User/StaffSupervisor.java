package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.*;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

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

    public String getSupervisorId() {return supervisorId;}

    public void setSupervisorId(String supervisorId) {this.supervisorId = supervisorId;}

    @Override
    public String toString() {
        return "StaffSupervisor{" +
                "supervisorId='" + supervisorId + '\'' +
                '}';
    }
}
