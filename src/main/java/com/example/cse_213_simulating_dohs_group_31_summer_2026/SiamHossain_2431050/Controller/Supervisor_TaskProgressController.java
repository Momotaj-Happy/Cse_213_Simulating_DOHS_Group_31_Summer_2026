package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.Task;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.User.StaffSupervisor;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Supervisor_TaskProgressController
{
    @FXML
    private ComboBox<String> filterByStatusComboBox;
    @FXML
    private TableView<Task> taskProgressTableView;
    @FXML
    private TableColumn<Task, String> staffNameTableCol;
    @FXML
    private TableColumn<Task, String> dutyTypeTableCol;
    @FXML
    private TableColumn<Task, String> locationTableCol;
    @FXML
    private TableColumn<Task, String> statusTableCol;
    @FXML
    private TableColumn<Task, String> completionTimeTableCol;

    private final ObservableList<Task> progressList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        filterByStatusComboBox.getItems().addAll("All", "Pending", "Done", "Late", "Issue Reported");
        filterByStatusComboBox.setValue("All");

        staffNameTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        dutyTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("dutyType"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        completionTimeTableCol.setCellValueFactory(new PropertyValueFactory<>("completionTime"));
        taskProgressTableView.setItems(progressList);

        filterOnAction(null);
    }

    @FXML
    public void filterOnAction(ActionEvent actionEvent) {
        progressList.setAll(StaffSupervisor.getTaskProgress(filterByStatusComboBox.getValue()));
    }

    @FXML
    public void sendReminderOnAction(ActionEvent actionEvent) {
        Task selected = taskProgressTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Utility.showAlert("Error", "Select a task first.");
            return;
        }
        StaffSupervisor.sendReminder(selected);
        Utility.showAlert("Reminder Sent", "A reminder was sent to " + selected.getStaffName() + ".");
    }

    @FXML
    public void reassignTaskOnAction(ActionEvent actionEvent) {
        Task selected = taskProgressTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Utility.showAlert("Error", "Select a task first.");
            return;
        }
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Reassign task to which staff member?");
        dialog.showAndWait().ifPresent(newStaff -> {
            StaffSupervisor.reassignTask(selected, newStaff);
            taskProgressTableView.refresh();
            Utility.showAlert("Reassigned", "Task reassigned to " + newStaff + " and both staff notified.");
        });
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
