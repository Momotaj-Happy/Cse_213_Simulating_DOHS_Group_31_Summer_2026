package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Technician_ViewReportController
{
    @javafx.fxml.FXML
    private TableColumn taskIdTableCol;
    @javafx.fxml.FXML
    private TableView viewMaintenanceTableView;
    @javafx.fxml.FXML
    private TableColumn completionDateTableCol;
    @javafx.fxml.FXML
    private TableColumn generatedReportTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}