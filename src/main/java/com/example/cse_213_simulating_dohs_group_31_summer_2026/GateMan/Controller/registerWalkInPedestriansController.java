package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalTime;

public class registerWalkInPedestriansController
{
    @javafx.fxml.FXML
    private TextField txtPedestrianName;
    @javafx.fxml.FXML
    private Label lblPedestrianStatus;
    @javafx.fxml.FXML
    private TextField txtPedestrianTime;
    @javafx.fxml.FXML
    private ComboBox<Integer> cmbGateNo;
    @javafx.fxml.FXML
    private TextField txtPedestrianId;

    @javafx.fxml.FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1,2);

    }

    @javafx.fxml.FXML
    public void handleRegisterPedestrian(ActionEvent actionEvent) {
        int gateNo = cmbGateNo.getValue();
        String name = txtPedestrianName.getText();
        LocalTime entryTime = LocalTime.parse(txtPedestrianTime.getText());
        String identificationNo = txtPedestrianId.getText();

        GateMan.logVisitorEntry(name,entryTime,gateNo,identificationNo);

        lblPedestrianStatus.setText("entry done for nid:"+ identificationNo);
    }
}