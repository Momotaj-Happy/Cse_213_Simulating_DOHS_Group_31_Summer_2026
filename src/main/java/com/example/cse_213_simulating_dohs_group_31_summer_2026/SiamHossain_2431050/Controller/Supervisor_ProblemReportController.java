package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import javafx.scene.control.ComboBox;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Supervisor_ProblemReportController {
    @javafx.fxml.FXML
    private TableColumn reportIdTableCol;
    @javafx.fxml.FXML
    private TableColumn locationTableCol;
    @javafx.fxml.FXML
    private TableColumn reportingStaffTableCol;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> selectActionComboBox;
    @javafx.fxml.FXML
    private TableView problemReportTableView;
    @javafx.fxml.FXML
    private TableColumn statusTableCol;
    @javafx.fxml.FXML
    private TableColumn typeTableCol;

    @javafx.fxml.FXML
    public void applyActionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
    }
}
