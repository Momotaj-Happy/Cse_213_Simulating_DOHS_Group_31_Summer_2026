// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** REFUND CONTROLLER **********
public class ProcessRefundController {

    // ********** UI COMPONENTS **********
    @FXML
    private TextField plotNumberField;
    @FXML private TextField refundAmountField;
    @FXML private ComboBox<String> methodComboBox;
    @FXML private TextArea remarksArea;
    @FXML private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        methodComboBox.getItems().addAll("Bank Transfer", "Adjust in Next Bill", "Cheque");
    }

    // ********** PROCESS REFUND METHOD **********
    @FXML
    public void processButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(refundAmountField.getText());
        } catch (NumberFormatException e) {
            Utility.showAlert("Error", "Enter a valid refund amount.");
            return;
        }

        SessionManager.accountant.processRefund(event, plotNumber, amount, methodComboBox.getValue(), remarksArea.getText());
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
