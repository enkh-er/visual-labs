package application.model;

import java.time.LocalDate;

public class Payment {
    private int receiptNo;
    private String employeeNo;
    private LocalDate paymentDate;
    private String accountNo;
    private LocalDate firstDayOccupied;
    private LocalDate lastDatOccupied;
    private int totalNights;
    private double phoneUse;
    private double amountCharged;
    private double subTotal;
    private double taxRate;
    private double taxAmount;
    private double totalAmoundPaid;

    public Payment() {
    }

    public Payment(int receiptNo, String employeeNo, LocalDate paymentDate, String accountNo, LocalDate firstDayOccupied, LocalDate lastDatOccupied, int totalNights,double phoneUse, double amountCharged, double subTotal, double taxRate, double taxAmount, double totalAmoundPaid) {
        this.receiptNo = receiptNo;
        this.employeeNo = employeeNo;
        this.paymentDate = paymentDate;
        this.accountNo = accountNo;
        this.firstDayOccupied = firstDayOccupied;
        this.lastDatOccupied = lastDatOccupied;
        this.totalNights = totalNights;
        this.amountCharged = amountCharged;
        this.subTotal = subTotal;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.totalAmoundPaid = totalAmoundPaid;
        this.phoneUse=phoneUse;
    }

    public double getPhoneUse() {
        return phoneUse;
    }

    public void setPhoneUse(double phoneUse) {
        this.phoneUse = phoneUse;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public LocalDate getFirstDayOccupied() {
        return firstDayOccupied;
    }

    public void setFirstDayOccupied(LocalDate firstDayOccupied) {
        this.firstDayOccupied = firstDayOccupied;
    }

    public LocalDate getLastDatOccupied() {
        return lastDatOccupied;
    }

    public void setLastDatOccupied(LocalDate lastDatOccupied) {
        this.lastDatOccupied = lastDatOccupied;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmoundPaid() {
        return totalAmoundPaid;
    }

    public void setTotalAmoundPaid(double totalAmoundPaid) {
        this.totalAmoundPaid = totalAmoundPaid;
    }
}
