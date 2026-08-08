// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

// ********** PRESIDENT DASHBOARD CONTROLLER **********
public class PresidentDashboardController {

    // ********** UI COMPONENTS **********
    @FXML
    private Label summaryLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        summaryLabel.setText("Welcome, President " + SessionManager.president.getName());
    }

    // ********** NAVIGATION METHODS **********
    @FXML
    public void goRegisterAllotment(ActionEvent event) {
        Utility.openFxml(event, "Register New Plot Allotment", "President/RegisterPlotAllotmentView.fxml");
    }

    @FXML
    public void goPlotTransfer(ActionEvent event) {
        Utility.openFxml(event, "Plot Transfer", "President/ProcessPlotTransferView.fxml");
    }

    @FXML
    public void goTenancyApplications(ActionEvent event) {
        Utility.openFxml(event, "Tenancy Applications", "President/ReviewTenancyApplicationView.fxml");
    }

    @FXML
    public void goEncroachmentViolations(ActionEvent event) {
        Utility.openFxml(event, "Encroachment & Violations", "President/LogEncroachmentViolationView.fxml");
    }

    @FXML
    public void goPlotRegistry(ActionEvent event) {
        Utility.openFxml(event, "Plot Registry", "President/UpdatePlotRecordView.fxml");
    }

    @FXML
    public void goOccupancyCertificate(ActionEvent event) {
        Utility.openFxml(event, "Occupancy Certificate", "President/GenerateOccupancyCertificateView.fxml");
    }

    @FXML
    public void goPlotStatusReport(ActionEvent event) {
        Utility.openFxml(event, "Plot Status Report", "President/GeneratePlotStatusReportView.fxml");
    }

    @FXML
    public void goTenancyManagement(ActionEvent event) {
        Utility.openFxml(event, "Record Tenant Departure", "President/RecordTenantDepartureView.fxml");
    }

    // ********** SIGN OUT METHOD **********
    @FXML
    public void signOutOnAction(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to sign out?", ButtonType.YES, ButtonType.NO);
        if (confirm.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            SessionManager.president.logout();
            SessionManager.president = null;
            Utility.openFxml(event, "DOHS Management System - Login", "LoginView.fxml");
        }
    }
}
