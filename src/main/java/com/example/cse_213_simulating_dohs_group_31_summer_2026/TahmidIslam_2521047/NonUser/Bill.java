package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private int billId, amount, year;
    private String month;


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


    public Bill(int billId, int amount, int year, String month) {
        this.billId = billId;
        this.amount = amount;
        this.year = year;
        this.month = month;
    }
}
