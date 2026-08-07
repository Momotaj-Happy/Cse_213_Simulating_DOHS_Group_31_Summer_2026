package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;

public class Tools implements Serializable {
    private String toolName, customSpecification;
    private int quantity, eachPrice, totalPrice;
    private boolean isRequested;

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getCustomSpecification() {
        return customSpecification;
    }

    public void setCustomSpecification(String customSpecification) {
        this.customSpecification = customSpecification;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(int eachPrice) {
        this.eachPrice = eachPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Tools(String toolName, String customSpecification, int quantity, int eachPrice, boolean isRequested) {
        this.toolName = toolName;
        this.customSpecification = customSpecification;
        this.quantity = quantity;
        this.eachPrice = eachPrice;
        this.totalPrice = quantity*eachPrice;
        this.isRequested = isRequested;
    }

    @Override
    public String toString() {
        return "Tools{" +
                "toolName='" + toolName + '\'' +
                ", customSpecification='" + customSpecification + '\'' +
                ", quantity=" + quantity +
                ", eachPrice=" + eachPrice +
                ", totalPrice=" + totalPrice +
                ", isRequested=" + isRequested +
                '}';
    }
}
