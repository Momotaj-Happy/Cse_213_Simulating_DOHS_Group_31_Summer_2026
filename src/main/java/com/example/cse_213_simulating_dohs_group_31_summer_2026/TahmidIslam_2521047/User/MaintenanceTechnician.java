package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;

public class MaintenanceTechnician extends User {
    private final int technicianId;
    private String specialization;
    private boolean hasAcceptedTask;

    public int getTechnicianId() {
        return technicianId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isHasAcceptedTask() {
        return hasAcceptedTask;
    }

    public void setHasAcceptedTask(boolean hasAcceptedTask) {
        this.hasAcceptedTask = hasAcceptedTask;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public MaintenanceTechnician(int technicianId, String specialization, boolean hasAcceptedTask) {
        this.technicianId = technicianId;
        this.specialization = specialization;
        this.hasAcceptedTask = hasAcceptedTask;
    }


}

