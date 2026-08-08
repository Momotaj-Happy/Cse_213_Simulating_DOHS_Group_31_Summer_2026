// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** OCCUPANCY CERTIFICATE CONTROLLER **********
public class GenerateOccupancyCertificateController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private DatePicker inspectionDatePicker;
    @FXML private TextField inspectorNameField;
    @FXML private TextArea remarksArea;
    @FXML private Label statusLabel;

    // ********** GENERATE CERTIFICATE METHOD **********
    @FXML
    public void generateButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        if (plotNumber == null || plotNumber.isEmpty()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }

        SessionManager.president.generateOccupancyCertificate(event, plotNumber,
                inspectionDatePicker.getValue(), inspectorNameField.getText(), remarksArea.getText());
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
