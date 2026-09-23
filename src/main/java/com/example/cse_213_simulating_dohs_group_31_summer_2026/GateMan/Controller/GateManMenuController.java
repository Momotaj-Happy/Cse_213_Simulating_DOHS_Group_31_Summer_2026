package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GateManMenuController {

    @FXML
    private VBox sideNav;

    @FXML
    private StackPane contentArea;

    private boolean isNavCollapsed = false;

    @FXML
    public void initialize() {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/LogVisitorEntryView.fxml");
    }

    private void loadPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent page = loader.load();
            contentArea.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleToggleNav(ActionEvent event) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(250), sideNav);
        if (isNavCollapsed) {
            sideNav.setVisible(true);
            sideNav.setManaged(true);
            transition.setFromX(-250);
            transition.setToX(0);
            transition.play();
            isNavCollapsed = false;
        } else {
            transition.setFromX(0);
            transition.setToX(-250);
            transition.setOnFinished(e -> {
                sideNav.setVisible(false);
                sideNav.setManaged(false);
            });
            transition.play();
            isNavCollapsed = true;
        }
    }

    @FXML
    public void handleLogVisitorEntry(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/LogVisitorEntryView.fxml");
    }

    @FXML
    public void handleDenyBlacklistedVehicles(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/denyBlacklistedVehiclesView.fxml");
    }

    @FXML
    public void handleLogVehicleExit(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/logVehicleExitView.fxml");
    }

    @FXML
    public void handleRegisterWalkInPedestrians(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/registerWalkInPedestriansView.fxml");
    }

    @FXML
    public void handleSearchResidentVehicle(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/searchResidentVehicleView.fxml");
    }

    @FXML
    public void handleToggleEmergencyBypass(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/toggleEmergencyBypassView.fxml");
    }

    @FXML
    public void handleVerifyPreRegisteredGuests(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/verifyPreRegisteredGuestsView.fxml");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
