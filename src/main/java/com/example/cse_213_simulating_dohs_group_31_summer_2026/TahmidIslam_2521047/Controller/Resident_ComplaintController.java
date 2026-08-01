package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Complaint;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class Resident_ComplaintController
{
    @javafx.fxml.FXML
    private TextArea complaintTextField;



    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void submitComplaintOnAction(ActionEvent actionEvent) {
        Complaint c = new Complaint(complaintTextField.getText(), "Submitted");
        Utility.showAlert("Success", "Successfully submitted complaint");
        complaintTextField.clear();

    }
}