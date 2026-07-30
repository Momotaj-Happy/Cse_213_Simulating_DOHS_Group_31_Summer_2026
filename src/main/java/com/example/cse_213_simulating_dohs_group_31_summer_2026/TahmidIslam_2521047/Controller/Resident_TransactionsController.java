package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Resident_TransactionsController
{
    @javafx.fxml.FXML
    private TableView transactionsTableView;
    @javafx.fxml.FXML
    private TableColumn amountTableCol;
    @javafx.fxml.FXML
    private TableColumn transactionIdTableCol;
    @javafx.fxml.FXML
    private TableColumn transactionTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn dateTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}