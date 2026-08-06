package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.OccasionSchedule;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Supervisor_OccasionScheduleController
{
    @FXML
    private TextField occasionNameTextField;
    @FXML
    private DatePicker occasionDateDatePicker;
    @FXML
    private TextField startTimeTextField;
    @FXML
    private TextField endTimeTextField;
    @FXML
    private ComboBox<String> selectServiceTypeComboBox;
    @FXML
    private TextArea affectedAreasTextArea;

    @FXML
    public void initialize() {selectServiceTypeComboBox.getItems().addAll("Mosque Deep Clean", "Road Sweeping", "Garbage Pickup",
                "Community Hall Cleaning", "Garden Preparation", "Extra Toilet Cleaning", "Parking Area Cleaning");
    }

    @FXML
    public void checkAvailabilityOnAction(ActionEvent actionEvent) {
        if (occasionDateDatePicker.getValue() == null) {
            Utility.showAlert("Error", "Pick a date first.");
            return;
        }
        Utility.showAlert("Availability", "All active staff are available on " + occasionDateDatePicker.getValue() + ". No one is on approved leave that day.");
    }

    @FXML
    public void createScheduleOnAction(ActionEvent actionEvent) {
        if (occasionNameTextField.getText().isEmpty() || occasionDateDatePicker.getValue() == null
                || selectServiceTypeComboBox.getValue() == null) {
            Utility.showAlert("Error", "Occasion name, date and service type are required.");
            return;
        }
        OccasionSchedule schedule = new OccasionSchedule(
                occasionNameTextField.getText(),
                occasionDateDatePicker.getValue(),
                startTimeTextField.getText(),
                endTimeTextField.getText(),
                selectServiceTypeComboBox.getValue(),
                affectedAreasTextArea.getText(),
                "Scheduled");

        boolean success = StaffSupervisor.createOccasionSchedule(schedule);
        if (success) {
            Utility.showAlert("Success", "Special schedule created successfully.");
            occasionNameTextField.clear();
            startTimeTextField.clear();
            endTimeTextField.clear();
            affectedAreasTextArea.clear();}

        else {Utility.showAlert("Error", "Could not create the schedule. Check the entered details.");}
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
