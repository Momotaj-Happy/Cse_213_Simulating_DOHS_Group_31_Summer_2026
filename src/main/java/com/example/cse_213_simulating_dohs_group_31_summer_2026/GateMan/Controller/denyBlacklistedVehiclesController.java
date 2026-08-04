package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class denyBlacklistedVehiclesController
{
    @javafx.fxml.FXML
    private TextField txtApproachingPlate;
    @javafx.fxml.FXML
    private Label lblBlacklistAlert;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCheckBlacklist(ActionEvent actionEvent) {
        String licensePlate = txtApproachingPlate.getText();
        boolean isBlacklisted = GateMan.denyBlacklistedVehicle(licensePlate);

        if(isBlacklisted){
            lblBlacklistAlert.setText("Entry found in Blacklist for:" + licensePlate);
        }
        else {
            lblBlacklistAlert.setText("Entry Does Not exist in Blacklist for:" + licensePlate);
        }

    }
}