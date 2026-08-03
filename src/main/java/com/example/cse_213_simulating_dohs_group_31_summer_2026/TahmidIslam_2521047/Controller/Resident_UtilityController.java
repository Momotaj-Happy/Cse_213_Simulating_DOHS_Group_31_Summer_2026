package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.UtilityConsumption;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
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

    Resident res = SessionManager.resident;

    @javafx.fxml.FXML
    public void initialize() {
        electricityTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("electricityAmount"));
        gasTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("gasAmount"));
        waterTableCol.setCellValueFactory(new PropertyValueFactory<UtilityConsumption, Integer>("waterAmount"));

        ArrayList<UtilityConsumption> ucList = Utility.loadObject("UtilityConsumptionData.bin");

        for (UtilityConsumption uc: ucList){
            uc = new UtilityConsumption(uc.getUtilityConsumptionId(),
                    uc.getElectricityAmount(), uc.getWaterAmount(), uc.getGasAmount());
            utilityConsumptionTableView.getItems().add(uc);

        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}