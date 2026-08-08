package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.MaintenanceHazardReport;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

import static com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge.hazardReports;

public class reportMaintenanceHazardController {
    @FXML
    private DatePicker dpHazardDate;
    @FXML
    private TextField txtHazardLocation;
    @FXML
    private TextArea txtHazardDescription;
    @FXML
    private TextField txtHazardName;
    @FXML
    private Label lblHazardStatus;

    @FXML
    private TableView<MaintenanceHazardReport> tblHazardReports;
    @FXML
    private TableColumn<MaintenanceHazardReport, String> colHazardId;
    @FXML
    private TableColumn<MaintenanceHazardReport, String> colHazardName;
    @FXML
    private TableColumn<MaintenanceHazardReport, LocalDate> colDate;
    @FXML
    private TableColumn<MaintenanceHazardReport, String> colLocation;
    @FXML
    private TableColumn<MaintenanceHazardReport, String> colDescription;

    @FXML
    public void initialize() {
        colHazardId.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        colHazardName.setCellValueFactory(new PropertyValueFactory<>("hazardName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        tblHazardReports.setItems(FXCollections.observableArrayList(hazardReports));
    }

    @FXML
    public void handleSubmitHazard(ActionEvent actionEvent) {
        String hazardName = txtHazardName.getText();
        LocalDate date = dpHazardDate.getValue();
        String location = txtHazardLocation.getText();
        String description = txtHazardDescription.getText();

        if (hazardName == null || hazardName.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out hazard name!");
            alert.showAndWait();
            return;
        }
        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a date!");
            alert.showAndWait();
            return;
        }
        if (date.isAfter(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please make sure date input is not in future!");
            alert.showAndWait();
            return;
        }
        if (location == null || location.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out location!");
            alert.showAndWait();
            return;
        }
        if (description == null || description.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill out description!");
            alert.showAndWait();
            return;
        }

        boolean isSaved = SecurityInCharge.reportMaintenanceHazard(hazardName, date, location, description);

        if (isSaved) {
            tblHazardReports.setItems(FXCollections.observableArrayList(hazardReports));
            lblHazardStatus.setText("Hazard report stored successfully!");
        } else {
            lblHazardStatus.setText("Failed to store hazard report!");
        }
    }
}