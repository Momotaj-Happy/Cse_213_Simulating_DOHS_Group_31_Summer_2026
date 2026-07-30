package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Technician_RequestPartsController
{
    @javafx.fxml.FXML
    private TextField customSpecificationTextField;
    @javafx.fxml.FXML
    private ComboBox selectPartComboBox;
    @javafx.fxml.FXML
    private TextField enterQuantityTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void requestPartsOnAction(ActionEvent actionEvent) {
    }
}