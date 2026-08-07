package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.Tenant;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class checkTenantInfoController {

    @FXML
    private TextField txtTenantSearch;
    @FXML
    private TableView<Tenant> tblTenantInfo;
    @FXML
    private TableColumn<Tenant, String> colTenantId;
    @FXML
    private TableColumn<Tenant, String> colTenantName;
    @FXML
    private TableColumn<Tenant, String> colApartment;
    @FXML
    private TableColumn<Tenant, String> colMobile;
    @FXML
    private Label lblTenantStatus;

    @FXML
    public void initialize() {
        colTenantId.setCellValueFactory(new PropertyValueFactory<>("tenantId"));
        colTenantName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colApartment.setCellValueFactory(new PropertyValueFactory<>("apartment"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }

    @FXML
    public void handleSearchTenant(ActionEvent actionEvent) {
        String searchQuery = txtTenantSearch.getText();

        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a search query!");
            alert.showAndWait();
            return;
        }

        ArrayList<Tenant> matchedTenants = SecurityInCharge.checkTenantInformation(searchQuery);

        if (matchedTenants.isEmpty()) {
            lblTenantStatus.setText("No tenant found matching criteria!");
            tblTenantInfo.setItems(FXCollections.observableArrayList());
        } else {
            tblTenantInfo.setItems(FXCollections.observableArrayList(matchedTenants));
            lblTenantStatus.setText("Tenant information fetched successfully!");
        }
    }
}