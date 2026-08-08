// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** TENANCY APPLICATION CLASS **********
// Represents a tenancy application for a plot
public class TenancyApplication implements Serializable {
    private String applicationId;
    private String plotNumber;
    private String tenantName;
    private String tenantNationalId;
    private LocalDate proposedStartDate;
    private LocalDate submissionDate;
    private double proposedRent;
    private String status; // Pending / Active / Rejected / Terminated
    private String rejectionReason;
    private LocalDate departureDate;
    private String departureRemarks;

    // ********** CONSTRUCTOR **********
    public TenancyApplication(String applicationId, String plotNumber, String tenantName, String tenantNationalId,
                               LocalDate proposedStartDate, LocalDate submissionDate, double proposedRent, String status) {
        this.applicationId = applicationId;
        this.plotNumber = plotNumber;
        this.tenantName = tenantName;
        this.tenantNationalId = tenantNationalId;
        this.proposedStartDate = proposedStartDate;
        this.submissionDate = submissionDate;
        this.proposedRent = proposedRent;
        this.status = status;
    }

    // ********** GETTERS AND SETTERS **********
    public String getApplicationId() { return applicationId; }
    public String getPlotNumber() { return plotNumber; }
    public String getTenantName() { return tenantName; }
    public String getTenantNationalId() { return tenantNationalId; }
    public LocalDate getProposedStartDate() { return proposedStartDate; }
    public LocalDate getSubmissionDate() { return submissionDate; }
    public double getProposedRent() { return proposedRent; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }
    public String getDepartureRemarks() { return departureRemarks; }
    public void setDepartureRemarks(String departureRemarks) { this.departureRemarks = departureRemarks; }

    // ********** EQUALS METHOD **********
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TenancyApplication)) return false;
        return applicationId.equals(((TenancyApplication) o).applicationId);
    }
}
