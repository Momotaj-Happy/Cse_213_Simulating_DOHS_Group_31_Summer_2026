// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

// ********** PAYMENT RECORDING CONTROLLER **********
public class RecordPaymentController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private ComboBox<String> billComboBox;
    @FXML private DatePicker paymentDatePicker;
    @FXML private TextField amountField;
    @FXML private ComboBox<String> methodComboBox;
    @FXML private TextField refNumberField;
    @FXML private Label statusLabel;

    // ********** DATA STORAGE **********
    private ArrayList<Bill> unpaidBills;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        methodComboBox.getItems().addAll("Cash", "Bank Transfer", "Cheque", "Mobile Banking");
    }

    // ********** LOOKUP UNPAID BILLS METHOD **********
    @FXML
    public void lookupButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Enter a plot number first.");
            return;
        }
        unpaidBills = SessionManager.accountant.getUnpaidBillsForPlot(plotNumber);
        billComboBox.setItems(FXCollections.observableArrayList(
                unpaidBills.stream().map(b -> b.getBillId() + " | " + b.getBillingPeriod() + " | " + b.getAmount() + " TK | " + b.getStatus()).toList()));
        if (unpaidBills.isEmpty()) Utility.showAlert("Info", "No unpaid bills found for this plot.");
    }

    // ********** RECORD PAYMENT METHOD **********
    @FXML
    public void recordButtonOnAction(ActionEvent event) {
        int idx = billComboBox.getSelectionModel().getSelectedIndex();
        if (unpaidBills == null || idx < 0 || idx >= unpaidBills.size()) {
            Utility.showAlert("Error", "Select a bill to pay first (click Find, then choose one).");
            return;
        }
        Bill bill = unpaidBills.get(idx);

        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            Utility.showAlert("Error", "Enter a valid payment amount.");
            return;
        }

        String method = methodComboBox.getValue();
        if (method == null) {
            Utility.showAlert("Error", "Select a payment method.");
            return;
        }

        SessionManager.accountant.recordPayment(event, bill.getBillId(), paymentDatePicker.getValue(),
                amount, method, refNumberField.getText());
        lookupButtonOnAction(event); // refresh unpaid list
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
