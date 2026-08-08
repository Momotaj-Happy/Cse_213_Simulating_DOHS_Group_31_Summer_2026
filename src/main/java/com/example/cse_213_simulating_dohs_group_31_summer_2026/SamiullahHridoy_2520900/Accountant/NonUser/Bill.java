// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** BILL CLASS **********
// Represents a monthly service charge bill for a plot
public class Bill implements Serializable {
    private String billId;
    private String plotNumber;
    private String billingPeriod;
    private double amount;
    private LocalDate generatedDate;
    private LocalDate dueDate;
    private String status; // Unpaid / Paid / Partially Paid

    // ********** CONSTRUCTOR **********
    public Bill(String billId, String plotNumber, String billingPeriod, double amount, LocalDate generatedDate, LocalDate dueDate, String status) {
        this.billId = billId;
        this.plotNumber = plotNumber;
        this.billingPeriod = billingPeriod;
        this.amount = amount;
        this.generatedDate = generatedDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    // ********** GETTERS AND SETTERS **********
    public String getBillId() { return billId; }
    public String getPlotNumber() { return plotNumber; }
    public String getBillingPeriod() { return billingPeriod; }
    public double getAmount() { return amount; }
    public LocalDate getGeneratedDate() { return generatedDate; }
    public LocalDate getDueDate() { return dueDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ********** EQUALS METHOD **********
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bill)) return false;
        return billId.equals(((Bill) o).billId);
    }
}
