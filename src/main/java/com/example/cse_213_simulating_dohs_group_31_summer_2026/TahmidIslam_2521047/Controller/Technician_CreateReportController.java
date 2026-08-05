package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class Technician_CreateReportController
{
    @javafx.fxml.FXML
    private TextArea reportDescriptionTextField;

    MaintenanceTechnician mt = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitReportOnAction(ActionEvent actionEvent) {
        mt.generateReport(reportDescriptionTextField.getText());
        mt.completeMaintenanceTask();
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
        Utility.showAlert("Success", "Task completed & Report generated successfully");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Current Task", "MaintenanceTechnician_2521047/Current-Task-View.fxml");
    }
}