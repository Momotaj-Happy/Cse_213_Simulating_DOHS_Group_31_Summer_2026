package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;

public class Complaint implements Serializable {
    private int complaintId;
    private String complaintContent, status;


    public int getComplaintId() {
        return complaintId;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public String getStatus() {
        return status;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Complaint(int complaintId, String complaintContent, String status) {
        this.complaintId = complaintId;
        this.complaintContent = complaintContent;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", complaintContent='" + complaintContent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
