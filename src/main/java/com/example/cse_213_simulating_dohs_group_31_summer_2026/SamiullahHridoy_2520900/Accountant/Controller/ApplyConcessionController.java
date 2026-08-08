// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** CONCESSION CONTROLLER **********
public class ApplyConcessionController {

    // ********** UI COMPONENTS **********
    @FXML
    private TextField plotNumberField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField amountField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField approvalRefField;
    @FXML
    private TextArea remarksArea;
    @FXML
    private Label statusLabel;

    public ApplyConcessionController(DatePicker endDatePicker) {
        this.endDatePicker = endDatePicker;
    }

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Martyred Family Exemption", "Senior Citizen Discount", "Hardship Relief", "Other");
    }

    // ********** APPLY CONCESSION METHOD **********
    @FXML
    public void applyButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }

        double amountOrPercent;
        try {
            amountOrPercent = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            Utility.showAlert("Error", "Enter a valid percentage or fixed amount.");
            return;
        }

        SessionManager.accountant.applyConcession(event, plotNumber, typeComboBox.getValue(), amountOrPercent,
                startDatePicker.getValue(), endDatePicker.getValue(), approvalRefField.getText(), remarksArea.getText());
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
