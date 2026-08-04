package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.util.ArrayList;

public class Resident_TransactionsController
{
    @javafx.fxml.FXML
    private TableView<Bill> transactionsTableView;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> amountTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> transactionIdTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, String> transactionTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, String> monthTableCol;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> yearTableCol;

    Resident res = SessionManager.resident;
    ArrayList<Bill> bList;

    @javafx.fxml.FXML
    public void initialize() {
        amountTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("amount"));
        transactionIdTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("billId"));
        transactionTypeTableCol.setCellValueFactory(new PropertyValueFactory<Bill, String>("transactionType"));
        monthTableCol.setCellValueFactory(new PropertyValueFactory<Bill, String>("month"));
        yearTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("year"));

        bList = Utility.loadObject("BillData.bin");


        for (Bill b: bList){
            if(b.getPaid()) {
                transactionsTableView.getItems().add(b);
            }
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}