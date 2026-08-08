package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Resident_DashboardController {

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "DOHS Management System", "LoginView.fxml");

    }

    @javafx.fxml.FXML
    public void transactionsOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Transactions", "Resident_2521047/Resident-Transactions-View.fxml");
    }

    @javafx.fxml.FXML
    public void emergencyOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Emergency", "Resident_2521047/Resident-Emergency-View.fxml");
    }

    @javafx.fxml.FXML
    public void facilitiesOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Facility", "Resident_2521047/Resident-Facilities-View.fxml");
    }

    @javafx.fxml.FXML
    public void complaintOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Complaints", "Resident_2521047/Resident-Complaints-View.fxml");
    }

    @javafx.fxml.FXML
    public void requestMaintenanceOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Request", "Resident_2521047/Resident-Maintenance-Request-View.fxml");
    }

    @javafx.fxml.FXML
    public void billsOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Bills", "Resident_2521047/Resident-Bills-View.fxml");
    }

    @javafx.fxml.FXML
    public void utilityConsumptionOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Utility Consumption", "Resident_2521047/Resident-Utility-View.fxml");
    }

    @javafx.fxml.FXML
    public void profileOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Profile", "Resident_2521047/Resident-Profile-View.fxml");
    }
}