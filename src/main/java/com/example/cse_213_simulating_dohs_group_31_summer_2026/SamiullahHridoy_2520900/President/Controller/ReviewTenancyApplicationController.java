// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.TenancyApplication;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

// ********** TENANCY APPLICATION REVIEW CONTROLLER **********
public class ReviewTenancyApplicationController {

    // ********** UI COMPONENTS **********
    @FXML private ListView<String> applicationsListView;
    @FXML private TextArea rejectionReasonArea;
    @FXML private Label statusLabel;

    // ********** DATA STORAGE **********
    private ArrayList<TenancyApplication> pending;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        refreshList();
    }

    // ********** HELPER METHODS **********
    private void refreshList() {
        pending = SessionManager.president.getPendingTenancyApplications();
        applicationsListView.setItems(FXCollections.observableArrayList(
                pending.stream().map(t -> t.getApplicationId() + " | Plot " + t.getPlotNumber()
                        + " | Tenant: " + t.getTenantName() + " | Start: " + t.getProposedStartDate()).toList()));
    }

    private TenancyApplication selected() {
        int idx = applicationsListView.getSelectionModel().getSelectedIndex();
        if (idx < 0 || pending == null || idx >= pending.size()) return null;
        return pending.get(idx);
    }

    // ********** APPROVE/REJECT METHODS **********
    @FXML
    public void approveButtonOnAction(ActionEvent event) {
        TenancyApplication app = selected();
        if (app == null) {
            Utility.showAlert("Error", "Please select an application first.");
            return;
        }
        SessionManager.president.decideTenancyApplication(event, app.getApplicationId(), true, null);
        refreshList();
    }

    @FXML
    public void rejectButtonOnAction(ActionEvent event) {
        TenancyApplication app = selected();
        if (app == null) {
            Utility.showAlert("Error", "Please select an application first.");
            return;
        }
        SessionManager.president.decideTenancyApplication(event, app.getApplicationId(), false, rejectionReasonArea.getText());
        rejectionReasonArea.clear();
        refreshList();
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
