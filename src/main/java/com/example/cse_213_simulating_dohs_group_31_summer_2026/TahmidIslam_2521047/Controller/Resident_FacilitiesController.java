package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser.Facility;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.User.Resident;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Resident_FacilitiesController
{
    @javafx.fxml.FXML
    private DatePicker SelectTheDateOfBookingDatePicker;
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
    public void initialize() {
        ArrayList<Facility> fac= new ArrayList<Facility>();
        selectFacilityTypeComboBox.getItems().addAll("Parking", "Park", "Community Center");
        facilityTypeTableCol.setCellValueFactory(new PropertyValueFactory<Facility, String>("facilityType"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<Facility, String>("Location"));
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
        ArrayList<Resident> rList = new ArrayList<Resident>();
        try {
            Utility.loadFrom2("ResidentData.bin", rList);

        } catch (Exception e) {
            Utility.showAlert("Error", "Load Failed");
            return;

        }
        rList.getFirst().bookFacility(f);
    }

        @javafx.fxml.FXML
    public void searchAvailableFacilitiesOnAction(ActionEvent actionEvent) {
        String s = selectFacilityTypeComboBox.getValue();
        LocalDate l = SelectTheDateOfBookingDatePicker.getValue();

        if(s==null || l==null){
            Utility.showAlert("Error", "Please fill all the fields");
            return;
        }
        try{
            Utility.loadFrom2("FacilityData.bin", fac);
        }
        catch (Exception e){
            Utility.showAlert("Error", "Load Failed");
            return;
        }


        for(Facility fTable: fac){
            if(selectFacilityTypeComboBox.getValue().equals(s) && SelectTheDateOfBookingDatePicker.getValue().equals(l)){
                availableFacilitiesTableView.getItems().add(fTable);
            }

        }
    }
}