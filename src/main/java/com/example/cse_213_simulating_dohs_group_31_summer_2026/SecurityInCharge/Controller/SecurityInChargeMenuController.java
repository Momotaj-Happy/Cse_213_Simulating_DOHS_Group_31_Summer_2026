package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Controller;

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

public class SecurityInChargeMenuController {

    @FXML
    private VBox sideNav;

    @FXML
    private StackPane contentArea;

    private boolean isNavCollapsed = false;

    @FXML
    public void initialize() {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/checkTenantInfoView.fxml");
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
    public void handleCheckTenantInfo(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/checkTenantInfoView.fxml");
    }

    @FXML
    public void handleFileIncidentLog(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/fileIncidentLogView.fxml");
    }

    @FXML
    public void handleLogUnauthorizedParking(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/logUnauthorizedParkingView.fxml");
    }

    @FXML
    public void handleNotePropertyWarning(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/notePropertyWarningView.fxml");
    }

    @FXML
    public void handleReportMaintenanceHazard(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/reportMaintenanceHazardView.fxml");
    }

    @FXML
    public void handleReviewActiveSilentAlarms(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/reviewActiveSilentAlarmsView.fxml");
    }

    @FXML
    public void handleSendEmergencyAssistance(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/sendEmergencyAssistanceView.fxml");
    }

    @FXML
    public void handleSubmitShiftSummary(ActionEvent event) {
        loadPage("/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/submitShiftSummaryView.fxml");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
