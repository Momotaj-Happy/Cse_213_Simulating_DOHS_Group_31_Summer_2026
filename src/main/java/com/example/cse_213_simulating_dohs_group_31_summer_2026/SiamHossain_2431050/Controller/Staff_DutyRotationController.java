package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.DutyRotation;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Staff_DutyRotationController
{
    @FXML
    private Text dutyTypeText;
    @FXML
    private Text zoneText;
    @FXML
    private Text shiftTimeText;
    @FXML
    private Text supervisorNameText;
    @FXML
    private Text nextWeekDutyText;

    @FXML
    public void initialize() {
        DutyRotation myDuty = SessionManager.residentialOperationsStaff.getMyDutyRotation();
        dutyTypeText.setText(myDuty.getSuggestedDuty() != null ? myDuty.getSuggestedDuty() : myDuty.getCurrentRole());
        zoneText.setText(myDuty.getZoneLocation() != null ? myDuty.getZoneLocation() : SessionManager.residentialOperationsStaff.getZoneLocation());
        shiftTimeText.setText(myDuty.getShiftTime() != null ? myDuty.getShiftTime() : SessionManager.residentialOperationsStaff.getShiftTime());
        supervisorNameText.setText(myDuty.getSupervisorName() != null ? myDuty.getSupervisorName() : SessionManager.residentialOperationsStaff.getSupervisorName());
        nextWeekDutyText.setText("Not published yet");
    }

    @FXML
    public void viewNextWeekOnAction(ActionEvent actionEvent) {
        DutyRotation myDuty = SessionManager.residentialOperationsStaff.getMyDutyRotation();
        nextWeekDutyText.setText(myDuty.getSuggestedDuty() != null ? myDuty.getSuggestedDuty() : "Not published yet");
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
