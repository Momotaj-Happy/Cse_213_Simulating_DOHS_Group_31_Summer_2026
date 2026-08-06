package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.Task;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class Staff_TaskListController
{
    @FXML
    private TableView<Task> taskListTableView;
    @FXML
    private TableColumn<Task, String> taskIdTableCol;
    @FXML
    private TableColumn<Task, String> taskTypeTableCol;
    @FXML
    private TableColumn<Task, String> locationTableCol;
    @FXML
    private TableColumn<Task, String> timeSlotTableCol;
    @FXML
    private TableColumn<Task, String> statusTableCol;
    @FXML
    private TextArea taskDetailsTextArea;

    private final ObservableList<Task> myTasks = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        taskIdTableCol.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        taskTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("dutyType"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        timeSlotTableCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        taskListTableView.setItems(myTasks);

        myTasks.setAll(SessionManager.residentialOperationsStaff.getMyTasks());
    }

    @FXML
    public void viewTaskDetailsOnAction(ActionEvent actionEvent) {
        Task selected = taskListTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Utility.showAlert("Error", "Select a task first.");
            return;
        }
        taskDetailsTextArea.setText("Location: " + selected.getLocation() +
                "\nDuty type: " + selected.getDutyType() +
                "\nTime slot: " + selected.getTimeSlot() +
                "\nInstruction: " + (selected.getInstruction() == null ? "-" : selected.getInstruction()));
    }

    @FXML
    public void completeSelectedTaskOnAction(ActionEvent actionEvent) {
        Task selected = taskListTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Utility.showAlert("Error", "Select a task first.");
            return;
        }
        Staff_TaskCompletionController.taskToComplete = selected;
        Utility.openFxml(actionEvent, "Complete Task", "ResidentialOperationsStaff_2431050/Task-Completion-View.fxml");
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Residential Operations Staff", "ResidentialOperationsStaff_2431050/Staff-Dashboard-View.fxml");}
}
