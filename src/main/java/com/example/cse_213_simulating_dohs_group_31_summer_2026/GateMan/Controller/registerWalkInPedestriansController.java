package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.VisitorEntry;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<VisitorEntry> tblPedestrianEntries;
    @FXML
    private TableColumn<VisitorEntry, String> colEntryId;
    @FXML
    private TableColumn<VisitorEntry, String> colName;
    @FXML
    private TableColumn<VisitorEntry, LocalTime> colTimeIn;
    @FXML
    private TableColumn<VisitorEntry, Integer> colGateNo;
    @FXML
    private TableColumn<VisitorEntry, String> colIdentification;
    @FXML
    private TableColumn<VisitorEntry, String> colStatus;

    @FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1, 2);

        colEntryId.setCellValueFactory(new PropertyValueFactory<>("entryId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        colTimeIn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        colGateNo.setCellValueFactory(new PropertyValueFactory<>("gateNo"));
        colIdentification.setCellValueFactory(new PropertyValueFactory<>("identification"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblPedestrianEntries.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
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
        tblPedestrianEntries.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
        lblPedestrianStatus.setText("entry done for nid:" + identificationNo);
    }
}