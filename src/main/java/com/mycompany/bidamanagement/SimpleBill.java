/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class SimpleBill {
    private static SimpleBill instanceSimpleBill;
    private int soLanBamAddSimpleBill;
    private String billReviewSimpleBill;
    private boolean isBillIdDetailSimpleBill;
    private int invoiceIdSimpleBill;
    private double saveBillPriceSimpleBill;

    private SimpleBill() {
        soLanBamAddSimpleBill = 0;
        invoiceIdSimpleBill = 0;
        isBillIdDetailSimpleBill = false;
        billReviewSimpleBill = "";
        saveBillPriceSimpleBill = 0.0;
    }

    public static synchronized SimpleBill getInstanceSimpleBill() {
        if (instanceSimpleBill == null) {
            instanceSimpleBill = new SimpleBill();
        }
        return instanceSimpleBill;
    }

    public int getInvoiceIdSimpleBill() {
        return invoiceIdSimpleBill;
    }

    public void setInvoiceIdSimpleBill(int InvoiceIdSimpleBill) {
        this.invoiceIdSimpleBill = InvoiceIdSimpleBill;
    }

    public boolean isBillIdDetailSimpleBill() {
        return isBillIdDetailSimpleBill;
    }

    public void setIsBillIdDetailSimpleBill(boolean IsBillIdDetailSimpleBill) {
        this.isBillIdDetailSimpleBill = IsBillIdDetailSimpleBill;
    }

    public int getSoLanBamAddSimpleBill() {
        return soLanBamAddSimpleBill;
    }

    public void setSoLanBamAddSimpleBill(int SoLanBamAddSimpleBill) {
        this.soLanBamAddSimpleBill = SoLanBamAddSimpleBill;
    }

    public String getBillReviewSimpleBill() {
        return billReviewSimpleBill;
    }

    public void setBillReviewSimpleBill(String BillReviewSimpleBill) {
        this.billReviewSimpleBill = BillReviewSimpleBill;
    }

    public double getSaveBillPriceSimpleBill() {
        return saveBillPriceSimpleBill;
    }

    public void setSaveBillPriceSimpleBill(double SaveBillPriceSimpleBill) {
        this.saveBillPriceSimpleBill = SaveBillPriceSimpleBill;
    }
}

