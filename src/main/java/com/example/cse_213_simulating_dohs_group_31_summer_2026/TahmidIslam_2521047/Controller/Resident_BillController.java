package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Resident_BillController
{
    @javafx.fxml.FXML
    private TextField enterYearTextField;
    @javafx.fxml.FXML
    private ComboBox<String> selectMonthComboBox;
    @javafx.fxml.FXML
    private Text billAmountText;


    Bill billObj = null;
    ArrayList<Bill> billList = new ArrayList<Bill>();

    @javafx.fxml.FXML
    public void initialize() {
        selectMonthComboBox.getItems().addAll("January", "February", "March",
                "April", "May", "June", "July", "August", "September", "October", "November",
                "December");
    }

    @javafx.fxml.FXML
    public void payBillButtonOnAction(ActionEvent actionEvent) {
        if (billAmountText.getText().equals("0 TK")){
            Utility.showAlert("Error", "Can't Pay Bill for 0 TK");
            return;
        }
        if (billObj==null){
            Utility.showAlert("Error", "Pay Bill Failed");
            return;
        }
        billList.remove(billObj);
        billAmountText.setText("0 TK");
        Utility.showAlert("Success", "Bill Paid Successfully");
        try {
            Utility.writeInto("BillData.bin", billList, false);
        }
        catch (Exception e){
            System.out.println("Save Failed");
        }
        return;
    }

    @javafx.fxml.FXML
    public void searchBillButtonOnAction(ActionEvent actionEvent) {
        String month = selectMonthComboBox.getValue();
        String year = enterYearTextField.getText();

        if (month == null || year.isEmpty()) {
            Utility.showAlert("Error", "Please fill up all the fields");
            return;
        }






        try {
            Utility.loadFrom("BillData.bin", billList);
        }
        catch (Exception e) {
            Utility.showAlert("Error", "Load Failed.");
            return;


        }

        try{
            int year2 = Integer.parseInt(enterYearTextField.getText());
            for (Bill b: billList) {
                billAmountText.setText("0 TK");
                if(b.getYear()==year2 && b.getMonth().equals(month)){
                    int billAmount=b.getAmount();
                    billAmountText.setText(String.valueOf(billAmount)+ " TK");
                    billObj = b;
                    break;
                }
            }

        }
        catch (Exception e){
            Utility.showAlert("Error", "Year can't be a String");
            return;
        }






    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}