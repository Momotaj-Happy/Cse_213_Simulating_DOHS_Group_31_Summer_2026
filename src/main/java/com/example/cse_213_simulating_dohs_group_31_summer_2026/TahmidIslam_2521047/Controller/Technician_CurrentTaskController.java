package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceTask;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class Technician_CurrentTaskController
{
    @javafx.fxml.FXML
    private Text taskDescriptionText;
    @javafx.fxml.FXML
    private Text residentAddressText;
    @javafx.fxml.FXML
    private Text taskTypeText;
    @javafx.fxml.FXML
    private Text residentIdText;

    MaintenanceTechnician mt = SessionManager.technician;
    MaintenanceTask task = mt.getCurrentAcceptedTask();

    @javafx.fxml.FXML
    public void initialize() {
        residentIdText.setText(String.valueOf(task.getRequestId()));
        residentAddressText.setText(task.getResidentAddress());
        taskTypeText.setText(task.getRequestType());
        taskDescriptionText.setText(task.getRequestDescription());
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void completeTaskOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Create Report", "MaintenanceTechnician_2521047/Create-Report-View.fxml");
    }
}