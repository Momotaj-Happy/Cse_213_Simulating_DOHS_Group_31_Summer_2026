package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Resident_FacilitiesController
{
    @javafx.fxml.FXML
    private DatePicker SelectTheDateOfBookingDatePicker;
    @javafx.fxml.FXML
    private TableColumn availableTimeTableCol;
    @javafx.fxml.FXML
    private TableView availableFacilitiesTableView;
    @javafx.fxml.FXML
    private TableColumn locationTableCol;
    @javafx.fxml.FXML
    private TableColumn facilityTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn bookingPriceTableCol;
    @javafx.fxml.FXML
    private ComboBox selectFacilityTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void bookSelectedFacilityOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchAvailableFacilitiesOnAction(ActionEvent actionEvent) {
    }
}