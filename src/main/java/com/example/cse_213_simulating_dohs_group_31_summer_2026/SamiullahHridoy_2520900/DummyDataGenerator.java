package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.Plot;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class DummyDataGenerator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage){

        File plotFile = new File("PlotData.bin");
        if (plotFile.exists()) {
            plotFile.delete();
        }

        Plot plot1 = new Plot("R7-P12", "Road 7", 5.0, "Residential", "Vacant", "");
        Plot plot2 = new Plot("R7-P13", "Road 7", 5.0, "Residential", "Allotted", "2431050");
        Plot plot3 = new Plot("R9-P04", "Road 9", 8.0, "Commercial", "Vacant", "");
        Plot plot4 = new Plot("R3-P21", "Road 3", 6.5, "Residential", "Allotted", "2521047");
        Plot plot5 = new Plot("R3-P22", "Road 3", 6.5, "Residential", "Disputed", "2430798");
        Utility.saveObject("PlotData.bin", plot1, true);
        Utility.saveObject("PlotData.bin", plot2, true);
        Utility.saveObject("PlotData.bin", plot3, true);
        Utility.saveObject("PlotData.bin", plot4, true);
        Utility.saveObject("PlotData.bin", plot5, true);
        System.out.println("Plot Save Successfull");



        File accountantBillFile = new File("AccountantBillData.bin");
        if (accountantBillFile.exists()) {
            accountantBillFile.delete();
        }

        Bill accBill1 = new Bill("BILL-SEED001", "R7-P13", "2026-06", 3600.0, LocalDate.now().minusDays(40), LocalDate.now().minusDays(10), "Unpaid");
        Bill accBill2 = new Bill("BILL-SEED002", "R3-P21", "2026-06", 3600.0, LocalDate.now().minusDays(40), LocalDate.now().minusDays(10), "Paid");
        Utility.saveObject("AccountantBillData.bin", accBill1, true);
        Utility.saveObject("AccountantBillData.bin", accBill2, true);
        System.out.println("Accountant Bill Save Successfull");

    }
}
