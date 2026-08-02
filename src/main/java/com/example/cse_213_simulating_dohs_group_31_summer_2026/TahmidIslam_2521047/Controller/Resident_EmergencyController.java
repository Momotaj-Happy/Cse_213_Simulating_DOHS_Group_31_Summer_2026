package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Resident_EmergencyController
{
    ArrayList<Resident> rList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void triggerSilentAlarmOnActon(ActionEvent actionEvent) {
        try{
            Utility.loadFrom("ResidentData.bin", rList);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
        }
        rList.getFirst().triggerSilentAlarm();
    }
}