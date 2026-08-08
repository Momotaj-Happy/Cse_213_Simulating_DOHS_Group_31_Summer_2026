package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.ProblemReport;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Supervisor_ProblemReportController
{
    @FXML
    private TableView<ProblemReport> problemReportTableView;
    @FXML
    private TableColumn<ProblemReport, String> reportIdTableCol;
    @FXML
    private TableColumn<ProblemReport, String> typeTableCol;
    @FXML
    private TableColumn<ProblemReport, String> locationTableCol;
    @FXML
    private TableColumn<ProblemReport, String> reportingStaffTableCol;
    @FXML
    private TableColumn<ProblemReport, String> statusTableCol;
    @FXML
    private ComboBox<String> selectActionComboBox;
    @FXML
    private TextArea remarksTextArea;

    private final ObservableList<ProblemReport> reportList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        selectActionComboBox.getItems().addAll("Assigned", "Forwarded to Maintenance", "Escalated", "Resolved");

        reportIdTableCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        reportingStaffTableCol.setCellValueFactory(new PropertyValueFactory<>("reportingStaff"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        problemReportTableView.setItems(reportList);

        reportList.setAll(StaffSupervisor.getPendingProblemReports());
    }

    @FXML
    public void applyActionOnAction(ActionEvent actionEvent) {
        ProblemReport selected = problemReportTableView.getSelectionModel().getSelectedItem();
        if (selected == null || selectActionComboBox.getValue() == null) {
            Utility.showAlert("Error", "Select a report and an action first.");
            return;}

        if (selectActionComboBox.getValue().equals("Escalated") && remarksTextArea.getText().isEmpty()) {
            Utility.showAlert("Error", "Escalating a report needs remarks and an urgency note.");
            return;}

        boolean success = StaffSupervisor.applyActionToReport(selected, selectActionComboBox.getValue(), remarksTextArea.getText());
        if (success) {
            problemReportTableView.refresh();
            Utility.showAlert("Updated", "Report " + selected.getReportId() + " status updated to " + selected.getStatus() + ".");
            remarksTextArea.clear();
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
