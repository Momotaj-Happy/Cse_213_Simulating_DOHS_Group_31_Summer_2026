// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** VIOLATION CASE CLASS **********
// Represents an encroachment/violation case
public class ViolationCase implements Serializable {
    private String caseId;
    private String plotNumber;
    private String violationType;
    private String description;
    private LocalDate observedDate;
    private String reportingOfficer;
    private String status; // Open / Resolved
    private LocalDate followUpDate;

    // ********** CONSTRUCTOR **********
    public ViolationCase(String caseId, String plotNumber, String violationType, String description,
                          LocalDate observedDate, String reportingOfficer, String status) {
        this.caseId = caseId;
        this.plotNumber = plotNumber;
        this.violationType = violationType;
        this.description = description;
        this.observedDate = observedDate;
        this.reportingOfficer = reportingOfficer;
        this.status = status;
    }

    // ********** GETTERS AND SETTERS **********
    public String getCaseId() { return caseId; }
    public String getPlotNumber() { return plotNumber; }
    public String getViolationType() { return violationType; }
    public String getDescription() { return description; }
    public LocalDate getObservedDate() { return observedDate; }
    public String getReportingOfficer() { return reportingOfficer; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getFollowUpDate() { return followUpDate; }
    public void setFollowUpDate(LocalDate followUpDate) { this.followUpDate = followUpDate; }
}
