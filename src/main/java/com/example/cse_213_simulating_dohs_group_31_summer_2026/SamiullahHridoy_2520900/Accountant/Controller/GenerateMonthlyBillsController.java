// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Month;

// ********** MONTHLY BILLS CONTROLLER **********
public class GenerateMonthlyBillsController {

    // ********** UI COMPONENTS **********
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField yearField;
    @FXML
    private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        for (Month m : Month.values()) monthComboBox.getItems().add(m.name());
    }

    // ********** GENERATE BILLS METHOD **********
    @FXML
    public void generateButtonOnAction(ActionEvent event) {
        String monthName = monthComboBox.getValue();
        if (monthName == null) {
            Utility.showAlert("Error", "Please select a billing month.");
            return;
        }
        int year;
        try {
            year = Integer.parseInt(yearField.getText());
        } catch (NumberFormatException e) {
            Utility.showAlert("Error", "Please enter a valid year.");
            return;
        }
        int month = Month.valueOf(monthName).getValue();

        if (SessionManager.accountant.alreadyBilled(month, year)) {
            Utility.showAlert("Error", "Bills for " + monthName + " " + year + " have already been generated.");
            return;
        }

        SessionManager.accountant.generateMonthlyBills(event, month, year);
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
