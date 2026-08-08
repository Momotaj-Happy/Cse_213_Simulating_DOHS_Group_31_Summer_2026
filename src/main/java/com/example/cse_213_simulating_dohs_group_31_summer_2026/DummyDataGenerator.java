package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Tools;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.UtilityConsumption;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.Plot;
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

        Bill bill = new Bill(1, 100, 2026, "January","Pay Bill", false);
        Bill bill2 = new Bill(2, 150, 2026, "March","Pay Bill", false);
        Bill bill3= new Bill(3, 200, 2026, "April", "Pay Bill", false);
        Bill bill4 = new Bill(4, 5000, 2026, "July", "Pay Bill",  false);
        Bill bill5 = new Bill(5, 10000, 2026, "January","Technician Payment", true);
        Bill bill6 = new Bill(6, 15000, 2026, "March","Technician Payment", true);
        Bill bill7= new Bill(7, 20000, 2026, "April", "Technician Payment", true);
        Utility.saveObject("BillData.bin", bill, true);
        Utility.saveObject("BillData.bin", bill2, true);
        Utility.saveObject("BillData.bin", bill3, true);
        Utility.saveObject("BillData.bin", bill4, true);
        Utility.saveObject("BillData.bin", bill5, true);
        Utility.saveObject("BillData.bin", bill6, true);
        Utility.saveObject("BillData.bin", bill7, true);
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
        System.out.println("Utility Consumption Save Successful");




        File facilityFile = new File("FacilityData.bin");
        if (facilityFile.exists()) {
            facilityFile.delete();
        }

        Facility facility = new Facility(1, 10000, "Park",
                "Block A", "ABC Park", true);
        Facility facility2 = new Facility(2, 15000, "Community Center",
                "Block B", "DEF Convention Centre", true);
        Facility facility3 = new Facility(3, 8000, "Parking",
                "Block C", "GHI Parking", true);
        Facility facility4 = new Facility(4, 22000, "Gym",
                "Block B", "JKL Gym", true);
        Facility facility5 = new Facility(5, 11500, "Park",
                "Block C", "XYZ Park", true);
        Utility.saveObject("FacilityData.bin", facility, true);
        Utility.saveObject("FacilityData.bin", facility2, true);
        Utility.saveObject("FacilityData.bin", facility3, true);
        Utility.saveObject("FacilityData.bin", facility4, true);
        Utility.saveObject("FacilityData.bin", facility5, true);
        System.out.println("Facility Save Successful");



        File toolsFile = new File("ToolsData.bin");
        if (toolsFile.exists()) {
            toolsFile.delete();
        }

        Tools tools = new Tools("Wrench", "None", 4,
                350, false);
        Tools tools2 = new Tools("Hammer", "None", 6,
                530, false);
        Tools tools3 = new Tools("Screwdriver", "None", 5,
                200, false);
        Tools tools4 = new Tools("Screw", "Steel", 50,
                15, false);
        Utility.saveObject("ToolsData.bin", tools, true);
        Utility.saveObject("ToolsData.bin", tools2, true);
        Utility.saveObject("ToolsData.bin", tools3, true);
        Utility.saveObject("ToolsData.bin", tools4, true);
        System.out.println("Tools Save Successful");



        File plotFile = new File("PlotData.bin");
        if (plotFile.exists()) {
            plotFile.delete();
        }

        Plot plot1 = new Plot("P1", "Road 1", 5.0, "Residential", "Vacant", "");
        Plot plot2 = new Plot("P2", "Road 1", 6.5, "Residential", "Vacant", "");
        Plot plot3 = new Plot("P3", "Road 2", 4.0, "Commercial", "Vacant", "");
        Plot plot4 = new Plot("P4", "Road 2", 7.5, "Residential", "Vacant", "");
        Plot plot5 = new Plot("P5", "Road 3", 5.5, "Residential", "Vacant", "");
        Plot plot6 = new Plot("P6", "Road 3", 8.0, "Commercial", "Vacant", "");
        Plot plot7 = new Plot("P7", "Road 4", 4.5, "Residential", "Vacant", "");
        Plot plot8 = new Plot("P8", "Road 4", 6.0, "Residential", "Vacant", "");
        Plot plot9 = new Plot("P9", "Road 5", 7.0, "Commercial", "Vacant", "");
        Plot plot10 = new Plot("P10", "Road 5", 5.0, "Residential", "Vacant", "");
        Utility.saveObject("PlotData.bin", plot1, true);
        Utility.saveObject("PlotData.bin", plot2, true);
        Utility.saveObject("PlotData.bin", plot3, true);
        Utility.saveObject("PlotData.bin", plot4, true);
        Utility.saveObject("PlotData.bin", plot5, true);
        Utility.saveObject("PlotData.bin", plot6, true);
        Utility.saveObject("PlotData.bin", plot7, true);
        Utility.saveObject("PlotData.bin", plot8, true);
        Utility.saveObject("PlotData.bin", plot9, true);
        Utility.saveObject("PlotData.bin", plot10, true);
        System.out.println("Plot Save Successful");
    }
}
