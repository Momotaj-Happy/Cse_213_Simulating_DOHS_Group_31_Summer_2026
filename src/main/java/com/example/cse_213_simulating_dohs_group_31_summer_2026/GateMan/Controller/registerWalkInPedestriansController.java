package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalTime;

public class registerWalkInPedestriansController {
    @FXML
    private TextField txtPedestrianName;
    @FXML
    private Label lblPedestrianStatus;
    @FXML
    private TextField txtPedestrianTime;
    @FXML
    private ComboBox<Integer> cmbGateNo;
    @FXML
    private TextField txtPedestrianId;

    @FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1, 2);
    }

    @FXML
    public void handleRegisterPedestrian(ActionEvent actionEvent) {
        String name = txtPedestrianName.getText();
        String timeStr = txtPedestrianTime.getText();
        String identificationNo = txtPedestrianId.getText();
        Integer gateNoObj = cmbGateNo.getValue();

        if (name == null || name.trim().isEmpty()) {
            lblPedestrianStatus.setText("Please enter pedestrian name!");
            return;
        }
        if (timeStr == null || timeStr.trim().isEmpty()) {
            lblPedestrianStatus.setText("Please enter pedestrian entry time!");
            return;
        }
        if (gateNoObj == null) {
            lblPedestrianStatus.setText("Please select gate number!");
            return;
        }
        if (identificationNo == null || identificationNo.trim().isEmpty()) {
            lblPedestrianStatus.setText("Please enter pedestrian ID!");
            return;
        }

        LocalTime entryTime;
        try {
            entryTime = LocalTime.parse(timeStr);
        } catch (Exception e) {
            lblPedestrianStatus.setText("Please enter valid time format (HH:MM)!");
            return;
        }

        GateMan.logVisitorEntry(name, entryTime, gateNoObj, identificationNo);
        lblPedestrianStatus.setText("entry done for nid:" + identificationNo);
    }
}