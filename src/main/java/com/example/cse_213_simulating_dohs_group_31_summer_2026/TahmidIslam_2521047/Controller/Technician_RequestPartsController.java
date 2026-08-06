package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Tools;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Technician_RequestPartsController
{
    @javafx.fxml.FXML
    private TextField customSpecificationTextField;
    @javafx.fxml.FXML
    private TextField enterQuantityTextField;
    @javafx.fxml.FXML
    private TextField enterToolNameTextField;

    MaintenanceTechnician mt = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void requestPartsOnAction(ActionEvent actionEvent) {
        if(enterQuantityTextField.getText().isEmpty() || enterToolNameTextField.getText().isEmpty()){
            Utility.showAlert("Error", "You must fill all mandatory fields");
            return;
        }

        try{
            int a = Integer.parseInt(enterQuantityTextField.getText());
        }
        catch (Exception e){
            Utility.showAlert("Error", "Quantity must be an Integer");
            return;
        }
        Tools tools = new Tools(enterToolNameTextField.getText(), customSpecificationTextField.getText(),
                Integer.parseInt(enterQuantityTextField.getText()), 0, 0, true);
        mt.requestParts(tools);
        enterQuantityTextField.clear();
        customSpecificationTextField.clear();
        enterQuantityTextField.clear();
    }
}