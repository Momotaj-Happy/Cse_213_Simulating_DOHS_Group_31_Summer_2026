package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;


import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceReport;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Technician_ViewReportController {
    @javafx.fxml.FXML
    private TableColumn<MaintenanceReport, Integer> taskIdTableCol;
    @javafx.fxml.FXML
    private TableView<MaintenanceReport> viewMaintenanceTableView;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceReport, LocalDate> completionDateTableCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceReport, String> generatedReportTableCol;

    MaintenanceTechnician mt = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
        taskIdTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceReport, Integer>("reportId"));
        completionDateTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceReport, LocalDate>("reportGenerateTime"));
        generatedReportTableCol.setCellValueFactory(new PropertyValueFactory<MaintenanceReport, String>("reportDescription"));

        ArrayList<MaintenanceReport> reportsList = Utility.loadObject("MaintenanceReportData.bin");
        for (MaintenanceReport mr : reportsList) {
            viewMaintenanceTableView.getItems().add(mr);
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}

