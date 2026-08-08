// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** PLOT ALLOTMENT CLASS **********
// Represents a plot allotment record
public class PlotAllotment implements Serializable {
    private String allotmentId;
    private String plotNumber;
    private String applicantServiceId;
    private LocalDate allotmentDate;
    private String category;

    // ********** CONSTRUCTOR **********
    public PlotAllotment(String allotmentId, String plotNumber, String applicantServiceId, LocalDate allotmentDate, String category) {
        this.allotmentId = allotmentId;
        this.plotNumber = plotNumber;
        this.applicantServiceId = applicantServiceId;
        this.allotmentDate = allotmentDate;
        this.category = category;
    }

    // ********** GETTERS **********
    public String getAllotmentId() { return allotmentId; }
    public String getPlotNumber() { return plotNumber; }
    public String getApplicantServiceId() { return applicantServiceId; }
    public LocalDate getAllotmentDate() { return allotmentDate; }
    public String getCategory() { return category; }
}
