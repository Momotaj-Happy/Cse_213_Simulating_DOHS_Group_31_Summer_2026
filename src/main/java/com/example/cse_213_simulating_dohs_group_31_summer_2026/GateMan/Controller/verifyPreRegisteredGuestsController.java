package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class verifyPreRegisteredGuestsController
{
    @javafx.fxml.FXML
    private Label lblVerificationMatchStatus;
    @javafx.fxml.FXML
    private TextField txtGuestLicensePlate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleVerifyPreRegistration(ActionEvent actionEvent) {
        String licensePlate = txtGuestLicensePlate.getText();
        boolean isVerified = GateMan.verifyPreRegisteredGuest(licensePlate);
        if(isVerified){
            lblVerificationMatchStatus.setText("Guest Entry exist in list for:" + licensePlate);
        }
        else {
            lblVerificationMatchStatus.setText("Guest Entry Does Not exist in list for:" + licensePlate);
        }
    }
}