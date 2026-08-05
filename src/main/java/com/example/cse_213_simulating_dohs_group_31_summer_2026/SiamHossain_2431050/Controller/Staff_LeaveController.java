package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.Controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.w3c.dom.Text;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Staff_LeaveController {
    @javafx.fxml.FXML
    private ComboBox<String> selectLeaveTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn startDateTableCol;
    @javafx.fxml.FXML
    private Text totalLeaveDaysText;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;
    @javafx.fxml.FXML
    private TableColumn endDateTableCol;
    @javafx.fxml.FXML
    private TableColumn statusTableCol;
    @javafx.fxml.FXML
    private TableView leaveHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn leaveIdTableCol;

    @javafx.fxml.FXML
    public void submitApplicationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void attachDocumentOnAction(ActionEvent actionEvent) {
    }
}
