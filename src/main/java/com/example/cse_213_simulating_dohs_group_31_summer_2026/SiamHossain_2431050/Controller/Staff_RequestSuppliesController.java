package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Staff_RequestSuppliesController
{
    @FXML
    private ComboBox<String> selectItemComboBox;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextArea reasonTextArea;

    @FXML
    public void initialize() {
        selectItemComboBox.getItems().addAll("Broom", "Mop", "Garbage Bag", "Gloves", "Mask",
                "Toilet Cleaner", "Mosque Cleaning Liquid", "Air Freshener", "Light Bulb", "Padlock", "Other");
    }

    @FXML
    public void submitRequestOnAction(ActionEvent actionEvent) {
        int quantity;
        try {
            quantity = Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException e) {
            Utility.showAlert("Error", "Quantity must be a positive number.");
            return;
        }
        boolean success = SessionManager.residentialOperationsStaff.requestSupplies(
                selectItemComboBox.getValue(), quantity, reasonTextArea.getText());
        if (success) {
            Utility.showAlert("Success", "Supply request submitted. Awaiting supervisor approval.");
            quantityTextField.clear();
            reasonTextArea.clear();
        } else {
            Utility.showAlert("Error", "Choose an item and enter a valid quantity.");
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
