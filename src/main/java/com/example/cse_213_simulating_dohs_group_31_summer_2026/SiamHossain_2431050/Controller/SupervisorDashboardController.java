package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

public class SupervisorDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void dailyTaskAssignmentOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Daily Task Assignment", "StaffSupervisor_2431050/Daily-Task-Assignment-View.fxml");
    }

    @javafx.fxml.FXML
    public void weeklyDutyRotationOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Weekly Duty Rotation", "StaffSupervisor_2431050/Weekly-Duty-Rotation-View.fxml");
    }

    @javafx.fxml.FXML
    public void liveTaskProgressOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Live Task Progress", "StaffSupervisor_2431050/Live-Task-Progress-View.fxml");
    }

    @javafx.fxml.FXML
    public void occasionScheduleOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Occasion Schedule", "StaffSupervisor_2431050/Occasion-Schedule-View.fxml");
    }

    @javafx.fxml.FXML
    public void problemReportsOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Problem Reports", "StaffSupervisor_2431050/Problem-Reports-View.fxml");
    }

    @javafx.fxml.FXML
    public void supplyRequestsOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Supply Requests", "StaffSupervisor_2431050/Supply-Requests-View.fxml");
    }

    @javafx.fxml.FXML
    public void attendanceLeaveOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Attendance & Leave", "StaffSupervisor_2431050/Attendance-Leave-View.fxml");
    }

    @javafx.fxml.FXML
    public void staffNoticeOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Staff Notice", "StaffSupervisor_2431050/Staff-Notice-View.fxml");
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Login", "LoginView.fxml");
    }
}
