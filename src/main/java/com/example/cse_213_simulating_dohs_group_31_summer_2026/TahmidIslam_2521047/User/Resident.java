package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Complaint;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceRequest;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Resident extends User implements Serializable {
    private final int residentId;
    private String residentName, residentAddress;
    private ArrayList<Facility> bookedFacility;

    public ArrayList<Facility> getBookedFacility() {
        return bookedFacility;
    }

    public void setBookedFacility(ArrayList<Facility> bookedFacility) {
        this.bookedFacility = bookedFacility;
    }


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

    public Resident(int userId, String name, String password, String residentAddress, ArrayList<Facility> bookedFacility) {
        super(userId, name, password);
        this.residentId = userId;
        this.residentName = name;
        this.residentAddress = residentAddress;
        this.bookedFacility = bookedFacility;
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
        Resident resident = new Resident(getResidentId(), newName,super.getPassword(),
                newAddress, bookedFacility);

        Utility.saveObject("ResidentData.bin", resident, false);
        Utility.showAlert("Success", "Profile Updated");
        Utility.openFxml(actionEvent, "Profile", "Resident_2521047/Resident-Profile-View.fxml");
    }

    public void bookFacility(Facility f){
        bookedFacility.add(f);
        try{
            Utility.saveObject("ResidentData.bin", this, false);
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

        Utility.saveObject("MaintenanceRequest.bin", m, true);

        Utility.showAlert("Success", "Maintenance Request Submitted");
    }

    public void submitComplaint(Complaint c){

        Utility.showAlert("Success", "Successfully submitted complaint");
        Utility.saveObject("ComplaintData.bin", c, true);
    }

    public String payBill(ArrayList<Bill> billList) {
        try {
            File billFile = new File("BillData.bin");
            if (billFile.exists()) {
                billFile.delete();
            }
            for (Bill b : billList) {
                Utility.saveObject("BillData.bin", b, true);
            }

        } catch (Exception e) {
            System.out.println("Save Failed");
            return "0 TK";
        }
        Utility.showAlert("Success", "Bill Paid Successfully");
        return "0 TK";
    }
}
