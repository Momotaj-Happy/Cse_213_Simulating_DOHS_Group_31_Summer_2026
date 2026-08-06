package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Staff_ReportProblemController
{
    @FXML
    private ComboBox<String> selectProblemTypeComboBox;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextArea descriptionTextArea;

    @FXML
    public void initialize() {
        selectProblemTypeComboBox.getItems().addAll("Blocked Drain", "Broken Streetlight", "Cracked Footpath",
                "Open Manhole", "Dirty Mosque Toilet", "Lift Fault", "Water Leak", "Garbage Overflow", "Other");
    }

    @FXML
    public void attachPhotoOnAction(ActionEvent actionEvent) {
        Utility.showAlert("Photo Attached", "Photo attached to this report (optional).");
    }

    @FXML
    public void submitReportOnAction(ActionEvent actionEvent) {
        boolean success = SessionManager.residentialOperationsStaff.reportProblem(
                selectProblemTypeComboBox.getValue(), locationTextField.getText(), descriptionTextArea.getText());
        if (success) {
            Utility.showAlert("Success", "Problem reported successfully.");
            locationTextField.clear();
            descriptionTextArea.clear();
        } else {
            Utility.showAlert("Error", "Problem type and location are required.");
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
