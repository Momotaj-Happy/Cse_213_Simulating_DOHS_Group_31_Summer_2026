package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.hazardReports;

public class reportMaintenanceHazardController
{
    @javafx.fxml.FXML
    private DatePicker dpHazardDate;
    @javafx.fxml.FXML
    private TextField txtHazardLocation;
    @javafx.fxml.FXML
    private TextArea txtHazardDescription;
    @javafx.fxml.FXML
    private TextField txtHazardName;
    @javafx.fxml.FXML
    private Label lblHazardStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmitHazard(ActionEvent actionEvent) {
        String hazardName = txtHazardName.getText();
        LocalDate date = dpHazardDate.getValue();
        String location = txtHazardLocation.getText();
        String description = txtHazardDescription.getText();

        if (hazardName == null || hazardName.trim().isEmpty()){
            lblHazardStatus.setText("Please fill out hazardName input fields!");
            return;
        }
        if (date == null ){
            lblHazardStatus.setText("Please fill out date input fields!");
            return;

        }
        if (date.isAfter(LocalDate.now()) ){
            lblHazardStatus.setText("Please make sure date input is not in future!");
            return;

        }

        if ( location == null || location.trim().isEmpty()){
            lblHazardStatus.setText("Please fill out location input fields!");
            return;
        }
        if (description == null || description.trim().isEmpty()){
            lblHazardStatus.setText("Please fill out description input fields!");
            return;
        }

        boolean isSaved = SecurityInCharge.reportMaintenanceHazard(hazardName, date, location, description);

        if (isSaved) {
            lblHazardStatus.setText("Hazard report stored successfully " + hazardReports);
        } else {
            lblHazardStatus.setText("Failed to store hazard report!");
        }
    }
}