package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.parkingViolations;

public class logUnauthorizedParkingController
{
    @javafx.fxml.FXML
    private DatePicker dpParkingDate;
    @javafx.fxml.FXML
    private TextField txtParkingTime;
    @javafx.fxml.FXML
    private TextField txtParkingLocation;
    @javafx.fxml.FXML
    private Label lblParkingStatus;
    @javafx.fxml.FXML
    private TextField txtParkingPlate;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleSaveParkingViolation(ActionEvent actionEvent) {
        String licensePlate = txtParkingPlate.getText();
        String location = txtParkingLocation.getText();
        String timeText = txtParkingTime.getText();
        LocalDate date = dpParkingDate.getValue();
        LocalTime time = LocalTime.parse(timeText);

        if (licensePlate == null || licensePlate.length()!=6 || licensePlate.trim().isEmpty()){
            lblParkingStatus.setText("Please fill out license input fields!");
            return;
        }
        if (location == null || location.trim().isEmpty()){
            lblParkingStatus.setText("Please fill out location input fields!");
            return;
        }
        if (timeText == null || timeText.trim().isEmpty()){
            lblParkingStatus.setText("Please fill out time input fields!");
            return;
        }
        if (date == null){
            lblParkingStatus.setText("Please fill out date input fields!");
            return;
        }

        boolean isSaved = SecurityInCharge.logUnauthorizedParking(licensePlate, location, time, date);

        if (isSaved) {
            lblParkingStatus.setText("Parking violation saved successfully " + parkingViolations);
        } else {
            lblParkingStatus.setText("Failed to save parking violation!");
        }
    }
}