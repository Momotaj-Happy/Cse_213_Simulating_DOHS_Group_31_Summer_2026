// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** ENCROACHMENT VIOLATION CONTROLLER **********
public class LogEncroachmentViolationController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private ComboBox<String> violationTypeComboBox;
    @FXML private DatePicker observedDatePicker;
    @FXML private TextField reportingOfficerField;
    @FXML private TextArea descriptionArea;
    @FXML private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        violationTypeComboBox.getItems().addAll(
                "Unauthorized Construction", "Boundary Encroachment", "Illegal Commercial Use", "Other");
    }

    // ********** LOG VIOLATION METHOD **********
    @FXML
    public void logButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }

        SessionManager.president.logEncroachmentViolation(event, plotNumber, violationTypeComboBox.getValue(),
                descriptionArea.getText(), observedDatePicker.getValue(), reportingOfficerField.getText());
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
