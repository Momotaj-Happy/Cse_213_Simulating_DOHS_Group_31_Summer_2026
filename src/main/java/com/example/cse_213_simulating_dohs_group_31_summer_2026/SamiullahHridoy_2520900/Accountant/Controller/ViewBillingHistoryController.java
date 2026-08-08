// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

// ********** BILLING HISTORY CONTROLLER **********
public class ViewBillingHistoryController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private Label summaryLabel;
    @FXML private ListView<String> historyListView;

    // ********** SEARCH BILLING HISTORY METHOD **********
    @FXML
    public void searchButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Search input must not be empty.");
            return;
        }

        ArrayList<Bill> history = SessionManager.accountant.getBillingHistory(plotNumber);
        double totalBilled = history.stream().mapToDouble(Bill::getAmount).sum();
        double totalOutstanding = history.stream().filter(b -> !"Paid".equals(b.getStatus())).mapToDouble(Bill::getAmount).sum();

        summaryLabel.setText(String.format("Total billed: %.2f TK | Total outstanding: %.2f TK | Records: %d",
                totalBilled, totalOutstanding, history.size()));
        historyListView.setItems(FXCollections.observableArrayList(
                history.stream().map(b -> b.getBillId() + " | " + b.getBillingPeriod() + " | " + b.getAmount()
                        + " TK | Due " + b.getDueDate() + " | " + b.getStatus()).toList()));
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
