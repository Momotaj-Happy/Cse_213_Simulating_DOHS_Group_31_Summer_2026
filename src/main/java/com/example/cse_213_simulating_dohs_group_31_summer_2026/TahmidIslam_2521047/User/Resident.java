package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import java.io.Serializable;

public class Resident extends User implements Serializable {
    private final int residentId;
    private String residentName, residentAddress;
    private boolean hasAnyBill;;


    public int getResidentId() {
        return residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }


    public Resident(int residentId, String residentName, String residentAddress, boolean hasAnyBill) {
        this.residentId = residentId;
        this.residentName = residentName;
        this.residentAddress = residentAddress;
        this.hasAnyBill = hasAnyBill;
    }

    public Resident(String userId, String name, String role, boolean isLoggedIn, int residentId, String residentName, String residentAddress, boolean hasAnyBill) {
        super(userId, name, role, isLoggedIn);
        this.residentId = residentId;
        this.residentName = residentName;
        this.residentAddress = residentAddress;
        this.hasAnyBill = hasAnyBill;
    }
}
