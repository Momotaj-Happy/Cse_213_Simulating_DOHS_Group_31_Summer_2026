package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.propertyWarnings;

public class notePropertyWarningController
{
    @javafx.fxml.FXML
    private TextField txtPropertyAddress;
    @javafx.fxml.FXML
    private DatePicker dpWarningDate;
    @javafx.fxml.FXML
    private Label lblWarningStatus;
    @javafx.fxml.FXML
    private TextArea txtWarningDetails;
    @javafx.fxml.FXML
    private TextField txtWarningTime;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSaveWarning(ActionEvent actionEvent) {
        String address = txtPropertyAddress.getText();
        String timeText = txtWarningTime.getText();
        LocalDate date = dpWarningDate.getValue();
        String warningDetails = txtWarningDetails.getText();
        LocalTime time = LocalTime.parse(timeText);

        if (address == null || address.trim().isEmpty()) {
            lblWarningStatus.setText("Property address cannot be empty!");
            return;
        }

        if (timeText == null || timeText.trim().isEmpty()) {
            lblWarningStatus.setText("Warning time cannot be empty!");
            return;
        }

        if (date == null) {
            lblWarningStatus.setText("Please select a valid warning date!");
            return;
        }

        if (warningDetails == null || warningDetails.trim().isEmpty()) {
            lblWarningStatus.setText("Warning details cannot be empty!");
            return;
        }


        boolean isSaved = SecurityInCharge.notePropertyWarning(address, time, date, warningDetails);

        if (isSaved) {
            lblWarningStatus.setText("Property warning note saved successfully! " + propertyWarnings);
        } else {
            lblWarningStatus.setText("Failed to save property warning!");
        }
    }
}