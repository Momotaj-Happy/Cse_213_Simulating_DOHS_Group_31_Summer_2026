package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.ResidentVehicle;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class searchResidentVehicleController
{
    @javafx.fxml.FXML
    private TableColumn<ResidentVehicle,String> colApartmentNo;
    @javafx.fxml.FXML
    private Label lblSearchResult;
    @javafx.fxml.FXML
    private TableView<ResidentVehicle> tblResidentVehicle;
    @javafx.fxml.FXML
    private TableColumn<ResidentVehicle,String> colLicensePlate;
    @javafx.fxml.FXML
    private TableColumn<ResidentVehicle,String> colOwnerName;
    @javafx.fxml.FXML
    private TextField txtResidentPlateSearch;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSearchResidentPlate(ActionEvent actionEvent) {
    }
}