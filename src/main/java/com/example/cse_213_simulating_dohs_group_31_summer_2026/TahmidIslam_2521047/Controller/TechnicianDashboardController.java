package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class TechnicianDashboardController
{
    MaintenanceTechnician mt = SessionManager.technician;
    @javafx.fxml.FXML
    private Text techinicianIdText;

    @javafx.fxml.FXML
    public void initialize() {
        techinicianIdText.setText(String.valueOf(mt.getTechnicianId()));
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "DOHS Management System", "LoginView.fxml");
    }

    @javafx.fxml.FXML
    public void paymentHistoryOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Payment History", "MaintenanceTechnician_2521047/Payment-History-View.fxml");
    }

    @javafx.fxml.FXML
    public void viewReportOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "View Report", "MaintenanceTechnician_2521047/View-Reports-View.fxml");
    }

    @javafx.fxml.FXML
    public void AllAssignedTaskOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "All Assigned Tasks", "MaintenanceTechnician_2521047/All-Assigned-Tasks-View.fxml");
    }

    @javafx.fxml.FXML
    public void inventoryOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Inventory", "MaintenanceTechnician_2521047/Technician-Inventory-View.fxml");
    }

    @javafx.fxml.FXML
    public void currentTaskOnAction(ActionEvent actionEvent) {
        if(mt.getCurrentAcceptedTask()==null){
            Utility.showAlert("No Current Accepted Task", "You do not have any unfinished accepted tasks");
            return;
        }
        Utility.openFxml(actionEvent, "Current Task", "MaintenanceTechnician_2521047/Current-Task-View.fxml");
    }

    @javafx.fxml.FXML
    public void requestPartsOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Request Parts", "MaintenanceTechnician_2521047/Request-Parts-View.fxml");
    }

    @javafx.fxml.FXML
    public void allAcceptedTaskOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "All Accepted Tasks", "MaintenanceTechnician_2521047/All-Accepted-Tasks-View.fxml");
    }
}