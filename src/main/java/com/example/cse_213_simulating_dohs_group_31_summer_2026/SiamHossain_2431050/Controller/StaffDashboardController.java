package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

public class StaffDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void myTaskListOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "My Task List", "ResidentialOperationsStaff_2431050/My-Task-List-View.fxml");}

    @javafx.fxml.FXML
    public void checkInOutOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Check In / Check Out", "ResidentialOperationsStaff_2431050/Check-In-Out-View.fxml");}

    @javafx.fxml.FXML
    public void reportProblemOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Report Problem", "ResidentialOperationsStaff_2431050/Report-Problem-View.fxml");}

    @javafx.fxml.FXML
    public void requestSuppliesOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Request Supplies", "ResidentialOperationsStaff_2431050/Request-Supplies-View.fxml");}

    @javafx.fxml.FXML
    public void dutyRotationOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "My Duty Rotation", "ResidentialOperationsStaff_2431050/Duty-Rotation-View.fxml");}

    @javafx.fxml.FXML
    public void applyLeaveOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Apply For Leave", "ResidentialOperationsStaff_2431050/Apply-Leave-View.fxml");}

    @javafx.fxml.FXML
    public void attendanceComplaintOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Attendance & Complaint", "ResidentialOperationsStaff_2431050/Attendance-Complaint-View.fxml");}

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Login", "LoginView.fxml");
    }
}
