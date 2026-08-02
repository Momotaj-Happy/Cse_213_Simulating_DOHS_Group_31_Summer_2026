package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Complaint;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Resident_ComplaintController
{
    @javafx.fxml.FXML
    private TextArea complaintTextField;

    ArrayList<Resident> rList = new ArrayList<Resident>();

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void submitComplaintOnAction(ActionEvent actionEvent) {
        if (complaintTextField.getText().isEmpty()){
            Utility.showAlert("Error", "Please write something for submitting a complaint");
            return;
        }
        try{
            Utility.loadFrom("ResidentData.bin", rList);
        }
        catch (Exception e) {
            Utility.showAlert("Error", "Load Failed");
            return;
        }
        Resident r = rList.getFirst();

        Complaint c = new Complaint(r.getResidentId(), complaintTextField.getText(), "Submitted");
        complaintTextField.clear();
        r.submitComplaint(c);

    }
}