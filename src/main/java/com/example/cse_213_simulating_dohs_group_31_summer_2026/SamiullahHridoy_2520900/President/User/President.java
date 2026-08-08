// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser.Bill;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.*;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

// ********** PRESIDENT USER CLASS **********
// President handles all plot management and administrative operations for DOHS
public class President extends User implements Serializable {

    // ********** CONSTRUCTOR **********
    public President(int userId, String name, String password) {
        super(userId, name, password);
    }

    // ********** HELPER METHODS **********
    private static String newId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private static void rewriteAll(String fileName, ArrayList<? extends Serializable> list) {
        File file = new File(fileName);
        if (file.exists()) file.delete();
        for (Serializable o : list) Utility.saveObject(fileName, o, true);
    }

    private static Plot findPlot(ArrayList<Plot> plots, String plotNumber) {
        for (Plot p : plots) if (p.getPlotNumber().equals(plotNumber)) return p;
        return null;
    }

    public static boolean hasUnpaidBills(String plotNumber) {
        ArrayList<Bill> bills = Utility.loadObject("AccountantBillData.bin");
        for (Bill b : bills) if (b.getPlotNumber().equals(plotNumber) && !"Paid".equals(b.getStatus())) return true;
        return false;
    }

    public static double getTotalUnpaidAmount(String plotNumber) {
        double total = 0;
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) {
            if (b.getPlotNumber().equals(plotNumber) && !"Paid".equals(b.getStatus())) total += b.getAmount();
        }
        return total;
    }

    // ********** GOAL 1: REGISTER PLOT ALLOTMENT **********
    public void registerPlotAllotment(ActionEvent event, String applicantServiceId, String plotNumber,
                                       LocalDate allotmentDate, String category) {
        if (applicantServiceId == null || !applicantServiceId.matches("\\d{7}")) {
            Utility.showAlert("Error", "Applicant Service ID must be exactly 7 digits.");
            return;
        }
        if (plotNumber == null || plotNumber.isBlank()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }
        if (allotmentDate == null || allotmentDate.isAfter(LocalDate.now())) {
            Utility.showAlert("Error", "Allotment date must be set and not in the future.");
            return;
        }
        if (category == null) {
            Utility.showAlert("Error", "Please select an allotment category.");
            return;
        }

        ArrayList<Plot> plots = Utility.loadObject("PlotData.bin");
        Plot plot = findPlot(plots, plotNumber);
        if (plot == null) {
            Utility.showAlert("Error", "Plot not found in registry.");
            return;
        }
        if (!"Vacant".equalsIgnoreCase(plot.getStatus())) {
            Utility.showAlert("Error", "Plot " + plotNumber + " is not vacant (current status: " + plot.getStatus() + "). Cannot allot.");
            return;
        }

        plot.setStatus("Allotted");
        rewriteAll("PlotData.bin", plots);

        PlotAllotment allotment = new PlotAllotment(newId("ALT"), plotNumber, applicantServiceId, allotmentDate, category);
        Utility.saveObject("PlotAllotmentData.bin", allotment, true);

        Utility.showAlert("Success", "Plot " + plotNumber + " successfully allotted to applicant " + applicantServiceId + ".");
    }

    // ********** GOAL 2: PROCESS PLOT TRANSFER **********
    public void processPlotTransfer(ActionEvent event, String plotNumber, String newOwnerServiceId,
                                     LocalDate transferDate, String reason) {
        if (plotNumber == null || plotNumber.isBlank()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }
        ArrayList<Plot> plots = Utility.loadObject("PlotData.bin");
        Plot plot = findPlot(plots, plotNumber);
        if (plot == null) {
            Utility.showAlert("Error", "Plot number not found in registry.");
            return;
        }
        // Block transfer if the plot has outstanding bills/dues
        if (hasUnpaidBills(plotNumber)) {
            Utility.showAlert("Error", String.format(
                    "Plot has outstanding dues of %.2f TK. Transfer is blocked until dues are cleared.",
                    getTotalUnpaidAmount(plotNumber)));
            return;
        }
        if (newOwnerServiceId == null || !newOwnerServiceId.matches("\\d{7}")) {
            Utility.showAlert("Error", "New owner's Service ID must be exactly 7 digits.");
            return;
        }
        if (transferDate == null || transferDate.isAfter(LocalDate.now())) {
            Utility.showAlert("Error", "Transfer date must be set and not in the future.");
            return;
        }
        if (reason == null) {
            Utility.showAlert("Error", "Please select a transfer reason.");
            return;
        }

        plot.setOwnerName(newOwnerServiceId);
        rewriteAll("PlotData.bin", plots);

        TransferRecord record = new TransferRecord(newId("TRF"), plotNumber, newOwnerServiceId, transferDate, reason);
        Utility.saveObject("TransferRecordData.bin", record, true);

        Utility.showAlert("Success", "Plot transfer completed for " + plotNumber + ".");
    }

    // ********** GOAL 3: REVIEW TENANCY APPLICATION **********
    public ArrayList<TenancyApplication> getPendingTenancyApplications() {
        ArrayList<TenancyApplication> pending = new ArrayList<>();
        for (TenancyApplication t : Utility.<TenancyApplication>loadObject("TenancyApplicationData.bin")) {
            if ("Pending".equals(t.getStatus())) pending.add(t);
        }
        return pending;
    }

    public void decideTenancyApplication(ActionEvent event, String applicationId, boolean approve, String rejectionReason) {
        if (!approve && (rejectionReason == null || rejectionReason.isBlank())) {
            Utility.showAlert("Error", "Rejection reason is required.");
            return;
        }
        ArrayList<TenancyApplication> apps = Utility.loadObject("TenancyApplicationData.bin");
        for (TenancyApplication t : apps) {
            if (t.getApplicationId().equals(applicationId)) {
                if (approve) {
                    t.setStatus("Active");
                } else {
                    t.setStatus("Rejected");
                    t.setRejectionReason(rejectionReason);
                }
            }
        }
        rewriteAll("TenancyApplicationData.bin", apps);
        Utility.showAlert("Success", "Application " + applicationId + (approve ? " approved successfully." : " rejected."));
    }

    // ********** GOAL 4: LOG ENCROACHMENT VIOLATION **********
    public void logEncroachmentViolation(ActionEvent event, String plotNumber, String violationType,
                                          String description, LocalDate observedDate, String reportingOfficer) {
        if (plotNumber == null || plotNumber.isBlank()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }
        ArrayList<Plot> plots = Utility.loadObject("PlotData.bin");
        if (findPlot(plots, plotNumber) == null) {
            Utility.showAlert("Error", "Plot number does not exist in registry.");
            return;
        }
        if (violationType == null) {
            Utility.showAlert("Error", "Please select a violation type.");
            return;
        }
        if (description == null || description.isBlank()) {
            Utility.showAlert("Error", "Description is required.");
            return;
        }
        if (observedDate == null || observedDate.isAfter(LocalDate.now())) {
            Utility.showAlert("Error", "Observed date must be set and not in the future.");
            return;
        }

        ViolationCase violation = new ViolationCase(newId("VIO"), plotNumber, violationType, description,
                observedDate, reportingOfficer, "Open");
        violation.setFollowUpDate(LocalDate.now().plusDays(15));
        Utility.saveObject("ViolationCaseData.bin", violation, true);

        Utility.showAlert("Success", "Case " + violation.getCaseId() + " logged. Notice dispatched to plot owner. Follow-up review in 15 days.");
    }

    // ********** GOAL 5: UPDATE PLOT RECORD **********
    public Plot searchPlot(String plotNumber) {
        return findPlot(Utility.loadObject("PlotData.bin"), plotNumber);
    }

    public void updatePlotRecord(ActionEvent event, String plotNumber, Double newArea, String newRoadNumber,
                                  String newPlotType, String remarks) {
        if (remarks == null || remarks.isBlank()) {
            Utility.showAlert("Error", "Remarks / reason for update is required for the audit trail.");
            return;
        }
        if (remarks.length() > 500) {
            Utility.showAlert("Error", "Remarks must not exceed 500 characters.");
            return;
        }

        ArrayList<Plot> plots = Utility.loadObject("PlotData.bin");
        Plot plot = findPlot(plots, plotNumber);
        if (plot == null) {
            Utility.showAlert("Error", "Update failed — plot not found.");
            return;
        }
        if (newArea != null) plot.setAreaKathas(newArea);
        if (newRoadNumber != null && !newRoadNumber.isBlank()) plot.setRoadNumber(newRoadNumber);
        if (newPlotType != null && !newPlotType.isBlank()) plot.setPlotType(newPlotType);
        rewriteAll("PlotData.bin", plots);

        Utility.showAlert("Success", "Plot record updated successfully.");
    }

    // ********** GOAL 6: GENERATE OCCUPANCY CERTIFICATE **********
    public void generateOccupancyCertificate(ActionEvent event, String plotNumber, LocalDate inspectionDate,
                                              String inspectorName, String remarks) {
        if (plotNumber == null || plotNumber.isBlank()) {
            Utility.showAlert("Error", "Please enter a plot number.");
            return;
        }
        Plot plot = findPlot(Utility.loadObject("PlotData.bin"), plotNumber);
        if (plot == null || !"Allotted".equalsIgnoreCase(plot.getStatus())) {
            Utility.showAlert("Error", "Plot must exist and be in 'Allotted' status.");
            return;
        }
        // Block if open violations exist
        for (ViolationCase v : Utility.<ViolationCase>loadObject("ViolationCaseData.bin")) {
            if (v.getPlotNumber().equals(plotNumber) && "Open".equals(v.getStatus())) {
                Utility.showAlert("Error", "Open encroachment/violation case exists for this plot. Resolve it before issuing a certificate.");
                return;
            }
        }
        // Verify all dues are cleared before issuing the certificate
        if (hasUnpaidBills(plotNumber)) {
            Utility.showAlert("Error", String.format(
                    "Outstanding dues of %.2f TK on this plot. Clear dues before issuing an Occupancy Certificate.",
                    getTotalUnpaidAmount(plotNumber)));
            return;
        }
        if (inspectionDate == null || inspectionDate.isAfter(LocalDate.now())) {
            Utility.showAlert("Error", "Inspection date must be set and not in the future.");
            return;
        }
        if (inspectorName == null || inspectorName.isBlank()) {
            Utility.showAlert("Error", "Inspecting officer's name is required.");
            return;
        }

        OccupancyCertificate cert = new OccupancyCertificate(newId("OCC"), plotNumber, "President",
                inspectionDate, inspectorName, remarks);
        Utility.saveObject("OccupancyCertificateData.bin", cert, true);

        Utility.showAlert("Success", "Certificate " + cert.getCertificateNumber() + " generated for Plot " + plotNumber + ".");
    }

    // ********** GOAL 7: GENERATE PLOT STATUS REPORT **********
    public String generatePlotStatusReport(String roadNumber, String plotType, String status) {
        ArrayList<Plot> filtered = new ArrayList<>();
        for (Plot p : Utility.<Plot>loadObject("PlotData.bin")) {
            if (roadNumber != null && !roadNumber.isBlank() && !p.getRoadNumber().equalsIgnoreCase(roadNumber)) continue;
            if (plotType != null && !plotType.isBlank() && !plotType.equalsIgnoreCase("All") && !p.getPlotType().equalsIgnoreCase(plotType)) continue;
            if (status != null && !status.isBlank() && !status.equalsIgnoreCase("All") && !p.getStatus().equalsIgnoreCase(status)) continue;
            filtered.add(p);
        }

        long allotted = filtered.stream().filter(p -> "Allotted".equalsIgnoreCase(p.getStatus())).count();
        long vacant = filtered.stream().filter(p -> "Vacant".equalsIgnoreCase(p.getStatus())).count();
        long disputed = filtered.stream().filter(p -> "Disputed".equalsIgnoreCase(p.getStatus())).count();
        double utilization = filtered.isEmpty() ? 0 : (allotted * 100.0 / filtered.size());

        return String.format("Report %s generated:\nTotal: %d | Allotted: %d | Vacant: %d | Disputed: %d | Utilization: %.1f%%",
                newId("RPT"), filtered.size(), allotted, vacant, disputed, utilization);
    }

    // ********** GOAL 8: RECORD TENANT DEPARTURE **********
    public TenancyApplication findActiveTenancy(String plotNumber) {
        for (TenancyApplication t : Utility.<TenancyApplication>loadObject("TenancyApplicationData.bin")) {
            if (t.getPlotNumber().equals(plotNumber) && "Active".equals(t.getStatus())) return t;
        }
        return null;
    }

    public void recordTenantDeparture(ActionEvent event, String plotNumber, LocalDate departureDate, String remarks, boolean proceedDespiteDues) {
        TenancyApplication active = findActiveTenancy(plotNumber);
        if (active == null) {
            Utility.showAlert("Error", "No active tenancy agreement found for this plot.");
            return;
        }
        if (departureDate == null || departureDate.isAfter(LocalDate.now()) || departureDate.isBefore(active.getProposedStartDate())) {
            Utility.showAlert("Error", "Departure date must be set, not in the future, and on/after the tenancy start date.");
            return;
        }
        if (hasUnpaidBills(plotNumber) && !proceedDespiteDues) {
            Utility.showAlert("Warning", String.format(
                    "Outstanding dues of %.2f TK remain on this plot. Confirm again to proceed anyway.",
                    getTotalUnpaidAmount(plotNumber)));
            return;
        }

        ArrayList<TenancyApplication> apps = Utility.loadObject("TenancyApplicationData.bin");
        for (TenancyApplication t : apps) {
            if (t.getPlotNumber().equals(plotNumber) && "Active".equals(t.getStatus())) {
                t.setStatus("Terminated");
                t.setDepartureDate(departureDate);
                t.setDepartureRemarks(remarks);
            }
        }
        rewriteAll("TenancyApplicationData.bin", apps);

        ArrayList<Plot> plots = Utility.loadObject("PlotData.bin");
        Plot plot = findPlot(plots, plotNumber);
        if (plot != null) plot.setStatus("Vacant");
        rewriteAll("PlotData.bin", plots);

        Utility.showAlert("Success", "Tenant departure recorded successfully. Plot " + plotNumber + " is now Vacant.");
    }
}
