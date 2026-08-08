// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.Plot;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ********** PLOT RECORD UPDATE CONTROLLER **********
public class UpdatePlotRecordController {

    // ********** UI COMPONENTS **********
    @FXML private TextField searchField;
    @FXML private Label currentRecordLabel;
    @FXML private TextField newAreaField;
    @FXML private TextField newRoadField;
    @FXML private TextField newTypeField;
    @FXML private TextArea remarksArea;
    @FXML private Label statusLabel;

    // ********** DATA STORAGE **********
    private String currentPlotNumber;

    // ********** SEARCH PLOT METHOD **********
    @FXML
    public void searchButtonOnAction(ActionEvent event) {
        String query = searchField.getText();
        if (query == null || query.isEmpty()) {
            Utility.showAlert("Error", "Search input must not be empty.");
            return;
        }

        Plot plot = SessionManager.president.searchPlot(query);
        if (plot == null) {
            currentRecordLabel.setText("No matching plot found.");
            currentPlotNumber = null;
            return;
        }
        currentRecordLabel.setText(String.format("Plot %s | Road %s | Area %.1f kathas | Type %s | Status %s | Owner %s",
                plot.getPlotNumber(), plot.getRoadNumber(), plot.getAreaKathas(), plot.getPlotType(), plot.getStatus(), plot.getOwnerName()));
        currentPlotNumber = query;
    }

    // ********** UPDATE RECORD METHOD **********
    @FXML
    public void updateButtonOnAction(ActionEvent event) {
        if (currentPlotNumber == null) {
            Utility.showAlert("Error", "Search for a plot first.");
            return;
        }

        Double newArea = null;
        String rawArea = newAreaField.getText();
        if (rawArea != null && !rawArea.isEmpty()) {
            try {
                newArea = Double.parseDouble(rawArea);
            } catch (NumberFormatException e) {
                Utility.showAlert("Error", "Area must be a valid number.");
                return;
            }
        }

        SessionManager.president.updatePlotRecord(event, currentPlotNumber, newArea,
                newRoadField.getText(), newTypeField.getText(), remarksArea.getText());
        searchButtonOnAction(event); // refresh display
    }

    // ********** NAVIGATION METHOD **********
    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Utility.openFxml(event, "President Dashboard", "President/PresidentDashboard.fxml");
    }
}
