// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// ********** PLOT STATUS REPORT CONTROLLER **********
public class GeneratePlotStatusReportController {

    // ********** UI COMPONENTS **********
    @FXML private TextField roadNumberField;
    @FXML private ComboBox<String> plotTypeComboBox;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        plotTypeComboBox.getItems().addAll("All", "Residential", "Commercial");
        plotTypeComboBox.setValue("All");
        statusComboBox.getItems().addAll("All", "Allotted", "Vacant", "Disputed");
        statusComboBox.setValue("All");
    }

    // ********** GENERATE REPORT METHOD **********
    @FXML
    public void generateButtonOnAction(ActionEvent event) {
        String report = SessionManager.president.generatePlotStatusReport(
                roadNumberField.getText(), plotTypeComboBox.getValue(), statusComboBox.getValue());
        statusLabel.setText(report);
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
