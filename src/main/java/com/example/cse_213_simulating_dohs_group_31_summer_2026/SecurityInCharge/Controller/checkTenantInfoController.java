package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.Tenant;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class checkTenantInfoController
{
    @javafx.fxml.FXML
    private TextField txtTenantSearch;
    @javafx.fxml.FXML
    private TableColumn<Tenant,String> colApartment;
    @javafx.fxml.FXML
    private TableColumn<Tenant,String> colTenantName;
    @javafx.fxml.FXML
    private Label lblTenantStatus;
    @javafx.fxml.FXML
    private TableView<Tenant> tblTenantInfo;
    @javafx.fxml.FXML
    private TableColumn<Tenant,String> colTenantId;
    @javafx.fxml.FXML
    private TableColumn<Tenant,String> colMobile;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSearchTenant(ActionEvent actionEvent) {
    }
}