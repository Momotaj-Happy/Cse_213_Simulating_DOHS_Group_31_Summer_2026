package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.User.Accountant;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.User.President;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.ResidentialOperationsStaff;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginViewController
{
    @FXML
    private TextField staffIdTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusLabel;
    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Accountant", "Gate Man", "Maintenance Technician",
                "President", "Resident", "Residential Operations Staff", "Security In charge",
                "Staff Supervisor");
    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String userType = userTypeComboBox.getValue();
        String userId = staffIdTextField.getText();
        String password = passwordField.getText();
        int userid;

        try{
            userid = Integer.parseInt(userId);
        }
        catch (Exception e){
            Utility.showAlert("Error", "User ID must be an Integer");
            return;
        }


        if (userType==null || userId.isEmpty() || password.isEmpty()){
            Utility.showAlert("Error","Please fill all fields.");
            return;
        }
        if (userTypeComboBox.getValue().equals("Resident")) {
            Resident r = new Resident(userid,"Resident", passwordField.getText(),
                    "Address", new ArrayList<Facility>());
            Utility.saveObject("ResidentData.bin", r, true);
            SessionManager.resident= r;

            Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
        }
        else if (userTypeComboBox.getValue().equals("Maintenance Technician")) {
            MaintenanceTechnician mt = new MaintenanceTechnician(userid, "Maintenance Technician",
                    "Maintenance Technician", password, true, false,
                    null, null, null);

            SessionManager.technician = mt;
            Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
        }
        else if (userTypeComboBox.getValue().equals("Accountant")) {
            Accountant acc = new Accountant(userid, "Accountant", password);
            SessionManager.accountant = acc;
            Utility.openFxml(actionEvent, "Accountant", "Accountant/AccountantDashboard.fxml");

        }
        else if (userTypeComboBox.getValue().equals("President")) {
            President pres = new President(userid, "President", password);
            SessionManager.president = pres;
            Utility.openFxml(actionEvent, "President", "President/PresidentDashboard.fxml");

        }



        else if (userTypeComboBox.getValue().equals("Residential Operations Staff")) {
            ResidentialOperationsStaff staff =
                    new ResidentialOperationsStaff(
                            Integer.parseInt(userId), "Rakib", "Residential Operations Staff", password, true, "RS001", "Cleaner", "Road No 5", "8:00 AM - 4:00 PM", "Staff Supervisor", false
                    );
            SessionManager.residentialOperationsStaff = staff;
            Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");

        }
        else if (userTypeComboBox.getValue().equals("Staff Supervisor")) {
            StaffSupervisor supervisor = new StaffSupervisor(userid, "Siam",
                    "Staff Supervisor", password, true, userId);
            SessionManager.staffSupervisor = supervisor;
            Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");

        }

    }
}