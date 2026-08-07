package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.ParkingViolationRecord;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.parkingViolations;

public class logUnauthorizedParkingController {
    @FXML
    private DatePicker dpParkingDate;
    @FXML
    private TextField txtParkingTime;
    @FXML
    private TextField txtParkingLocation;
    @FXML
    private Label lblParkingStatus;
    @FXML
    private TextField txtParkingPlate;

    @FXML
    private TableView<ParkingViolationRecord> tblParkingViolations;
    @FXML
    private TableColumn<ParkingViolationRecord, String> colViolationId;
    @FXML
    private TableColumn<ParkingViolationRecord, String> colLicensePlate;
    @FXML
    private TableColumn<ParkingViolationRecord, String> colLocation;
    @FXML
    private TableColumn<ParkingViolationRecord, LocalTime> colTime;
    @FXML
    private TableColumn<ParkingViolationRecord, LocalDate> colDate;

    @FXML
    public void initialize() {
        colViolationId.setCellValueFactory(new PropertyValueFactory<>("violationId"));
        colLicensePlate.setCellValueFactory(new PropertyValueFactory<>("licensePlateNumber"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tblParkingViolations.setItems(FXCollections.observableArrayList(parkingViolations));
    }

    @FXML
    public void handleSaveParkingViolation(ActionEvent actionEvent) {
        String licensePlate = txtParkingPlate.getText();
        String location = txtParkingLocation.getText();
        String timeText = txtParkingTime.getText();
        LocalDate date = dpParkingDate.getValue();

        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out license plate input field!");
            alert.showAndWait();
            return;
        }
        if (location == null || location.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out location input field!");
            alert.showAndWait();
            return;
        }
        if (timeText == null || timeText.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out time input field!");
            alert.showAndWait();
            return;
        }
        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a date!");
            alert.showAndWait();
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeText);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid time format (HH:MM)!");
            alert.showAndWait();
            return;
        }

        boolean isSaved = SecurityInCharge.logUnauthorizedParking(licensePlate, location, time, date);

        if (isSaved) {
            tblParkingViolations.setItems(FXCollections.observableArrayList(parkingViolations));
            lblParkingStatus.setText("Parking violation saved successfully!");
        } else {
            lblParkingStatus.setText("Failed to save parking violation!");
        }
    }
}