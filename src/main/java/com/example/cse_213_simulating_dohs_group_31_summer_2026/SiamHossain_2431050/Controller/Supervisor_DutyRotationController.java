package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.DutyRotation;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Supervisor_DutyRotationController
{
    @FXML
    private TableView<DutyRotation> dutyRotationTableView;
    @FXML
    private TableColumn<DutyRotation, String> staffNameTableCol;
    @FXML
    private TableColumn<DutyRotation, String> currentRoleTableCol;
    @FXML
    private TableColumn<DutyRotation, String> previousDutyTableCol;
    @FXML
    private TableColumn<DutyRotation, Integer> workloadCountTableCol;
    @FXML
    private TableColumn<DutyRotation, String> suggestedDutyTableCol;

    private final ObservableList<DutyRotation> rotationList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        staffNameTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        currentRoleTableCol.setCellValueFactory(new PropertyValueFactory<>("currentRole"));
        previousDutyTableCol.setCellValueFactory(new PropertyValueFactory<>("previousDuty"));
        workloadCountTableCol.setCellValueFactory(new PropertyValueFactory<>("workloadCount"));
        suggestedDutyTableCol.setCellValueFactory(new PropertyValueFactory<>("suggestedDuty"));
        dutyRotationTableView.setItems(rotationList);
        dutyRotationTableView.setEditable(true);
        suggestedDutyTableCol.setCellFactory(javafx.scene.control.cell.TextFieldTableCell.forTableColumn());
        suggestedDutyTableCol.setOnEditCommit(event ->
                event.getRowValue().setSuggestedDuty(event.getNewValue()));
    }

    @FXML
    public void fetchStaffDutiesOnAction(ActionEvent actionEvent) {rotationList.setAll(StaffSupervisor.fetchStaffForRotation());}

    @FXML
    public void saveRotationOnAction(ActionEvent actionEvent) {
        boolean success = StaffSupervisor.saveWeeklyRotation(new java.util.ArrayList<>(rotationList));
        if (success) {Utility.showAlert("Saved", "Weekly rotation saved and applied to future task generation.");}

        else {Utility.showAlert("Error", "Fetch staff duties first before saving.");}
    }

    @FXML
    public void publishRotationOnAction(ActionEvent actionEvent) {
        boolean success = StaffSupervisor.publishWeeklyRotation();
        if (success) {Utility.showAlert("Published", "Staff members have been notified about next week's duty.");}

        else {Utility.showAlert("Error", "Save the rotation before publishing.");}
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
