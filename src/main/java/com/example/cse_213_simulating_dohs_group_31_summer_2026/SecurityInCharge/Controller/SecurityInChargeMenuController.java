package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SecurityInChargeMenuController {

    private void openInNewWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCheckTenantInfo(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/checkTenantInfoView.fxml", "Check Tenant Info");
    }

    @FXML
    public void handleFileIncidentLog(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/fileIncidentLogView.fxml", "File Incident Log");
    }

    @FXML
    public void handleLogUnauthorizedParking(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/logUnauthorizedParkingView.fxml", "Log Unauthorized Parking");
    }

    @FXML
    public void handleNotePropertyWarning(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/notePropertyWarningView.fxml", "Note Property Warning");
    }

    @FXML
    public void handleReportMaintenanceHazard(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/reportMaintenanceHazardView.fxml", "Report Maintenance Hazard");
    }

    @FXML
    public void handleReviewActiveSilentAlarms(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/reviewActiveSilentAlarmsView.fxml", "Review Active Silent Alarms");
    }

    @FXML
    public void handleSendEmergencyAssistance(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/sendEmergencyAssistanceView.fxml", "Send Emergency Assistance");
    }

    @FXML
    public void handleSubmitShiftSummary(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/submitShiftSummaryView.fxml", "Submit Shift Summary");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
