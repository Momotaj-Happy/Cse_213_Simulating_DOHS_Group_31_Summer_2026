// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// ********** TAX DEMAND NOTICES CONTROLLER **********
public class GenerateTaxDemandNoticesController {

    // ********** UI COMPONENTS **********
    @FXML private TextField financialYearField;
    @FXML private Label statusLabel;

    // ********** GENERATE NOTICES METHOD **********
    @FXML
    public void generateButtonOnAction(ActionEvent event) {
        String financialYear = financialYearField.getText();
        if (financialYear == null || !financialYear.matches("\\d{4}-\\d{4}")) {
            Utility.showAlert("Error", "Enter financial year in the format YYYY-YYYY, e.g. 2025-2026.");
            return;
        }
        if (SessionManager.accountant.noticesAlreadyGenerated(financialYear)) {
            Utility.showAlert("Error", "Tax demand notices for " + financialYear + " have already been generated.");
            return;
        }
        SessionManager.accountant.generateTaxDemandNotices(event, financialYear);
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "Billing & Finance Dashboard", "Accountant/AccountantDashboard.fxml");
    }
}
