package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.PreRegisteredGuest;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class verifyPreRegisteredGuestsController {
    @FXML
    private Label lblVerificationMatchStatus;
    @FXML
    private TextField txtGuestLicensePlate;

    @FXML
    private TableView<PreRegisteredGuest> tblPreRegisteredGuests;
    @FXML
    private TableColumn<PreRegisteredGuest, String> colPreRegId;
    @FXML
    private TableColumn<PreRegisteredGuest, String> colLicensePlate;
    @FXML
    private TableColumn<PreRegisteredGuest, String> colHostName;
    @FXML
    private TableColumn<PreRegisteredGuest, LocalDate> colExpectedDate;

    @FXML
    public void initialize() {
        colPreRegId.setCellValueFactory(new PropertyValueFactory<>("preRegId"));
        colLicensePlate.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        colHostName.setCellValueFactory(new PropertyValueFactory<>("hostResidentName"));
        colExpectedDate.setCellValueFactory(new PropertyValueFactory<>("expectedDate"));

        tblPreRegisteredGuests.setItems(FXCollections.observableArrayList(GateMan.preRegisteredGuests));
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