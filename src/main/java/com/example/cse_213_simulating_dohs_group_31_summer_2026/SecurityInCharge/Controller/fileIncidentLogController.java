package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.IncidentLog;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.incidentLogs;

public class fileIncidentLogController {
    @FXML
    private DatePicker dpIncidentDate;
    @FXML
    private TextArea txtIncidentDescription;
    @FXML
    private TextField txtReporterName;
    @FXML
    private TextField txtPersonInvolved;
    @FXML
    private Label lblIncidentStatus;
    @FXML
    private TextField txtIncidentLocation;
    @FXML
    private TextField txtIncidentTime;

    @FXML
    private TableView<IncidentLog> tblIncidentLogs;
    @FXML
    private TableColumn<IncidentLog, String> colLogId;
    @FXML
    private TableColumn<IncidentLog, String> colReporter;
    @FXML
    private TableColumn<IncidentLog, LocalTime> colTime;
    @FXML
    private TableColumn<IncidentLog, LocalDate> colDate;
    @FXML
    private TableColumn<IncidentLog, String> colLocation;
    @FXML
    private TableColumn<IncidentLog, String> colPersonInvolved;

    @FXML
    public void initialize() {
        colLogId.setCellValueFactory(new PropertyValueFactory<>("logId"));
        colReporter.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colPersonInvolved.setCellValueFactory(new PropertyValueFactory<>("personInvolved"));

        tblIncidentLogs.setItems(FXCollections.observableArrayList(incidentLogs));
    }

    @FXML
    public void handleSaveIncident(ActionEvent actionEvent) {
        String name = txtReporterName.getText();
        String timeStr = txtIncidentTime.getText();
        LocalDate date = dpIncidentDate.getValue();
        String location = txtIncidentLocation.getText();
        String description = txtIncidentDescription.getText();
        String personInvolve = txtPersonInvolved.getText();

        if (name == null || name.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out reporter name!");
            alert.showAndWait();
            return;
        }
        if (timeStr == null || timeStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out incident time!");
            alert.showAndWait();
            return;
        }
        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select an incident date!");
            alert.showAndWait();
            return;
        }
        if (location == null || location.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out incident location!");
            alert.showAndWait();
            return;
        }
        if (description == null || description.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out incident description!");
            alert.showAndWait();
            return;
        }
        if (personInvolve == null || personInvolve.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out person involved!");
            alert.showAndWait();
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeStr);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid time format (HH:MM)!");
            alert.showAndWait();
            return;
        }

        boolean isSaved = SecurityInCharge.fileIncidentLog(name, time, date, location, description, personInvolve);
        if (isSaved) {
            tblIncidentLogs.setItems(FXCollections.observableArrayList(incidentLogs));
            lblIncidentStatus.setText("Saved incident data successfully!");
        } else {
            lblIncidentStatus.setText("Failed to save incident data!");
        }
    }
}