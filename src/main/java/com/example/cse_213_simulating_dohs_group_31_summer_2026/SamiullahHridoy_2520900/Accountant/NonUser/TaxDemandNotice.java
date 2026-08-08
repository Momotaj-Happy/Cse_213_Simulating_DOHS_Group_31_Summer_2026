// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** TAX DEMAND NOTICE CLASS **********
// Represents a tax demand notice for a financial year
public class TaxDemandNotice implements Serializable {
    private String noticeId;
    private String plotNumber;
    private double amount;
    private String financialYear;
    private LocalDate dueDate;

    // ********** CONSTRUCTOR **********
    public TaxDemandNotice(String noticeId, String plotNumber, double amount, String financialYear, LocalDate dueDate) {
        this.noticeId = noticeId;
        this.plotNumber = plotNumber;
        this.amount = amount;
        this.financialYear = financialYear;
        this.dueDate = dueDate;
    }

    // ********** GETTERS **********
    public String getNoticeId() { return noticeId; }
    public String getPlotNumber() { return plotNumber; }
    public double getAmount() { return amount; }
    public String getFinancialYear() { return financialYear; }
    public LocalDate getDueDate() { return dueDate; }
}
