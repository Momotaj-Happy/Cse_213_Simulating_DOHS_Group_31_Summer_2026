package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceTask;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.ArrayList;

public class Technician_AllAcceptedTaskController
{
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> residentNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> isCompletedTableCol;
    @javafx.fxml.FXML
    private TableView<MaintenanceTask> allAcceptedTaskTableView;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> addressTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, LocalDate> taskGivenDateTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, Integer> residentIdTaleCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceTask, String> typeTableCol;

    MaintenanceTechnician mt = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
        residentNameTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("residentName"));
        isCompletedTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("status"));
        addressTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("residentAddress"));
        taskGivenDateTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, LocalDate>("taskGivenDate"));
        residentIdTaleCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, Integer>("requestId"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceTask, String>("requestType"));

        ArrayList<MaintenanceTask> taskList = mt.getAllAcceptedTask();
        for (MaintenanceTask task: taskList){
            allAcceptedTaskTableView.getItems().add(task);
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}