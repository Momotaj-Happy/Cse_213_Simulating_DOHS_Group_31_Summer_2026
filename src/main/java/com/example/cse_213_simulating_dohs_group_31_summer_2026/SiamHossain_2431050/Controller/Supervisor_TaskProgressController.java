package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class Supervisor_TaskProgressController {
    @javafx.fxml.FXML
    private TableView taskProgressTableView;
    @javafx.fxml.FXML
    private TableColumn staffNameTableCol;
    @javafx.fxml.FXML
    private TableColumn locationTableCol;
    @javafx.fxml.FXML
    private TableColumn completionTimeTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterByStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn dutyTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn statusTableCol;

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendReminderOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reassignTaskOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filterOnAction(ActionEvent actionEvent) {
    }
}
