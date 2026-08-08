// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** TRANSFER RECORD CLASS **********
// Represents a plot transfer record
public class TransferRecord implements Serializable {
    private String transferId;
    private String plotNumber;
    private String newOwner;
    private LocalDate transferDate;
    private String reason;

    // ********** CONSTRUCTOR **********
    public TransferRecord(String transferId, String plotNumber, String newOwner, LocalDate transferDate, String reason) {
        this.transferId = transferId;
        this.plotNumber = plotNumber;
        this.newOwner = newOwner;
        this.transferDate = transferDate;
        this.reason = reason;
    }

    // ********** GETTERS **********
    public String getTransferId() { return transferId; }
    public String getPlotNumber() { return plotNumber; }
    public String getNewOwner() { return newOwner; }
    public LocalDate getTransferDate() { return transferDate; }
    public String getReason() { return reason; }
}
