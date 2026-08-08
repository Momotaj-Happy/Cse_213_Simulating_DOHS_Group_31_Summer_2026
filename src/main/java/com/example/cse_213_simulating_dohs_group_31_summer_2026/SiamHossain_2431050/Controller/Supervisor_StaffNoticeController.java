package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.StaffNotice;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// Goal-8 (User-7): Supervisor sends a notice to all or selected staff.
public class Supervisor_StaffNoticeController
{
    @FXML
    private ComboBox<String> selectAudienceComboBox;
    @FXML
    private TextField noticeTitleTextField;
    @FXML
    private TextArea noticeMessageTextArea;

    @FXML
    public void initialize() {
        selectAudienceComboBox.getItems().addAll("All Staff", "Cleaners", "Collectors", "Mosque Staff",
                "Caretakers", "Liftmen", "Gardeners");
    }

    @FXML
    public void previewNoticeOnAction(ActionEvent actionEvent) {
        if (noticeTitleTextField.getText().isEmpty() || noticeMessageTextArea.getText().isEmpty()) {
            Utility.showAlert("Error", "Title and message cannot be empty.");
            return;}

        Utility.showAlert("Preview - " + noticeTitleTextField.getText(), noticeMessageTextArea.getText());
    }

    @FXML
    public void sendNoticeOnAction(ActionEvent actionEvent) {
        StaffNotice notice = new StaffNotice(selectAudienceComboBox.getValue(),
                noticeTitleTextField.getText(), noticeMessageTextArea.getText(), null);
        boolean success = StaffSupervisor.sendStaffNotice(notice);
        if (success) {
            Utility.showAlert("Success", "Notice sent successfully.");
            noticeTitleTextField.clear();
            noticeMessageTextArea.clear();}

        else {Utility.showAlert("Error", "Title and message cannot be empty.");}
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
