package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GateManMenuController {

    private void openInNewWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogVisitorEntry(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/LogVisitorEntryView.fxml", "Log Visitor Entry");
    }

    @FXML
    public void handleDenyBlacklistedVehicles(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/denyBlacklistedVehiclesView.fxml", "Deny Blacklisted Vehicles");
    }

    @FXML
    public void handleLogVehicleExit(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/logVehicleExitView.fxml", "Log Vehicle Exit");
    }

    @FXML
    public void handleRegisterWalkInPedestrians(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/registerWalkInPedestriansView.fxml", "Register Walk-In Pedestrians");
    }

    @FXML
    public void handleSearchResidentVehicle(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/searchResidentVehicleView.fxml", "Search Resident Vehicle");
    }

    @FXML
    public void handleToggleEmergencyBypass(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/toggleEmergencyBypassView.fxml", "Toggle Emergency Bypass");
    }

    @FXML
    public void handleVerifyPreRegisteredGuests(ActionEvent event) {
        openInNewWindow("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/verifyPreRegisteredGuestsView.fxml", "Verify Pre-Registered Guests");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
