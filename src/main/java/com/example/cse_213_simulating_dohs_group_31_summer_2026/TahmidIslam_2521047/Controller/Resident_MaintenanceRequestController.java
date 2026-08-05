package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.MaintenanceTask;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

public class Resident_MaintenanceRequestController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectRequiredMaintenanceComboBox;
    @javafx.fxml.FXML
    private TextArea maintenanceWorkTextField;

    @javafx.fxml.FXML

    Resident res = SessionManager.resident;

    public void initialize() {
        selectRequiredMaintenanceComboBox.getItems().addAll("Electricity", "Water", "Gas", "Others");

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void requestMaintenanceWorkOnAction(ActionEvent actionEvent) {
        String s = selectRequiredMaintenanceComboBox.getValue();
        if (s==null){
            Utility.showAlert("Error", "Please select the maintenance Type");
            return;
        }
        if (maintenanceWorkTextField.getText().isEmpty()){
            Utility.showAlert("Error", "Please write about the maintenance Problem");
            return;
        }

        MaintenanceTask m = new MaintenanceTask(res.getResidentId(), res.getResidentName(),
                selectRequiredMaintenanceComboBox.getValue(), res.getResidentAddress(), maintenanceWorkTextField.getText(),
                LocalDate.now(), false);
        res.requestMaintenanceWork(m);
    }
}