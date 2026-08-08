package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Tools;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.MaintenanceTechnician;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class TechnicianInventoryController
{
    @javafx.fxml.FXML
    private TableColumn<Tools, String> toolNameTableCol;
    @javafx.fxml.FXML
    private TableView<Tools> inventoryTableView;
    @javafx.fxml.FXML
    private TableColumn<Tools, Integer> quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn<Tools, Integer> eachPriceTableCol;
    @javafx.fxml.FXML
    private TableColumn<Tools, Integer> totalPriceTableCol;

    MaintenanceTechnician mt = SessionManager.technician;

    @javafx.fxml.FXML
    public void initialize() {
        toolNameTableCol.setCellValueFactory(new PropertyValueFactory<Tools, String>("toolName"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<Tools, Integer>("quantity"));
        eachPriceTableCol.setCellValueFactory(new PropertyValueFactory<Tools, Integer>("eachPrice"));
        totalPriceTableCol.setCellValueFactory(new PropertyValueFactory<Tools, Integer>("totalPrice"));

        ArrayList<Tools> tools = Utility.loadObject("ToolsData.bin");
        for (Tools t: tools){
            if (!t.isRequested()){
                inventoryTableView.getItems().add(t);
            }
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}