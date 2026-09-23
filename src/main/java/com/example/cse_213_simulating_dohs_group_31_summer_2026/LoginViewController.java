package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model.SecurityInCharge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private TextField staffIdTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll(
                "Security In charge",
                "Gate Man"
        );
    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String userIdStr = staffIdTextField.getText();
        String password = passwordField.getText();
        String userType = userTypeComboBox.getValue();

        if (userType == null || userIdStr == null || userIdStr.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            statusLabel.setText("Please fill all fields!");
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(userIdStr.trim());
        } catch (NumberFormatException e) {
            statusLabel.setText("User ID must be an Integer!");
            return;
        }

        if (userType.equals("Security In charge")) {
            SecurityInCharge securityInCharge = new SecurityInCharge(userIdStr, "Security In charge", "Security In charge", password, true, userIdStr);
            SessionManager.securityInCharge = securityInCharge;
            openDashboard(actionEvent, "/com/example/cse_213_simulating_dohs_group_31_summer_2026/SecurityInCharge/SecurityInChargeMenuView.fxml", "Security In-Charge Dashboard");
        } else if (userType.equals("Gate Man")) {
            GateMan gateMan = new GateMan(userIdStr, "Gate Man", "Gate Man", password, true, userIdStr);
            SessionManager.gateMan = gateMan;
            openDashboard(actionEvent, "/com/example/cse_213_simulating_dohs_group_31_summer_2026/GateMan/GateManMenuView.fxml", "Gateman Dashboard");
        } else {
            statusLabel.setText("Selected role is not configured!");
        }
    }

    private void openDashboard(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error loading dashboard view!");
        }
    }
}
