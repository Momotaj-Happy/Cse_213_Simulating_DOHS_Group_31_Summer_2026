package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Resident_BillController
{
    @javafx.fxml.FXML
    private TextField enterYearTextField;
    @javafx.fxml.FXML
    private ComboBox<String> selectMonthComboBox;
    @javafx.fxml.FXML
    private Text billAmountText;

    @javafx.fxml.FXML
    public void initialize() {
        selectMonthComboBox.getItems().addAll("January", "February", "March",
                "April", "May", "June", "July", "August", "September", "October", "November",
                "December");
    }

    @javafx.fxml.FXML
    public void payBillButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchBillButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}