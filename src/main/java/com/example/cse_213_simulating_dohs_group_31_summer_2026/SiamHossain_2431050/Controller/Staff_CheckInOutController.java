package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
public class Staff_CheckInOutController
{
    @FXML
    private Text currentStatusText;
    @FXML
    private Text shiftStartTimeText;
    @FXML
    private Text totalHoursWorkedText;

    @FXML
    public void initialize() {
        shiftStartTimeText.setText(SessionManager.residentialOperationsStaff.getShiftTime());
        refreshStatus();
    }

    private void refreshStatus() {
        currentStatusText.setText(SessionManager.residentialOperationsStaff.isCheckedIn() ? "Checked In" : "Not Checked In");
    }

    @FXML
    public void checkInOnAction(ActionEvent actionEvent) {
        boolean success = SessionManager.residentialOperationsStaff.checkIn();
        if (success) {
            Utility.showAlert("Checked In", "Check-in recorded successfully.");
            refreshStatus();
        } else {
            Utility.showAlert("Error", "You have already checked in today.");
        }
    }

    @FXML
    public void checkOutOnAction(ActionEvent actionEvent) {
        String hoursWorked = SessionManager.residentialOperationsStaff.checkOut();
        if (hoursWorked == null) {
            Utility.showAlert("Error", "You must check in before you can check out.");
            return;
        }
        totalHoursWorkedText.setText(hoursWorked);
        Utility.showAlert("Checked Out", "Total hours worked: " + hoursWorked);
        refreshStatus();
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
