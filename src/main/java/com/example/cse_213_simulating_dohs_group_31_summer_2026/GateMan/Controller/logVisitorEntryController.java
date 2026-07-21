package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class logVisitorEntryController
{
    @javafx.fxml.FXML
    private TextField txtEntryTime;
    @javafx.fxml.FXML
    private TextField txtVehicleNumber;
    @javafx.fxml.FXML
    private Label lblLogVisitorStatus;
    @javafx.fxml.FXML
    private ComboBox<Integer> cmbGateNo;
    @javafx.fxml.FXML
    private TextField txtGuestName;

    @javafx.fxml.FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1,2);

    }

    @javafx.fxml.FXML
    public void handleLogVisitorEntry(ActionEvent actionEvent) {
    }
}