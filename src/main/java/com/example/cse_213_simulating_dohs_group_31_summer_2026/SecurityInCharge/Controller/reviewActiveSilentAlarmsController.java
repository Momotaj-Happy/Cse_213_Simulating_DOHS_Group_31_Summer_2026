package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SilentAlarm;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.Tenant;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class reviewActiveSilentAlarmsController
{
    @javafx.fxml.FXML
    private TableColumn<SilentAlarm,String> colAlarmId;
    @javafx.fxml.FXML
    private Label lblAlarmDetails;
    @javafx.fxml.FXML
    private TableColumn<SilentAlarm,String> colAlarmLocation;
    @javafx.fxml.FXML
    private TableColumn<SilentAlarm,String> colAlarmTime;
    @javafx.fxml.FXML
    private TableView<SilentAlarm> tblActiveAlarms;
    @javafx.fxml.FXML
    private TableColumn<SilentAlarm,String> colAlarmType;
    @javafx.fxml.FXML
    private ComboBox<SilentAlarm> cmbSelectedAlarm;

    @javafx.fxml.FXML
    public void initialize() {
        cmbSelectedAlarm.getItems().setAll(SecurityInCharge.reviewActiveSilentAlarms());
    }

    @Deprecated
    public void handleViewAlarmDetails(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleFetchAlarms(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleMuteAlarm(ActionEvent actionEvent) {
    }
}