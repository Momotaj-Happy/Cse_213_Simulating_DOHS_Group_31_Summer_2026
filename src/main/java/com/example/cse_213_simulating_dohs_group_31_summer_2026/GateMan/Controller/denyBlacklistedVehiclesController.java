package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class denyBlacklistedVehiclesController {
    @FXML
    private TextField txtApproachingPlate;
    @FXML
    private Label lblBlacklistAlert;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleCheckBlacklist(ActionEvent actionEvent) {
        String licensePlate = txtApproachingPlate.getText();

        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            lblBlacklistAlert.setText("Please enter approaching license plate!");
            return;
        }

        boolean isBlacklisted = GateMan.denyBlacklistedVehicle(licensePlate);

        if (isBlacklisted) {
            lblBlacklistAlert.setText("Entry found in Blacklist for:" + licensePlate);
        } else {
            lblBlacklistAlert.setText("Entry Does Not exist in Blacklist for:" + licensePlate);
        }
    }
}