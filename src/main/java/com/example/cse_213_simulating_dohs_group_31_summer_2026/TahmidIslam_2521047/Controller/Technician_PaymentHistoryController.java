package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Technician_PaymentHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> amountOfTransactionTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> transactionIdTableCol;
    @javafx.fxml.FXML
    private TableView<Bill> paymentHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn<Bill, String> monthTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> yearTableCol;

    ArrayList<Bill> b;
    @javafx.fxml.FXML
    public void initialize() {
        amountOfTransactionTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("amount"));
        transactionIdTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("billId"));
        monthTableCol.setCellValueFactory(new PropertyValueFactory<Bill, String>("month"));
        yearTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("year"));

        b = Utility.loadObject("BillData.bin");

        for(Bill bill: b){
            if(bill.getTransactionType().equals("Technician Payment")){
                paymentHistoryTableView.getItems().add(bill);
            }
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Maintenance Technician", "MaintenanceTechnician_2521047/Technician-Dashboard-View.fxml");
    }
}