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

import java.time.LocalDate;

public class Supervisor_DailyTaskController
{
    @FXML
    private DatePicker selectDateDatePicker;
    @FXML
    private TableView<Task> suggestedTaskTableView;
    @FXML
    private TableColumn<Task, String> staffNameTableCol;
    @FXML
    private TableColumn<Task, String> dutyTypeTableCol;
    @FXML
    private TableColumn<Task, String> locationTableCol;
    @FXML
    private TableColumn<Task, String> timeSlotTableCol;
    @FXML
    private TableColumn<Task, String> availabilityTableCol;
    @FXML
    private TextField editLocationTextField;
    @FXML
    private TextField editTimeSlotTextField;
    @FXML
    private TextArea instructionTextArea;

    private final ObservableList<Task> suggestedTasks = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        staffNameTableCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        dutyTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("dutyType"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        timeSlotTableCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        availabilityTableCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        suggestedTaskTableView.setItems(suggestedTasks);

        suggestedTaskTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldTask, newTask) -> {
            if (newTask != null) {
                editLocationTextField.setText(newTask.getLocation());
                editTimeSlotTextField.setText(newTask.getTimeSlot());
            }
        });
    }

    @FXML
    public void generateSuggestedTasksOnAction(ActionEvent actionEvent) {
        LocalDate date = selectDateDatePicker.getValue();
        if (date == null) {
            date = LocalDate.now();
        }
        suggestedTasks.setAll(StaffSupervisor.generateSuggestedTasks(date));
    }

    @FXML
    public void assignTasksOnAction(ActionEvent actionEvent) {
        Task selected = suggestedTaskTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (!editLocationTextField.getText().isEmpty()) {
                selected.setLocation(editLocationTextField.getText());
            }
            if (!editTimeSlotTextField.getText().isEmpty()) {
                selected.setTimeSlot(editTimeSlotTextField.getText());
            }
            selected.setInstruction(instructionTextArea.getText());
            suggestedTaskTableView.refresh();
        }

        boolean success = StaffSupervisor.assignTasks(new java.util.ArrayList<>(suggestedTasks));
        if (success) {Utility.showAlert("Success", "Daily tasks assigned successfully for " + suggestedTasks.size() + " staff members.");
            suggestedTasks.clear();
        } else {Utility.showAlert("Error", "Please generate a valid task list before assigning.");
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "Staff Supervisor", "StaffSupervisor_2431050/Supervisor-Dashboard-View.fxml");}
}
