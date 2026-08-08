// ********** PACKAGE & IMPORTS **********
package com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.User;

import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.Accountant.NonUser.*;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.SamiullahHridoy_2520900.President.NonUser.Plot;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.User;
import com.example.cse_213_simulating_dohs_group_31_summer_2026.Utility;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.UUID;

// ********** ACCOUNTANT USER CLASS **********
// Accountant handles all billing and financial operations for DOHS
public class Accountant extends User implements Serializable {

    // ********** FEE CONSTANTS **********
    private static final double BASE_SECURITY_FEE = 1500;
    private static final double MAINTENANCE_FEE = 1200;
    private static final double MOSQUE_FUND = 300;
    private static final double HEALTH_SANITATION_FEE = 400;
    private static final double SPORTS_CULTURE_FEE = 200;
    private static final double COMMERCIAL_SURCHARGE_RATE = 0.25;

    // ********** CONSTRUCTOR **********
    public Accountant(int userId, String name, String password) {
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

    // ********** GOAL 1: GENERATE MONTHLY BILLS **********
    public boolean alreadyBilled(int month, int year) {
        String period = YearMonth.of(year, month).toString();
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) {
            if (b.getBillingPeriod().equals(period)) return true;
        }
        return false;
    }

    public void generateMonthlyBills(ActionEvent event, int month, int year) {
        String period = YearMonth.of(year, month).toString();
        ArrayList<Plot> eligiblePlots = new ArrayList<>();
        for (Plot p : Utility.<Plot>loadObject("PlotData.bin")) {
            if ("Allotted".equalsIgnoreCase(p.getStatus()) || "Active Tenancy".equalsIgnoreCase(p.getStatus())) {
                eligiblePlots.add(p);
            }
        }

        ArrayList<Concession> concessions = Utility.loadObject("ConcessionData.bin");
        ArrayList<Bill> generated = new ArrayList<>();

        for (Plot plot : eligiblePlots) {
            double serviceCharge = BASE_SECURITY_FEE + MAINTENANCE_FEE + MOSQUE_FUND + HEALTH_SANITATION_FEE + SPORTS_CULTURE_FEE;
            if ("Commercial".equalsIgnoreCase(plot.getPlotType())) {
                serviceCharge += serviceCharge * COMMERCIAL_SURCHARGE_RATE;
            }
            for (Concession c : concessions) {
                if (c.getPlotNumber().equals(plot.getPlotNumber())) {
                    serviceCharge -= (serviceCharge * c.getAmountOrPercent() / 100.0);
                }
            }
            generated.add(new Bill(newId("BILL"), plot.getPlotNumber(), period,
                    Math.round(serviceCharge * 100.0) / 100.0, LocalDate.now(), LocalDate.now().plusDays(30), "Unpaid"));
        }

        for (Bill b : generated) Utility.saveObject("AccountantBillData.bin", b, true);

        double total = generated.stream().mapToDouble(Bill::getAmount).sum();
        Utility.showAlert("Success", String.format("%d bills generated for %s. Total amount billed: %.2f TK. Notifications dispatched.",
                generated.size(), period, total));
    }

    // ********** GOAL 2: RECORD PAYMENT **********
    public ArrayList<Bill> getUnpaidBillsForPlot(String plotNumber) {
        ArrayList<Bill> unpaid = new ArrayList<>();
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) {
            if (b.getPlotNumber().equals(plotNumber) && !"Paid".equals(b.getStatus())) unpaid.add(b);
        }
        return unpaid;
    }

    public void recordPayment(ActionEvent event, String billId, LocalDate paymentDate, double amountReceived, String method, String refNumber) {
        if (paymentDate == null || paymentDate.isAfter(LocalDate.now())) {
            Utility.showAlert("Error", "Payment date must be set and not in the future.");
            return;
        }
        if (!"Cash".equals(method) && (refNumber == null || refNumber.isBlank())) {
            Utility.showAlert("Error", "Transaction reference number is required for non-cash payments.");
            return;
        }

        ArrayList<Bill> bills = Utility.loadObject("AccountantBillData.bin");
        String newStatus = "Partially Paid";
        for (Bill b : bills) {
            if (b.getBillId().equals(billId)) {
                newStatus = amountReceived >= b.getAmount() ? "Paid" : "Partially Paid";
                b.setStatus(newStatus);
            }
        }
        rewriteAll("AccountantBillData.bin", bills);

        PaymentReceipt receipt = new PaymentReceipt(newId("RCPT"), billId, amountReceived, paymentDate, method, refNumber);
        Utility.saveObject("PaymentReceiptData.bin", receipt, true);

        Utility.showAlert("Success", "Payment recorded. Bill " + billId + " marked " + newStatus + ". Receipt " + receipt.getReceiptId() + " generated.");
    }

    // ********** GOAL 3: GENERATE ARREAR REPORT **********
    public String generateArrearReport(String roadNumber, Integer minOverdueMonths) {
        ArrayList<Bill> overdue = new ArrayList<>();
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) {
            if ("Unpaid".equals(b.getStatus()) && b.getDueDate().isBefore(LocalDate.now())) overdue.add(b);
        }
        double totalArrear = overdue.stream().mapToDouble(Bill::getAmount).sum();
        long distinctPlots = overdue.stream().map(Bill::getPlotNumber).distinct().count();

        return String.format("Report %s generated:\nPlots in arrear: %d | Total arrear amount: %.2f TK",
                newId("RPT"), distinctPlots, totalArrear);
    }

    // ********** GOAL 4: APPLY CONCESSION **********
    public void applyConcession(ActionEvent event, String plotNumber, String type, double amountOrPercent,
                                 LocalDate startDate, LocalDate endDate, String approvalRef, String remarks) {
        if (amountOrPercent < 1 || amountOrPercent > 100) {
            Utility.showAlert("Error", "Concession percentage must be between 1 and 100.");
            return;
        }
        if (approvalRef == null || approvalRef.isBlank()) {
            Utility.showAlert("Error", "Concession requires prior approval from Management. Please enter the approval reference number.");
            return;
        }

        Concession c = new Concession(newId("CONC"), plotNumber, type, amountOrPercent, startDate, endDate, approvalRef, remarks);
        Utility.saveObject("ConcessionData.bin", c, true);

        Utility.showAlert("Success", "Concession applied successfully for Plot " + plotNumber + ". It will be applied to future bill computations.");
    }

    // ********** GOAL 5: GENERATE TAX DEMAND NOTICES **********
    public boolean noticesAlreadyGenerated(String financialYear) {
        for (TaxDemandNotice n : Utility.<TaxDemandNotice>loadObject("TaxDemandNoticeData.bin")) {
            if (n.getFinancialYear().equals(financialYear)) return true;
        }
        return false;
    }

    public void generateTaxDemandNotices(ActionEvent event, String financialYear) {
        ArrayList<TaxDemandNotice> generated = new ArrayList<>();
        for (Plot plot : Utility.<Plot>loadObject("PlotData.bin")) {
            if (!"Allotted".equalsIgnoreCase(plot.getStatus())) continue;
            double rate = "Commercial".equalsIgnoreCase(plot.getPlotType()) ? 500 : 250;
            double amount = plot.getAreaKathas() * rate;
            generated.add(new TaxDemandNotice(newId("TDN"), plot.getPlotNumber(), amount, financialYear, LocalDate.now().plusDays(60)));
        }
        for (TaxDemandNotice n : generated) Utility.saveObject("TaxDemandNoticeData.bin", n, true);

        double total = generated.stream().mapToDouble(TaxDemandNotice::getAmount).sum();
        Utility.showAlert("Success", String.format("%d notices issued for FY %s. Total tax demanded: %.2f TK. Due in 60 days.",
                generated.size(), financialYear, total));
    }

    // ********** GOAL 6: VIEW BILLING HISTORY **********
    public ArrayList<Bill> getBillingHistory(String plotNumber) {
        ArrayList<Bill> matching = new ArrayList<>();
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) if (b.getPlotNumber().equals(plotNumber)) matching.add(b);
        matching.sort((a, b) -> b.getBillingPeriod().compareTo(a.getBillingPeriod()));
        return matching;
    }

    // ********** GOAL 7: PROCESS REFUND **********
    public void processRefund(ActionEvent event, String plotNumber, double refundAmount, String method, String remarks) {
        if (refundAmount <= 0) {
            Utility.showAlert("Error", "Refund amount must be greater than zero.");
            return;
        }
        RefundRecord refund = new RefundRecord(newId("RFND"), plotNumber, refundAmount, method, remarks, LocalDate.now());
        Utility.saveObject("RefundRecordData.bin", refund, true);

        Utility.showAlert("Success", "Refund " + refund.getRefundId() + " of " + refundAmount + " TK processed for Plot " + plotNumber + ".");
    }

    // ********** GOAL 8: MONTHLY FINANCIAL SUMMARY **********
    public String generateMonthlyFinancialSummary(int month, int year) {
        String period = YearMonth.of(year, month).toString();
        ArrayList<Bill> monthBills = new ArrayList<>();
        for (Bill b : Utility.<Bill>loadObject("AccountantBillData.bin")) if (b.getBillingPeriod().equals(period)) monthBills.add(b);

        double totalBilled = monthBills.stream().mapToDouble(Bill::getAmount).sum();
        long paidCount = monthBills.stream().filter(b -> "Paid".equals(b.getStatus())).count();
        double collectionRate = monthBills.isEmpty() ? 0 : (paidCount * 100.0 / monthBills.size());

        return String.format("Report %s generated:\nPeriod: %s | Bills generated: %d | Total billed: %.2f TK | Collection rate: %.1f%%",
                newId("RPT"), period, monthBills.size(), totalBilled, collectionRate);
    }
}
