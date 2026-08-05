package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceReport;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceTask;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Tools;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class MaintenanceTechnician extends User implements Serializable {
    private final int technicianId;
    private boolean hasAcceptedTask;
    private MaintenanceTask currentAcceptedTask;
    private ArrayList<MaintenanceTask> allAcceptedTask;
    private ArrayList<Tools> inventoryItems;

    public int getTechnicianId() {
        return technicianId;
    }


    public boolean isHasAcceptedTask() {
        return hasAcceptedTask;
    }

    public void setHasAcceptedTask(boolean hasAcceptedTask) {
        this.hasAcceptedTask = hasAcceptedTask;
    }



    public MaintenanceTask getCurrentAcceptedTask() {
        return currentAcceptedTask;
    }

    public void setCurrentAcceptedTask(MaintenanceTask currentAcceptedTask) {
        this.currentAcceptedTask = currentAcceptedTask;
    }

    public ArrayList<MaintenanceTask> getAllAcceptedTask() {
        return allAcceptedTask;
    }

    public void setAllAcceptedTask(ArrayList<MaintenanceTask> allAcceptedTask) {
        this.allAcceptedTask = allAcceptedTask;
    }

    public ArrayList<Tools> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Tools> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public MaintenanceTechnician(int userId, String name, String role, String password, boolean isLoggedIn, boolean hasAcceptedTask, MaintenanceTask currentAcceptedTask, ArrayList<MaintenanceTask> allAcceptedTask, ArrayList<Tools> inventoryItems) {
        super(userId, name, role, password, isLoggedIn);
        this.technicianId = userId;
        this.hasAcceptedTask = hasAcceptedTask;
        this.currentAcceptedTask = currentAcceptedTask;
        this.allAcceptedTask = new ArrayList<MaintenanceTask>();
        this.inventoryItems = inventoryItems;
    }

    @Override
    public String toString() {
        return "MaintenanceTechnician{" +
                "technicianId=" + technicianId +
                ", hasAcceptedTask=" + hasAcceptedTask +
                ", currentAcceptedTask=" + currentAcceptedTask +
                ", allAcceptedTask=" + allAcceptedTask +
                ", inventoryItems=" + inventoryItems +
                '}';
    }

    public void generateReport(String description){
        MaintenanceReport report = new MaintenanceReport(getTechnicianId(),description, LocalDate.now());
        Utility.saveObject("MaintenanceReportData.bin", report, true);
    }

    public void completeMaintenanceTask(){
        for(MaintenanceTask mt: allAcceptedTask){
            if(mt == currentAcceptedTask){
                allAcceptedTask.remove(mt);
                currentAcceptedTask.setCompleted(true);
                allAcceptedTask.add(currentAcceptedTask);
                currentAcceptedTask=null;
                break;
            }
        }
        Utility.saveObject("TechnicianData.bin", this, false);
    }

    public void acceptMaintenanceTask(MaintenanceTask mt, ArrayList<MaintenanceTask> taskList){
        currentAcceptedTask = mt;
        allAcceptedTask.add(mt);
        taskList.remove(mt);
        File taskFile = new File("MaintenanceTaskData.bin");
        if (taskFile.exists()){
            taskFile.delete();
        }

        for(MaintenanceTask m: taskList){
            Utility.saveObject("MaintenanceTaskData.bin", m, true);
        }
        Utility.showAlert("Success", "Task Accepted");
    }
}

