// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

// ********** PAYMENT RECEIPT CLASS **********
// Represents a payment receipt for a bill
public class PaymentReceipt implements Serializable {
    private String receiptId;
    private String billId;
    private double amountPaid;
    private LocalDate paymentDate;
    private String method;
    private String refNumber;

    // ********** CONSTRUCTOR **********
    public PaymentReceipt(String receiptId, String billId, double amountPaid, LocalDate paymentDate, String method, String refNumber) {
        this.receiptId = receiptId;
        this.billId = billId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.method = method;
        this.refNumber = refNumber;
    }

    // ********** GETTERS **********
    public String getReceiptId() { return receiptId; }
    public String getBillId() { return billId; }
    public double getAmountPaid() { return amountPaid; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public String getMethod() { return method; }
    public String getRefNumber() { return refNumber; }
}
