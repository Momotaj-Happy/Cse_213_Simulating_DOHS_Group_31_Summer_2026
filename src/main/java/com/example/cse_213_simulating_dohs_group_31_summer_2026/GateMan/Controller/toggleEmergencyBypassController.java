package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Controller;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model.GateMan;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class toggleEmergencyBypassController
{
    @javafx.fxml.FXML
    private Label lblEmergencyModeStatus;
    @javafx.fxml.FXML
    private CheckBox chkEmergencyOverride;

    @javafx.fxml.FXML
    public void initialize() {
        boolean isActive = GateMan.gateControl.isBypassModeActive();
        String gateStatus= GateMan.gateControl.getCurrentStatus();
        chkEmergencyOverride.setSelected(isActive);
        lblEmergencyModeStatus.setText(gateStatus);
    }

    @javafx.fxml.FXML
    public void handleProcessGateStatus(ActionEvent actionEvent) {
        boolean isActive =  chkEmergencyOverride.isSelected();
        String gateStatus= GateMan.toggleEmergencyGateBypass(isActive);
        lblEmergencyModeStatus.setText("gate status:"+gateStatus);
    }
}