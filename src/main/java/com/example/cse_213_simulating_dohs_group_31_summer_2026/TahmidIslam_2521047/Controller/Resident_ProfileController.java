package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

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


    ArrayList<Resident> rList= new ArrayList<Resident>();

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Resident> rList= new ArrayList<Resident>();
        try {
            Utility.loadFrom("ResidentData.bin", rList);

        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
            return;
        }

        idText.setText(String.valueOf(rList.getFirst().getResidentId()));
        nameText.setText(rList.getFirst().getResidentName());
        addressText.setText(rList.getFirst().getResidentAddress());


    }

    @javafx.fxml.FXML
    public void updateProfileOnAction(ActionEvent actionEvent) {
        /*try {
            Utility.loadFrom("ResidentData.bin", rList);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed" + e);
            return;
        }*/
        if (enterNewAddressTextField.getText().isEmpty() || enterNameTextField.getText().isEmpty()){
            Utility.showAlert("Error", "Please fill up all the fields");
            return;
        }
        rList.getFirst().updateProfile(actionEvent, enterNewAddressTextField.getText(), enterNewAddressTextField.getText());
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}