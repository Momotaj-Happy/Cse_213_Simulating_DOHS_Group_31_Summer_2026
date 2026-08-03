package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

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
    private TableColumn<Bill, LocalDate> dateTableCol;
    ArrayList<Bill> transaction;
    ArrayList<Resident> rList;

    @javafx.fxml.FXML
    public void initialize() {
        amountTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("amount"));
        transactionIdTableCol.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("billId"));
        transactionTypeTableCol.setCellValueFactory(new PropertyValueFactory<Bill, String>("transactionType"));
        try{
            Utility.loadFrom2("ResidentData.bin", rList);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
            return;
        }

        try{
            Utility.loadFrom2("BillData.bin", transaction);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
            return;
        }
        for (Bill b: transaction){
            transactionsTableView.getItems().add(b);
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}