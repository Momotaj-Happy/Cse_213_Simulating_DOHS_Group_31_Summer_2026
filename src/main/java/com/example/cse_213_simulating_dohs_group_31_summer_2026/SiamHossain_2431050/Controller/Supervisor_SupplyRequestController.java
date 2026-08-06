package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.SupplyRequest;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Supervisor_SupplyRequestController
{
    @FXML
    private TableView<SupplyRequest> supplyRequestTableView;
    @FXML
    private TableColumn<SupplyRequest, String> staffNameTableCol;
    @FXML
    private TableColumn<SupplyRequest, String> itemTableCol;
    @FXML
    private TableColumn<SupplyRequest, Integer> quantityTableCol;
    @FXML
    private TableColumn<SupplyRequest, String> reasonTableCol;
    @FXML
    private TableColumn<SupplyRequest, String> urgencyTableCol;
    @FXML
    private TextField rejectionReasonTextField;

    private final ObservableList<SupplyRequest> requestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        staffNameTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        itemTableCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        reasonTableCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        urgencyTableCol.setCellValueFactory(new PropertyValueFactory<>("urgency"));
        supplyRequestTableView.setItems(requestList);

        requestList.setAll(StaffSupervisor.getPendingSupplyRequests());
    }

    @FXML
    public void approveOnAction(ActionEvent actionEvent) {
        decide("Approve");
    }

    @FXML
    public void rejectOnAction(ActionEvent actionEvent) {
        decide("Reject");
    }

    @FXML
    public void forwardToPresidentOnAction(ActionEvent actionEvent) {
        decide("Forward");
    }

    private void decide(String decision) {
        SupplyRequest selected = supplyRequestTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Utility.showAlert("Error", "Select a request first.");
            return;
        }

        boolean success = StaffSupervisor.decideSupplyRequest(selected, decision, rejectionReasonTextField.getText());
        if (success) {
            supplyRequestTableView.refresh();
            Utility.showAlert("Updated", "Request for " + selected.getItem() + " is now " + selected.getStatus() + ".");
            rejectionReasonTextField.clear();}

        else {Utility.showAlert("Error", "A reason is required to reject a request.");}
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
