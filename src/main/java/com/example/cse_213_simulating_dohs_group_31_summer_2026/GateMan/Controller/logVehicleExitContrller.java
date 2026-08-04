package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class logVehicleExitContrller
{
    @javafx.fxml.FXML
    private TextField txtExitingVehiclePlate;
    @javafx.fxml.FXML
    private Button btnLogVehicleExit;
    @javafx.fxml.FXML
    private Label lblExitConfirmation;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleLogVehicleExit(ActionEvent actionEvent) {
        String licensePlate = txtExitingVehiclePlate.getText();
        GateMan.logVehicleExit(licensePlate);
        lblExitConfirmation.setText("Vehicle exited plate:"+ licensePlate);
    }
}