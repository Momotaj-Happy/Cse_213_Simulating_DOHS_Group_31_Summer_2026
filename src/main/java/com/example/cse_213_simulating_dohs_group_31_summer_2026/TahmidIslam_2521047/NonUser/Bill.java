package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private int billId, amount, year;
    private String month, transactionType;
    private Boolean isPaid;

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getBillId() {
        return billId;
    }

    public int getAmount() {
        return amount;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Bill(int billId, int amount, int year, String month,String transactionType, boolean isPaid) {
        this.billId = billId;
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.transactionType = transactionType;
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", amount=" + amount +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", isPaid=" + isPaid +
                '}';
    }
}
