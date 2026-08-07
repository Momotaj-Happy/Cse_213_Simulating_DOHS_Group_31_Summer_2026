package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.shiftSummaries;

public class submitShiftSummaryController {
    @FXML
    private Label lblShiftStatus;
    @FXML
    private TextArea txtShiftActivities;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleSubmitSummary(ActionEvent actionEvent) {
        String activitiesText = txtShiftActivities.getText();

        if (activitiesText == null || activitiesText.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out summary input field!");
            alert.showAndWait();
            return;
        }

        boolean isSaved = SecurityInCharge.submitShiftActivitySummary(activitiesText);

        if (isSaved) {
            lblShiftStatus.setText("Shift summary submitted successfully " + shiftSummaries);
        } else {
            lblShiftStatus.setText("Failed to submit shift summary!");
        }
    }
}