// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** REFUND RECORD CLASS **********
// Represents a refund record for overpayment
public class RefundRecord implements Serializable {
    private String refundId;
    private String plotNumber;
    private double amount;
    private String method;
    private String remarks;
    private LocalDate processedDate;

    // ********** CONSTRUCTOR **********
    public RefundRecord(String refundId, String plotNumber, double amount, String method, String remarks, LocalDate processedDate) {
        this.refundId = refundId;
        this.plotNumber = plotNumber;
        this.amount = amount;
        this.method = method;
        this.remarks = remarks;
        this.processedDate = processedDate;
    }

    // ********** GETTERS **********
    public String getRefundId() { return refundId; }
    public String getPlotNumber() { return plotNumber; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getRemarks() { return remarks; }
    public LocalDate getProcessedDate() { return processedDate; }
}
