package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.UtilityConsumption;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class DummyDataGenerator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage){

        File billFile = new File("BillData.bin");
        if (billFile.exists()) {
            billFile.delete();
        }

        Bill bill = new Bill(1, 100, 2026, "January");
        Bill bill2 = new Bill(2, 150, 2026, "March");
        Bill bill3= new Bill(3, 200, 2026, "April");
        Bill bill4 = new Bill(4, 5000, 2026, "July");
        Utility.saveObject("BillData.bin", bill, true);
        Utility.saveObject("BillData.bin", bill2, true);
        Utility.saveObject("BillData.bin", bill3, true);
        Utility.saveObject("BillData.bin", bill4, true);
        System.out.println("Bill Save Successfull");



        File utilityConsuptionFile = new File("UtilityConsumptionData.bin");
        if (utilityConsuptionFile.exists()) {
            utilityConsuptionFile.delete();
        }

        UtilityConsumption uc = new UtilityConsumption(1, 1000,
                1250, 750);
        UtilityConsumption uc2 = new UtilityConsumption(2, 1350,
                2342, 1100);
        UtilityConsumption uc3 = new UtilityConsumption(3, 3200,
                900, 1450);
        Utility.saveObject("UtilityConsumptionData.bin", uc, true);
        Utility.saveObject("UtilityConsumptionData.bin", uc2, true);
        Utility.saveObject("UtilityConsumptionData.bin", uc3, true);
        System.out.println("Utility Consumption Save Successfull");



    }
}
