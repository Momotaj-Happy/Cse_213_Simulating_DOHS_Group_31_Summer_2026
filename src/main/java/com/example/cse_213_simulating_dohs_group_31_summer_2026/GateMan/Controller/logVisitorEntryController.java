package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalTime;

public class logVisitorEntryController {
    @FXML
    private TextField txtEntryTime;
    @FXML
    private TextField txtVehicleNumber;
    @FXML
    private Label lblLogVisitorStatus;
    @FXML
    private ComboBox<Integer> cmbGateNo;
    @FXML
    private TextField txtGuestName;

    @FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1, 2);
    }

    @FXML
    public void handleLogVisitorEntry(ActionEvent actionEvent) {
        String name = txtGuestName.getText();
        String timeStr = txtEntryTime.getText();
        String vehicleNo = txtVehicleNumber.getText();
        Integer gateNoObj = cmbGateNo.getValue();

        if (name == null || name.trim().isEmpty()) {
            lblLogVisitorStatus.setText("Please enter guest name!");
            return;
        }
        if (timeStr == null || timeStr.trim().isEmpty()) {
            lblLogVisitorStatus.setText("Please enter entry time!");
            return;
        }
        if (gateNoObj == null) {
            lblLogVisitorStatus.setText("Please select gate number!");
            return;
        }
        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            lblLogVisitorStatus.setText("Please enter vehicle number!");
            return;
        }

        LocalTime entryTime;
        try {
            entryTime = LocalTime.parse(timeStr);
        } catch (Exception e) {
            lblLogVisitorStatus.setText("Please enter valid time format (HH:MM)!");
            return;
        }

        GateMan.logVisitorEntry(name, entryTime, gateNoObj, vehicleNo);
        lblLogVisitorStatus.setText("entry done for vehicle:" + vehicleNo);
    }
}