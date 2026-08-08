package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.VisitorEntry;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<VisitorEntry> tblVisitorEntries;
    @FXML
    private TableColumn<VisitorEntry, String> colEntryId;
    @FXML
    private TableColumn<VisitorEntry, String> colGuestName;
    @FXML
    private TableColumn<VisitorEntry, LocalTime> colEntryTime;
    @FXML
    private TableColumn<VisitorEntry, Integer> colGateNo;
    @FXML
    private TableColumn<VisitorEntry, String> colVehicleNo;
    @FXML
    private TableColumn<VisitorEntry, String> colStatus;

    @FXML
    public void initialize() {
        cmbGateNo.getItems().setAll(1, 2);

        colEntryId.setCellValueFactory(new PropertyValueFactory<>("entryId"));
        colGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        colEntryTime.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        colGateNo.setCellValueFactory(new PropertyValueFactory<>("gateNo"));
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblVisitorEntries.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
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
        tblVisitorEntries.setItems(FXCollections.observableArrayList(GateMan.visitorEntries));
        lblLogVisitorStatus.setText("entry done for vehicle:" + vehicleNo);
    }
}