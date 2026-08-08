// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.TenancyApplication;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.User.President;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** TENANT DEPARTURE CONTROLLER **********
public class RecordTenantDepartureController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private Label tenancyDetailsLabel;
    @FXML private DatePicker departureDatePicker;
    @FXML private TextArea remarksArea;
    @FXML private Label statusLabel;

    // ********** RECORD DEPARTURE METHOD **********
    @FXML
    public void recordButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }

        TenancyApplication active = SessionManager.president.findActiveTenancy(plotNumber);
        if (active == null) {
            Utility.showAlert("Error", "No active tenancy agreement found for this plot.");
            tenancyDetailsLabel.setText("");
            return;
        }
        tenancyDetailsLabel.setText("Tenant: " + active.getTenantName()
                + " | Start: " + active.getProposedStartDate() + " | Rent: " + active.getProposedRent());

        boolean proceedDespiteDues = true;
        if (President.hasUnpaidBills(plotNumber)) {
            double outstanding = President.getTotalUnpaidAmount(plotNumber);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, String.format(
                    "Outstanding dues of %.2f TK remain on this plot. Proceed with departure recording anyway? "
                    + "(Dues will remain noted on the record.)", outstanding), ButtonType.YES, ButtonType.NO);
            proceedDespiteDues = confirm.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
            if (!proceedDespiteDues) {
                Utility.showAlert("Cancelled", "Departure not recorded — dues still outstanding.");
                return;
            }
        }

        SessionManager.president.recordTenantDeparture(event, plotNumber, departureDatePicker.getValue(),
                remarksArea.getText(), proceedDespiteDues);
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
