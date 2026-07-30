package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Technician_AllAcceptedTaskController
{
    @javafx.fxml.FXML
    private TableColumn residentNameTableCol;
    @javafx.fxml.FXML
    private TableColumn isCompletedTableCol;
    @javafx.fxml.FXML
    private TableView allAcceptedTaskTableView;
    @javafx.fxml.FXML
    private TableColumn addressTableCol;
    @javafx.fxml.FXML
    private TableColumn taskGivenDateTableCol;
    @javafx.fxml.FXML
    private TableColumn residentIdTaleCol;
    @javafx.fxml.FXML
    private TableColumn typeTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}