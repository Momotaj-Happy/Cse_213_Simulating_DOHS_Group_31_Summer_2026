// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

// ********** DASHBOARD CONTROLLER **********
public class AccountantDashboardController {

    // ********** UI COMPONENTS **********
    @FXML
    private Label summaryLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        summaryLabel.setText("Welcome, Accountant " + SessionManager.accountant.getName());
    }

    // ********** NAVIGATION METHODS **********
    @FXML
    public void goGenerateMonthlyBills(ActionEvent event) {
        Utility.openFxml(event, "Generate Monthly Bills", "Accountant/GenerateMonthlyBillsView.fxml");
    }

    @FXML
    public void goRecordPayment(ActionEvent event) {
        Utility.openFxml(event, "Record Payment", "Accountant/RecordPaymentView.fxml");
    }

    @FXML
    public void goArrearReport(ActionEvent event) {
        Utility.openFxml(event, "Arrear Report", "Accountant/GenerateArrearReportView.fxml");
    }

    @FXML
    public void goConcessions(ActionEvent event) {
        Utility.openFxml(event, "Concessions & Adjustments", "Accountant/ApplyConcessionView.fxml");
    }

    @FXML
    public void goTaxDemandNotices(ActionEvent event) {
        Utility.openFxml(event, "Tax & Ground Rent Notices", "Accountant/GenerateTaxDemandNoticesView.fxml");
    }

    @FXML
    public void goBillingHistory(ActionEvent event) {
        Utility.openFxml(event, "Billing History", "Accountant/ViewBillingHistoryView.fxml");
    }

    @FXML
    public void goRefunds(ActionEvent event) {
        Utility.openFxml(event, "Refunds & Adjustments", "Accountant/ProcessRefundView.fxml");
    }

    @FXML
    public void goFinancialSummary(ActionEvent event) {
        Utility.openFxml(event, "Monthly Financial Summary", "Accountant/GenerateMonthlyFinancialSummaryView.fxml");
    }

    // ********** SIGN OUT METHOD **********
    @FXML
    public void signOutOnAction(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to sign out?", ButtonType.YES, ButtonType.NO);
        if (confirm.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            SessionManager.accountant.logout();
            SessionManager.accountant = null;
            Utility.openFxml(event, "DOHS Management System - Login", "LoginView.fxml");
        }
    }
}
