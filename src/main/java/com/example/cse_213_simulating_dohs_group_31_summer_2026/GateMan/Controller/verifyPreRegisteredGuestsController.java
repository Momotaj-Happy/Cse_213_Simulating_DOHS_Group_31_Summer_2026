package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class verifyPreRegisteredGuestsController {
    @FXML
    private Label lblVerificationMatchStatus;
    @FXML
    private TextField txtGuestLicensePlate;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleVerifyPreRegistration(ActionEvent actionEvent) {
        String licensePlate = txtGuestLicensePlate.getText();

        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            lblVerificationMatchStatus.setText("Please enter guest license plate!");
            return;
        }

        boolean isVerified = GateMan.verifyPreRegisteredGuest(licensePlate);
        if (isVerified) {
            lblVerificationMatchStatus.setText("Guest Entry exist in list for:" + licensePlate);
        } else {
            lblVerificationMatchStatus.setText("Guest Entry Does Not exist in list for:" + licensePlate);
        }
    }
}