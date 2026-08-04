package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class Resident_BillController {
    @javafx.fxml.FXML
    private TextField enterYearTextField;
    @javafx.fxml.FXML
    private ComboBox<String> selectMonthComboBox;
    @javafx.fxml.FXML
    private Text billAmountText;
    Resident res;

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
        Resident res = SessionManager.resident;
        if (billAmountText.getText().equals("0 TK")) {
            Utility.showAlert("Error", "Can't Pay Bill for 0 TK");
            return;
        }
        if (billObj == null) {
            Utility.showAlert("Error", "You do not have any bill");
            return;
        }
        billList.remove(billObj);
        billObj.setPaid(true);
        billList.add(billObj);
        String str = res.payBill(billList);
        billAmountText.setText(str);


        return;
    }

    @javafx.fxml.FXML
    public void searchBillButtonOnAction(ActionEvent actionEvent) {
        String month = selectMonthComboBox.getValue();
        String year = enterYearTextField.getText();
        billObj = null;

        if (month == null || year.isEmpty()) {
            Utility.showAlert("Error", "Please fill up all the fields");
            return;
        }



        billList = Utility.loadObject("BillData.bin");


        try {
            int year2 = Integer.parseInt(enterYearTextField.getText());
            for (Bill b : billList) {
                billAmountText.setText("0 TK");
                if (b.getYear() == year2 && b.getMonth().equals(month) && !b.getPaid()) {
                    int billAmount = b.getAmount();
                    billAmountText.setText(String.valueOf(billAmount) + " TK");
                    billObj = b;
                    break;
                }
            }

        } catch (Exception e) {
            Utility.showAlert("Error", "Year can't be a String");
            return;
        }


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }
}