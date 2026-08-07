package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.emergencyRequests;

public class sendEmergencyAssistanceController {
    @FXML
    private Label lblEmergencyStatus;
    @FXML
    private TextField txtCurrentLocation;
    @FXML
    private TextArea txtEmergencyDescription;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleSendEmergency(ActionEvent actionEvent) {
        String currentLocation = txtCurrentLocation.getText();
        String description = txtEmergencyDescription.getText();

        if (currentLocation == null || currentLocation.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out location field!");
            alert.showAndWait();
            return;
        }

        if (description == null || description.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out emergency description field!");
            alert.showAndWait();
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