package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

public class GateControl {
    private String gateId;
    private boolean isBypassModeActive;
    private String currentStatus;

    public GateControl() {
    }

    public GateControl(String gateId, boolean isBypassModeActive, String currentStatus) {
        this.gateId = gateId;
        this.isBypassModeActive = isBypassModeActive;
        this.currentStatus = currentStatus;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public boolean isBypassModeActive() {
        return isBypassModeActive;
    }

    public void setBypassModeActive(boolean bypassModeActive) {
        isBypassModeActive = bypassModeActive;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "GateControl{" +
                "gateId='" + gateId + '\'' +
                ", isBypassModeActive=" + isBypassModeActive +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}