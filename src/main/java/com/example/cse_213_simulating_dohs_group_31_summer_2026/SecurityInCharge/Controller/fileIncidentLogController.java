package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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

    @javafx.fxml.FXML
    public void handleSaveIncident(ActionEvent actionEvent) {
    }
}