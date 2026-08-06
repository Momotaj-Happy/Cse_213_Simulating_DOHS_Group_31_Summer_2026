package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.AttendanceRecord;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.LeaveApplication;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Supervisor_AttendanceLeaveController
{
    @FXML
    private TableView<AttendanceRecord> attendanceTableView;
    @FXML
    private TableColumn<AttendanceRecord, String> staffNameTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> checkInTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> checkOutTableCol;
    @FXML
    private TableColumn<AttendanceRecord, String> statusTableCol;
    @FXML
    private TextField correctionReasonTextField;

    @FXML
    private TableView<LeaveApplication> leaveApplicationTableView;
    @FXML
    private TableColumn<LeaveApplication, String> staffNameLeaveTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> startDateTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> endDateTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> reasonTableCol;
    @FXML
    private TextArea leaveRemarksTextArea;

    private final ObservableList<AttendanceRecord> attendanceList = FXCollections.observableArrayList();
    private final ObservableList<LeaveApplication> leaveList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        staffNameTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        checkInTableCol.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutTableCol.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        attendanceTableView.setItems(attendanceList);
        attendanceList.setAll(StaffSupervisor.getTodayAttendance());

        staffNameLeaveTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        startDateTableCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateTableCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        reasonTableCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        leaveApplicationTableView.setItems(leaveList);
        leaveList.setAll(StaffSupervisor.getPendingLeaveApplications());
    }

    @FXML
    public void correctEntryOnAction(ActionEvent actionEvent) {
        AttendanceRecord selected = attendanceTableView.getSelectionModel().getSelectedItem();
        if (selected == null || correctionReasonTextField.getText().isEmpty()) {
            Utility.showAlert("Error", "Select an entry and provide a reason for the correction.");
            return;
        }
        StaffSupervisor.correctAttendanceEntry(selected, correctionReasonTextField.getText());
        Utility.showAlert("Corrected", "Attendance entry for " + selected.getStaffName() + " updated.");
        correctionReasonTextField.clear();
    }

    @FXML
    public void approveLeaveOnAction(ActionEvent actionEvent) {
        decideLeave("Approved");
    }

    @FXML
    public void rejectLeaveOnAction(ActionEvent actionEvent) {
        decideLeave("Rejected");
    }

    private void decideLeave(String decision) {
        LeaveApplication selected = leaveApplicationTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {Utility.showAlert("Error", "Select a leave application first.");
            return;
        }
        StaffSupervisor.decideLeaveApplication(selected, decision, leaveRemarksTextArea.getText());
        leaveList.remove(selected);
        Utility.showAlert("Updated", "Leave application " + selected.getLeaveId() + " has been " + decision.toLowerCase() + ".");
        leaveRemarksTextArea.clear();
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
