package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.incidentLogs;

public class fileIncidentLogController
{
    @javafx.fxml.FXML
    private DatePicker dpIncidentDate;
    @javafx.fxml.FXML
    private TextArea txtIncidentDescription;
    @javafx.fxml.FXML
    private TextField txtReporterName;
    @javafx.fxml.FXML
    private TextField txtPersonInvolved;
    @javafx.fxml.FXML
    private Label lblIncidentStatus;
    @javafx.fxml.FXML
    private TextField txtIncidentLocation;
    @javafx.fxml.FXML
    private TextField txtIncidentTime;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void handleSaveIncident(ActionEvent actionEvent) {
        String name = txtReporterName.getText();
        LocalDate date = dpIncidentDate.getValue();
        String location = txtIncidentLocation.getText();
        String description = txtIncidentDescription.getText();
        String personInvolve = txtPersonInvolved.getText();
        LocalTime time = LocalTime.parse(txtIncidentTime.getText());
        if (name == null || name.trim().isEmpty()) {

            Alert nameErrorAlert = new Alert(Alert.AlertType.ERROR);
            nameErrorAlert.setContentText("Please fill out name input fields!");
            nameErrorAlert.showAndWait();
            return;
        }
        if (txtIncidentTime.getText().trim().isEmpty()) {
            lblIncidentStatus.setText("Please fill out time input fields!");
            return;
        }
        if (date == null) {
            lblIncidentStatus.setText("Please fill out date input fields!");
            return;
        }
        if ( location == null || location.trim().isEmpty()) {
            lblIncidentStatus.setText("Please fill out location input fields!");
            return;
        }
        if (description == null || description.trim().isEmpty()) {
            lblIncidentStatus.setText("Please fill out description input fields!");
            return;
        }
        if ( personInvolve == null || personInvolve.trim().isEmpty()) {
            lblIncidentStatus.setText("Please fill out personInvolve input fields!");
            return;
        }

        boolean isSaved = SecurityInCharge.fileIncidentLog(name, time, date, location, description, personInvolve);
        if (isSaved) {
            lblIncidentStatus.setText("save incident data sucessfully " + incidentLogs);
        } else {
            lblIncidentStatus.setText("Failed to save incident data!");
        }
    }
}