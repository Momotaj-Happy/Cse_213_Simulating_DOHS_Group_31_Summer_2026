package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.UtilityConsumption;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Resident_UtilityController
{
    @javafx.fxml.FXML
    private TableView<UtilityConsumption> utilityConsumptionTableView;
    @javafx.fxml.FXML
    private TableColumn<UtilityConsumption, Integer> electricityTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityConsumption, Integer> gasTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityConsumption, Integer> waterTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        electricityTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("electricityTableCol"));
        gasTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("gasTableCol"));
        waterTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("waterTableCol"));

        ArrayList<UtilityConsumption> cList = new ArrayList<UtilityConsumption>();
        try {
            Utility.loadFrom("ResidentData.bin", cList);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
        }
        for (UtilityConsumption uc: cList){
            uc = new UtilityConsumption(uc.getElectricityAmount(), uc.getWaterAmount(), uc.getGasAmount());
            utilityConsumptionTableView.getItems().add(uc);

        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}