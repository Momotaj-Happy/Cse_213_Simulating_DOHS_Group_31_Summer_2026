// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// ********** PLOT TRANSFER CONTROLLER **********
public class ProcessPlotTransferController {

    // ********** UI COMPONENTS **********
    @FXML private TextField plotNumberField;
    @FXML private TextField newOwnerIdField;
    @FXML private DatePicker transferDatePicker;
    @FXML private ComboBox<String> reasonComboBox;
    @FXML private Label statusLabel;

    // ********** INITIALIZATION **********
    @FXML
    public void initialize() {
        reasonComboBox.getItems().addAll("Inheritance", "Sale", "Official Transfer");
    }

    // ********** PROCESS TRANSFER METHOD **********
    @FXML
    public void transferButtonOnAction(ActionEvent event) {
        String plotNumber = plotNumberField.getText();
        String newOwnerId = newOwnerIdField.getText();

        if (plotNumber == null || plotNumber.isEmpty() || newOwnerId == null || newOwnerId.isEmpty()) {
            Utility.showAlert("Error", "Please fill all required fields.");
            return;
        }


    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
