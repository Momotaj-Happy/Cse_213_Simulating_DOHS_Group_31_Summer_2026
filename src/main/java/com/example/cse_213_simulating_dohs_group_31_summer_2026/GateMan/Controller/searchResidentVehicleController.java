package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.ResidentVehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class searchResidentVehicleController {
    @FXML
    private TableColumn<ResidentVehicle, String> colApartmentNo;
    @FXML
    private Label lblSearchResult;
    @FXML
    private TableView<ResidentVehicle> tblResidentVehicle;
    @FXML
    private TableColumn<ResidentVehicle, String> colLicensePlate;
    @FXML
    private TableColumn<ResidentVehicle, String> colOwnerName;
    @FXML
    private TextField txtResidentPlateSearch;

    @FXML
    public void initialize() {
        colApartmentNo.setCellValueFactory(new PropertyValueFactory<>("apartmentNo"));
        colLicensePlate.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        colOwnerName.setCellValueFactory(new PropertyValueFactory<>("ownerName"));

        tblResidentVehicle.getItems().setAll(GateMan.residentVehicles);
    }

    @FXML
    public void handleSearchResidentPlate(ActionEvent actionEvent) {
        String filterText = txtResidentPlateSearch.getText();

        if (filterText == null || filterText.trim().isEmpty()) {
            lblSearchResult.setText("Please enter search text!");
            return;
        }

        ArrayList<ResidentVehicle> filterArrayList = GateMan.searchResidentVehiclePlate(filterText);
        tblResidentVehicle.getItems().clear();
        tblResidentVehicle.getItems().setAll(filterArrayList);
        lblSearchResult.setText("Search completed!");
    }
}