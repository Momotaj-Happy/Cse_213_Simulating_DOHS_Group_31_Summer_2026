package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.LeaveApplication;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Staff_LeaveController
{
    @FXML
    private ComboBox<String> selectLeaveTypeComboBox;
    @FXML
    private DatePicker startDateDatePicker;
    @FXML
    private DatePicker endDateDatePicker;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private Text totalLeaveDaysText;
    @FXML
    private TableView<LeaveApplication> leaveHistoryTableView;
    @FXML
    private TableColumn<LeaveApplication, String> leaveIdTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> startDateTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> endDateTableCol;
    @FXML
    private TableColumn<LeaveApplication, String> statusTableCol;

    private final ObservableList<LeaveApplication> history = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        selectLeaveTypeComboBox.getItems().addAll("Casual Leave", "Sick Leave", "Earned Leave", "Emergency Leave");

        leaveIdTableCol.setCellValueFactory(new PropertyValueFactory<>("leaveId"));
        startDateTableCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateTableCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        leaveHistoryTableView.setItems(history);
        history.setAll(SessionManager.residentialOperationsStaff.getMyLeaveHistory());
    }

    @FXML
    public void attachDocumentOnAction(ActionEvent actionEvent) {
        Utility.showAlert("Document Attached", "Supporting document attached (optional).");
    }

    @FXML
    public void submitApplicationOnAction(ActionEvent actionEvent) {
        LeaveApplication application = SessionManager.residentialOperationsStaff.applyForLeave(
                selectLeaveTypeComboBox.getValue(), startDateDatePicker.getValue(), endDateDatePicker.getValue(), reasonTextArea.getText());
        if (application == null) {
            Utility.showAlert("Error", "Please pick a valid leave type and date range.");
            return;
        }
        totalLeaveDaysText.setText(application.getTotalDays() + " day(s)");
        history.add(application);
        Utility.showAlert("Submitted", "Leave application saved with status Pending.");
        reasonTextArea.clear();
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
