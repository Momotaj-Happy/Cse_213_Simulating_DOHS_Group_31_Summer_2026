package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField staffIdTextField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Accountant", "Gate Man", "Maintenance Technician",
                "President", "Resident", "Residential Operations Staff", "Security In charge",
                "Staff Supervisor");
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String userType = userTypeComboBox.getValue();
        String userId = staffIdTextField.getText();
        String password = passwordField.getText();


        if (userType==null || userId.isEmpty() || password.isEmpty()){
            Utility.showAlert("Error","Please fill all fields.");
            return;
        }
        if (userTypeComboBox.getValue().equals("Resident")) {
            Resident r = new Resident(Integer.parseInt(staffIdTextField.getText()),
                    "Resident", passwordField.getText(), "Address",
                    null);
            Utility.saveObject("ResidentData.bin", r, true);
            SessionManager.resident= r;

            Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
        }
        else if (userTypeComboBox.getValue().equals("Maintenance Technician")) {
            Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
        }
        else if (userTypeComboBox.getValue().equals("Accountant")) {
            Utility.openFxml(actionEvent, "Accountant", "Accountant/AccountantDashboard.fxml");

        }
        else if (userTypeComboBox.getValue().equals("President")) {
            Utility.openFxml(actionEvent, "President", "President/PresidentDashboard.fxml");

        }
        else if (userTypeComboBox.getValue().equals("Residential Operations Staff")) {
            Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");

        }
        else if (userTypeComboBox.getValue().equals("Staff Supervisor")) {
            Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");

        }

        else{

        }
    }
}