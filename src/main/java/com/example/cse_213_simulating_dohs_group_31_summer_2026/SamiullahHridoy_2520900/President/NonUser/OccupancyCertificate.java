// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** OCCUPANCY CERTIFICATE CLASS **********
// Represents an occupancy certificate for a plot
public class OccupancyCertificate implements Serializable {
    private String certificateNumber;
    private String plotNumber;
    private String issuedBy;
    private LocalDate inspectionDate;
    private String inspectorName;
    private String remarks;

    // ********** CONSTRUCTOR **********
    public OccupancyCertificate(String certificateNumber, String plotNumber, String issuedBy,
                                 LocalDate inspectionDate, String inspectorName, String remarks) {
        this.certificateNumber = certificateNumber;
        this.plotNumber = plotNumber;
        this.issuedBy = issuedBy;
        this.inspectionDate = inspectionDate;
        this.inspectorName = inspectorName;
        this.remarks = remarks;
    }

    // ********** GETTERS **********
    public String getCertificateNumber() { return certificateNumber; }
    public String getPlotNumber() { return plotNumber; }
    public String getIssuedBy() { return issuedBy; }
    public LocalDate getInspectionDate() { return inspectionDate; }
    public String getInspectorName() { return inspectorName; }
    public String getRemarks() { return remarks; }
}
