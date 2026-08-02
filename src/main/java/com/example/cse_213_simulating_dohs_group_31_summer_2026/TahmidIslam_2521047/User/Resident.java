package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Complaint;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceRequest;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import jdk.jshell.execution.Util;

import java.io.Serializable;
import java.util.ArrayList;

public class Resident extends User implements Serializable {
    private final int residentId;
    private String residentName, residentAddress;
    private Facility bookedFacility;

    public Facility getBookedFacility() {
        return bookedFacility;
    }

    public void setBookedFacility(Facility bookedFacility) {
        this.bookedFacility = bookedFacility;
    }

    //private static final long serialVersionUID = 1L;

    public int getResidentId() {
        return residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }


    public Resident(int residentId, String residentName, String residentAddress) {
        this.residentId = residentId;
        this.residentName = residentName;
        this.residentAddress = residentAddress;
        this.bookedFacility = null;
    }

    public Resident(String userId, String name, String role, boolean isLoggedIn, int residentId, String residentName, String residentAddress) {
        super(userId, name, role, isLoggedIn);
        this.residentId = residentId;
        this.residentName = residentName;
        this.residentAddress = residentAddress;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId=" + residentId +
                ", residentName='" + residentName + '\'' +
                ", residentAddress='" + residentAddress + '\'' +
                ", bookedFacility=" + bookedFacility +
                '}';
    }

    //ArrayList<Resident> rList = new ArrayList<Resident>();

    public void updateProfile(ActionEvent actionEvent, String newName, String newAddress) {
        setResidentName(newName);
        setResidentAddress(newAddress);
        Resident resident = new Resident(getResidentId(), newName, newAddress);
        try {
            Utility.writeInto("ResidentData.bin", resident, false);
            Utility.showAlert("Success", "Profile Updated");
        } catch (Exception e) {
            System.out.println("Save Failed");
            Utility.showAlert("Error", "Save Failed");
            return;
        }
        //Utility.openFxml(actionEvent, "Profile", "Resident_2521047/Resident-Profile-View.fxml");
    }

    public void bookFacility(Facility f){
        bookedFacility= f;
        try{
            Utility.writeInto("ResidentData.bin", this, false);
        }
        catch(Exception e){
            Utility.showAlert("Error", "Save Failed");
            return;
        }
        Utility.showAlert("Success", "Facility Booking Successful");
    }

    public void triggerSilentAlarm(){
        Utility.showAlert("Silent Alarm", "Successfully Triggered Silent Alarm");
    }

    public void requestMaintenanceWork(MaintenanceRequest m){
        try{
            Utility.writeInto("MaintenanceRequest.bin", m, true);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
            return;
        }
        Utility.showAlert("Success", "Maintenance Request Submitted");
    }

    public void submitComplaint(Complaint c){

        Utility.showAlert("Success", "Successfully submitted complaint");
    }
}
