package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Resident_ProfileController
{
    @javafx.fxml.FXML
    private TextField enterNameTextField;
    @javafx.fxml.FXML
    private TextField enterNewAddressTextField;


    @javafx.fxml.FXML
    private Text addressText;
    @javafx.fxml.FXML
    private Text nameText;
    @javafx.fxml.FXML
    private Text idText;


    Resident res = SessionManager.resident;


    @javafx.fxml.FXML
    public void initialize() {

        idText.setText(String.valueOf(res.getResidentId()));
        nameText.setText(res.getResidentName());
        addressText.setText(res.getResidentAddress());


    }

    @javafx.fxml.FXML
    public void updateProfileOnAction(ActionEvent actionEvent) {

        if (enterNewAddressTextField.getText().isEmpty() || enterNameTextField.getText().isEmpty()){
            Utility.showAlert("Error", "Please fill up all the fields");
            return;
        }
        res.updateProfile(actionEvent, enterNameTextField.getText(), enterNewAddressTextField.getText());
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}