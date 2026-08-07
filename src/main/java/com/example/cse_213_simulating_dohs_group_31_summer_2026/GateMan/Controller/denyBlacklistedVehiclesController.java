package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.BlacklistedVehicle;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class denyBlacklistedVehiclesController {
    @FXML
    private TextField txtApproachingPlate;
    @FXML
    private Label lblBlacklistAlert;

    @FXML
    private TableView<BlacklistedVehicle> tblBlacklistedVehicles;
    @FXML
    private TableColumn<BlacklistedVehicle, String> colLicensePlate;
    @FXML
    private TableColumn<BlacklistedVehicle, String> colReason;

    @FXML
    public void initialize() {
        colLicensePlate.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reasonForBlacklist"));

        tblBlacklistedVehicles.setItems(FXCollections.observableArrayList(GateMan.blacklistedVehicles));
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