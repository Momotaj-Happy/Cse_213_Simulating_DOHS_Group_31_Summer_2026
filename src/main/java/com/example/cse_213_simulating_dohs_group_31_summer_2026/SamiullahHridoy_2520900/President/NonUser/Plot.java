// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser;

import java.io.Serializable;

// ********** PLOT CLASS **********
// Represents a plot in the DOHS registry
public class Plot implements Serializable {
    private String plotNumber;
    private String roadNumber;
    private double areaKathas;
    private String plotType;      // Residential / Commercial
    private String status;        // Vacant / Allotted / Disputed
    private String ownerName;

    // ********** CONSTRUCTOR **********
    public Plot(String plotNumber, String roadNumber, double areaKathas, String plotType, String status, String ownerName) {
        this.plotNumber = plotNumber;
        this.roadNumber = roadNumber;
        this.areaKathas = areaKathas;
        this.plotType = plotType;
        this.status = status;
        this.ownerName = ownerName;
    }

    // ********** GETTERS AND SETTERS **********
    public String getPlotNumber() { return plotNumber; }
    public void setPlotNumber(String plotNumber) { this.plotNumber = plotNumber; }
    public String getRoadNumber() { return roadNumber; }
    public void setRoadNumber(String roadNumber) { this.roadNumber = roadNumber; }
    public double getAreaKathas() { return areaKathas; }
    public void setAreaKathas(double areaKathas) { this.areaKathas = areaKathas; }
    public String getPlotType() { return plotType; }
    public void setPlotType(String plotType) { this.plotType = plotType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    // ********** EQUALS METHOD **********
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Plot)) return false;
        return plotNumber.equals(((Plot) o).plotNumber);
    }
}
