// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// ********** PLOT ALLOTMENT CONTROLLER **********
public class RegisterPlotAllotmentController {

    // ********** UI COMPONENTS **********
    @FXML private TextField applicantIdField;
    @FXML private TextField plotNumberField;
    @FXML private DatePicker allotmentDatePicker;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("Original Allottee", "Transferred Allottee");
    }

    // ********** REGISTER ALLOTMENT METHOD **********
    @FXML
    public void registerButtonOnAction(ActionEvent event) {
        String applicantId = applicantIdField.getText();
        String plotNumber = plotNumberField.getText();

        if (applicantId == null || applicantId.isEmpty() || plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please fill all required fields.");
            return;
        }

        SessionManager.president.registerPlotAllotment(event, applicantId, plotNumber,
                allotmentDatePicker.getValue(), categoryComboBox.getValue());
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
