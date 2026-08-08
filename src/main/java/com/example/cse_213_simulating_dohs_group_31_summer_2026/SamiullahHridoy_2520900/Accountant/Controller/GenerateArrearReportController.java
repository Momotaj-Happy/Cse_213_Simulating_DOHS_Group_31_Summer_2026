// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// ********** ARREAR REPORT CONTROLLER **********
public class GenerateArrearReportController {

    // ********** UI COMPONENTS **********
    @FXML private TextField roadNumberField;
    @FXML private TextField minMonthsField;
    @FXML private Label statusLabel;

    // ********** GENERATE REPORT METHOD **********
    @FXML
    public void generateButtonOnAction(ActionEvent event) {
        Integer minMonths = null;
        String raw = minMonthsField.getText();
        if (raw != null && !raw.isEmpty()) {
            try {
                minMonths = Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                Utility.showAlert("Error", "Overdue duration must be a positive integer.");
                return;
            }
        }
        statusLabel.setText(SessionManager.accountant.generateArrearReport(roadNumberField.getText(), minMonths));
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
