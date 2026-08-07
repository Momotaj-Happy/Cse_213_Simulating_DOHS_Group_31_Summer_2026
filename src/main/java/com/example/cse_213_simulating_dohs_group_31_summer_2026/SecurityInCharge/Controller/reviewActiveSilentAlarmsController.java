package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SilentAlarm;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.Tenant;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        colAlarmId.setCellValueFactory(new PropertyValueFactory<SilentAlarm,String>("alarmId"));
        colAlarmLocation.setCellValueFactory(new PropertyValueFactory<SilentAlarm,String>("location"));
        colAlarmTime.setCellValueFactory(new PropertyValueFactory<SilentAlarm,String>("time"));
        colAlarmType.setCellValueFactory(new PropertyValueFactory<SilentAlarm,String>("type"));
    }


    @javafx.fxml.FXML
    public void handleFetchAlarms(ActionEvent actionEvent) {
        tblActiveAlarms.getItems().clear();
        tblActiveAlarms.getItems().setAll(SecurityInCharge.reviewActiveSilentAlarms());

    }

    @javafx.fxml.FXML
    public void handleMuteAlarm(ActionEvent actionEvent) {
        SilentAlarm selectedAlarm = cmbSelectedAlarm.getValue();
        selectedAlarm.setActive(false);
    }
}