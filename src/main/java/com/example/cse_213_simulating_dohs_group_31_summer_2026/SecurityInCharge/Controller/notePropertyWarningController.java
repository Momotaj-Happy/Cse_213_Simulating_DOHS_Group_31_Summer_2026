package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.propertyWarnings;

public class notePropertyWarningController {
    @FXML
    private TextField txtPropertyAddress;
    @FXML
    private DatePicker dpWarningDate;
    @FXML
    private Label lblWarningStatus;
    @FXML
    private TextArea txtWarningDetails;
    @FXML
    private TextField txtWarningTime;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleSaveWarning(ActionEvent actionEvent) {
        String address = txtPropertyAddress.getText();
        String timeText = txtWarningTime.getText();
        LocalDate date = dpWarningDate.getValue();
        String warningDetails = txtWarningDetails.getText();

        if (address == null || address.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Property address cannot be empty!");
            alert.showAndWait();
            return;
        }

        if (timeText == null || timeText.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Warning time cannot be empty!");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a valid warning date!");
            alert.showAndWait();
            return;
        }

        if (warningDetails == null || warningDetails.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Warning details cannot be empty!");
            alert.showAndWait();
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeText);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid time format (HH:MM)!");
            alert.showAndWait();
            return;
        }

        boolean isSaved = SecurityInCharge.notePropertyWarning(address, time, date, warningDetails);

        if (isSaved) {
            lblWarningStatus.setText("Property warning note saved successfully! " + propertyWarnings);
        } else {
            lblWarningStatus.setText("Failed to save property warning!");
        }
    }
}