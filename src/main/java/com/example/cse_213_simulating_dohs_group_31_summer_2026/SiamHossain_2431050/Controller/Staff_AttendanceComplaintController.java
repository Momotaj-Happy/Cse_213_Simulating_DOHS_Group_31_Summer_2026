package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.AttendanceRecord;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Staff_AttendanceComplaintController
{
    @FXML
    private TableView<AttendanceRecord> attendanceSummaryTableView;
    @FXML
    private TableColumn<AttendanceRecord, String> dateTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> checkInTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> checkOutTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> statusTableCol;

    @FXML
    private ComboBox<String> selectComplaintTypeComboBox;
    @FXML
    private DatePicker incidentDateDatePicker;
    @FXML
    private TextArea complaintDetailsTextArea;

    private final ObservableList<AttendanceRecord> attendanceList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        checkInTableCol.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutTableCol.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        attendanceSummaryTableView.setItems(attendanceList);

        selectComplaintTypeComboBox.getItems().addAll("Unpaid Salary", "Bonus Issue", "Broken Tool",
                "Resident Misconduct", "Unsafe Working Condition", "Other");

        myAttendanceOnAction(null);
    }

    @FXML
    public void myAttendanceOnAction(ActionEvent actionEvent) {
        attendanceList.setAll(SessionManager.residentialOperationsStaff.getMyAttendance());
    }

    @FXML
    public void submitComplaintTabOnAction(ActionEvent actionEvent) {
        // Just switches the visible tab in the FXML - no data work needed here.
    }

    @FXML
    public void submitComplaintOnAction(ActionEvent actionEvent) {
        boolean success = SessionManager.residentialOperationsStaff.submitComplaint(
                selectComplaintTypeComboBox.getValue(), incidentDateDatePicker.getValue(), complaintDetailsTextArea.getText());
        if (success) {
            Utility.showAlert("Submitted", "Your complaint has been submitted. Your supervisor will review it.");
            complaintDetailsTextArea.clear();
        } else {
            Utility.showAlert("Error", "Please select a complaint type and enter the details.");
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
