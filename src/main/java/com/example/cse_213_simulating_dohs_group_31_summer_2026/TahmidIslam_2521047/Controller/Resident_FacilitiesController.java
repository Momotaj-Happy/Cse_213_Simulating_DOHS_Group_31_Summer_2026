package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SessionManager;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Resident_FacilitiesController
{
    @javafx.fxml.FXML
    private TableView<Facility> availableFacilitiesTableView;
    @javafx.fxml.FXML
    private TableColumn<Facility, String> locationTableCol;
    @javafx.fxml.FXML
    private TableColumn<Facility, String> facilityTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<Facility, Integer> bookingPriceTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> selectFacilityTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Facility, String> facilityNameTableCol;
    ArrayList<Facility> fac;
    @javafx.fxml.FXML
    private TextField maxBookingPriceTextField;

    Resident res = SessionManager.resident;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Facility> fac= new ArrayList<Facility>();
        selectFacilityTypeComboBox.getItems().addAll("Parking", "Park", "Community Center", "Gym");
        facilityTypeTableCol.setCellValueFactory(new PropertyValueFactory<Facility, String>("facilityType"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<Facility, String>("location"));
        facilityNameTableCol.setCellValueFactory(new PropertyValueFactory<Facility, String>("facilityName"));
        bookingPriceTableCol.setCellValueFactory(new PropertyValueFactory<Facility, Integer>("bookingPrice"));

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        Utility.openFxml(actionEvent, "Resident Dashboard", "Resident_2521047/Resident-Dashboard-View.fxml");
    }

    @javafx.fxml.FXML
    public void bookSelectedFacilityOnAction(ActionEvent actionEvent) {
        Facility f = availableFacilitiesTableView.getSelectionModel().getSelectedItem();
        if (f == null) {
            Utility.showAlert("Error", "Please select a facility to book");
            return;
        }

        res.bookFacility(f);

    }

        @javafx.fxml.FXML
    public void searchAvailableFacilitiesOnAction(ActionEvent actionEvent) {
        String s = selectFacilityTypeComboBox.getValue();
        int b;





        fac = Utility.loadObject("FacilityData.bin");
        availableFacilitiesTableView.getItems().clear();


        for(Facility fTable: fac) {
            if (fTable.isAvailability()) {


                if (s == null && maxBookingPriceTextField.getText().isEmpty()) {
                    availableFacilitiesTableView.getItems().add(fTable);
                    continue;
                }

                if (maxBookingPriceTextField.getText().isEmpty()) {
                    availableFacilitiesTableView.getItems().add(fTable);
                    continue;
                }

                try {
                    b = Integer.parseInt(maxBookingPriceTextField.getText());
                } catch (Exception e) {
                    Utility.showAlert("Error", "Max Booking price must be an integer");
                    return;
                }
                if (s == null) {
                    availableFacilitiesTableView.getItems().add(fTable);
                }
                if (s.equals(fTable.getFacilityType()) &&
                        b >= fTable.getBookingPrice() && fTable.isAvailability()) {
                    availableFacilitiesTableView.getItems().add(fTable);
                }

            }
        }
    }
}