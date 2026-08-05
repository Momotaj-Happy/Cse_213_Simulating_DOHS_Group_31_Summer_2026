package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceTask;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.util.ArrayList;

public class Technician_AllAssignedTaskController
{
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> residentNameTableCol;
    @javafx.fxml.FXML
    private TableView<MaintenanceTask> allAssignedTaskTableView;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> addressTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, LocalDate> taskGivenDateTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> maintenanceTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, Integer> residentIdTableCol;

    ArrayList<MaintenanceTask> taskList;
    MaintenanceTechnician technician = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
        residentIdTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, Integer>("requestId"));
        residentNameTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("residentName"));
        addressTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("residentAddress"));
        maintenanceTypeTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("requestType"));
        taskGivenDateTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, LocalDate>("taskGivenDate"));

        taskList = Utility.loadObject("MaintenanceTaskData.bin");
        for(MaintenanceTask mt: taskList){
            allAssignedTaskTableView.getItems().add(mt);
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void acceptSelectedTaskOnAction(ActionEvent actionEvent) {
        MaintenanceTask mtask = allAssignedTaskTableView.getSelectionModel().getSelectedItem();
        if(mtask==null){
            Utility.showAlert("Error", "Please select any task to accept");
            return;
        }

        technician.acceptMaintenanceTask(mtask, taskList);
    }
}