package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser.Task;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Staff_TaskCompletionController
{
    public static Task taskToComplete;

    @FXML
    private ComboBox<String> completionStatusComboBox;
    @FXML
    private TextArea notesTextArea;

    @FXML
    public void initialize() {
        completionStatusComboBox.getItems().addAll("Done", "Issue Found");
    }

    @FXML
    public void attachPhotoOnAction(ActionEvent actionEvent) {
        Utility.showAlert("Photo Attached", "Photo proof attached to this task (optional).");
    }

    @FXML
    public void submitCompletionOnAction(ActionEvent actionEvent) {
        if (taskToComplete == null || completionStatusComboBox.getValue() == null) {
            Utility.showAlert("Error", "Select a completion status first.");
            return;
        }
        SessionManager.residentialOperationsStaff.completeTask(taskToComplete, completionStatusComboBox.getValue(), notesTextArea.getText());
        Utility.showAlert("Success", "Task marked as " + taskToComplete.getStatus() + ".");
        taskToComplete = null;
        Utility.openFxml(actionEvent, "My Task List", "ResidentialOperationsStaff_2431050/My-Task-List-View.fxml");
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) {Utility.openFxml(actionEvent, "My Task List", "ResidentialOperationsStaff_2431050/My-Task-List-View.fxml");}
}
