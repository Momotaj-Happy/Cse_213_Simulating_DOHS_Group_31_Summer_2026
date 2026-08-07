package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class logVehicleExitContrller {
    @FXML
    private TextField txtExitingVehiclePlate;
    @FXML
    private Button btnLogVehicleExit;
    @FXML
    private Label lblExitConfirmation;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleLogVehicleExit(ActionEvent actionEvent) {
        String licensePlate = txtExitingVehiclePlate.getText();

        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            lblExitConfirmation.setText("Please enter exiting vehicle plate!");
            return;
        }

        GateMan.logVehicleExit(licensePlate);
        lblExitConfirmation.setText("Vehicle exited plate:" + licensePlate);
    }
}