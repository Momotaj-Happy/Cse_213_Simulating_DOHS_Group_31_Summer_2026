package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.emergencyRequests;

public class sendEmergencyAssistanceController
{
    @javafx.fxml.FXML
    private Label lblEmergencyStatus;
    @javafx.fxml.FXML
    private TextField txtCurrentLocation;
    @javafx.fxml.FXML
    private TextArea txtEmergencyDescription;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSendEmergency(ActionEvent actionEvent) {
        String currentLocation = txtCurrentLocation.getText();
        String description = txtEmergencyDescription.getText();

        if (currentLocation == null || currentLocation.trim().isEmpty()) {
            lblEmergencyStatus.setText("Please fill out currentLocation input fields!");
            return;
        }

        if (description == null || description.trim().isEmpty()){
            lblEmergencyStatus.setText("Please fill out description input fields!");
            return;
        }

        boolean isSent = SecurityInCharge.sendEmergencyAssistanceRequest(currentLocation, description);

        if (isSent) {
            lblEmergencyStatus.setText("Emergency alert sent successfully " + emergencyRequests);
        } else {
            lblEmergencyStatus.setText("Failed to send emergency alert!");
        }
    }
}