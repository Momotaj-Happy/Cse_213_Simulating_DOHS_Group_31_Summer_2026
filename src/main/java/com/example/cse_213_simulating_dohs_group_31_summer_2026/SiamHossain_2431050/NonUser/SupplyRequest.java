package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

public class SupplyRequest {
    private String staffName;
    private String item;
    private int quantity;
    private String reason;
    private String urgency;
    private String status; // Pending / Approved / Rejected / Forwarded

    public SupplyRequest() {
    }

    public SupplyRequest(String staffName, String item, int quantity, String reason, String urgency, String status) {
        this.staffName = staffName;
        this.item = item;
        this.quantity = quantity;
        this.reason = reason;
        this.urgency = urgency;
        this.status = status;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SupplyRequest{" +
                "staffName='" + staffName + '\'' +
                ", item='" + item + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
