package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
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
        File residentFile = new File("ResidentData.bin");
        if (residentFile.exists()) {
            residentFile.delete();
        }

        try {
            Resident resident = new Resident(1234, "ABCD", "EFGI", true);
            Utility.writeInto("ResidentData.bin", resident, true);
            System.out.println("Resident Save Successfull");
        } catch (Exception e) {
            System.out.println("Error saving Resident: " + e);

        }




        File billFile = new File("BillData.bin");
        if (billFile.exists()) {
            billFile.delete();
        }

        try {
            Bill bill = new Bill(1, 100, 2026, "January");
            Utility.writeInto("BillData.bin", bill, true);
            System.out.println("Bill Save Successfull");
        } catch (Exception e) {
            System.out.println("Error saving Bill: " + e);

        }




    }
}
