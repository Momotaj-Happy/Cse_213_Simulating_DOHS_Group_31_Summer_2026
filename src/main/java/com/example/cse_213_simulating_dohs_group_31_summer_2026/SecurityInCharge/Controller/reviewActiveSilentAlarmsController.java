package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SilentAlarm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class reviewActiveSilentAlarmsController {
    @FXML
    private TableColumn<SilentAlarm, String> colAlarmId;
    @FXML
    private Label lblAlarmDetails;
    @FXML
    private TableColumn<SilentAlarm, String> colAlarmLocation;
    @FXML
    private TableColumn<SilentAlarm, String> colAlarmTime;
    @FXML
    private TableView<SilentAlarm> tblActiveAlarms;
    @FXML
    private TableColumn<SilentAlarm, String> colAlarmType;
    @FXML
    private ComboBox<SilentAlarm> cmbSelectedAlarm;

    @FXML
    public void initialize() {
        cmbSelectedAlarm.getItems().setAll(SecurityInCharge.reviewActiveSilentAlarms());
        colAlarmId.setCellValueFactory(new PropertyValueFactory<>("alarmId"));
        colAlarmLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colAlarmTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colAlarmType.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    @FXML
    public void handleFetchAlarms(ActionEvent actionEvent) {
        tblActiveAlarms.getItems().clear();
        tblActiveAlarms.getItems().setAll(SecurityInCharge.reviewActiveSilentAlarms());
    }

    @FXML
    public void handleMuteAlarm(ActionEvent actionEvent) {
        SilentAlarm selectedAlarm = cmbSelectedAlarm.getValue();
        if (selectedAlarm == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select an alarm to mute!");
            alert.showAndWait();
            return;
        }
        selectedAlarm.setActive(false);
    }
}