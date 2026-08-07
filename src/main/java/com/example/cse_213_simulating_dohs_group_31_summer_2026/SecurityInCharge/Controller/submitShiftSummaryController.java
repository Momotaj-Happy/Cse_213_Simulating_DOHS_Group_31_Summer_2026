package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.shiftSummaries;

public class submitShiftSummaryController
{
    @javafx.fxml.FXML
    private Label lblShiftStatus;
    @javafx.fxml.FXML
    private TextArea txtShiftActivities;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmitSummary(ActionEvent actionEvent) {
        String activitiesText = txtShiftActivities.getText();

        if (activitiesText == null || activitiesText.trim().isEmpty()) {
            lblShiftStatus.setText("Please fill out summary input fields!");
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