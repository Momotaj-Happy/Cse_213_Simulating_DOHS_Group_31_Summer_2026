// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** CONCESSION CLASS **********
// Represents a fee concession applied to a plot
public class Concession implements Serializable {
    private String concessionId;
    private String plotNumber;
    private String type;
    private double amountOrPercent;
    private LocalDate startDate;
    private LocalDate endDate;
    private String approvalRef;
    private String remarks;

    // ********** CONSTRUCTOR **********
    public Concession(String concessionId, String plotNumber, String type, double amountOrPercent,
                       LocalDate startDate, LocalDate endDate, String approvalRef, String remarks) {
        this.concessionId = concessionId;
        this.plotNumber = plotNumber;
        this.type = type;
        this.amountOrPercent = amountOrPercent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approvalRef = approvalRef;
        this.remarks = remarks;
    }

    // ********** GETTERS **********
    public String getConcessionId() { return concessionId; }
    public String getPlotNumber() { return plotNumber; }
    public String getType() { return type; }
    public double getAmountOrPercent() { return amountOrPercent; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getApprovalRef() { return approvalRef; }
    public String getRemarks() { return remarks; }
}
