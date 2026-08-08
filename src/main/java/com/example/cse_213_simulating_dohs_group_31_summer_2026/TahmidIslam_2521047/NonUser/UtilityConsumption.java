package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;

public class UtilityConsumption implements Serializable {
    private int electricityAmount, waterAmount, gasAmount, utilityConsumptionId;


    public int getElectricityAmount() {
        return electricityAmount;
    }

    public int getUtilityConsumptionId() {
        return utilityConsumptionId;
    }

    public void setUtilityConsumptionId(int utilityConsumptionId) {
        this.utilityConsumptionId = utilityConsumptionId;
    }

    public UtilityConsumption(int utilityConsumptionId, int electricityAmount, int waterAmount, int gasAmount) {
        this.electricityAmount = electricityAmount;
        this.waterAmount = waterAmount;
        this.gasAmount = gasAmount;
        this.utilityConsumptionId = utilityConsumptionId;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setElectricityAmount(int electricityAmount) {
        this.electricityAmount = electricityAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }


}
