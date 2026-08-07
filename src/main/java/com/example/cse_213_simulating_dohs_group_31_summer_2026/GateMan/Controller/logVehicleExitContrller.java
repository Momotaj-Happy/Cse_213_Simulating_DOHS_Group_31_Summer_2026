package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.VisitorEntry;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;

public class logVehicleExitContrller {
    @FXML
    private TextField txtExitingVehiclePlate;
    @FXML
    private Button btnLogVehicleExit;
    @FXML
    private Label lblExitConfirmation;

    @FXML
    private TableView<VisitorEntry> tblVehicleExitLogs;
    @FXML
    private TableColumn<VisitorEntry, String> colVehicleNo;
    @FXML
    private TableColumn<VisitorEntry, String> colGuestName;
    @FXML
    private TableColumn<VisitorEntry, LocalTime> colTimeIn;
    @FXML
    private TableColumn<VisitorEntry, LocalTime> colTimeOut;
    @FXML
    private TableColumn<VisitorEntry, String> colStatus;

    @FXML
    public void initialize() {
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        colTimeIn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        colTimeOut.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblVehicleExitLogs.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
    }

    @FXML
    public void handleLogVehicleExit(ActionEvent actionEvent) {
        String licensePlate = txtExitingVehiclePlate.getText();

        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            lblExitConfirmation.setText("Please enter exiting vehicle plate!");
            return;
        }

        GateMan.logVehicleExit(licensePlate);
        tblVehicleExitLogs.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
        lblExitConfirmation.setText("Vehicle exited plate:" + licensePlate);
    }
}