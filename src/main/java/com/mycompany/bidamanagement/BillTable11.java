/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable11 {
    private static BillTable11 instanceTable11;
    private int soLanBamAddTable11;
    private String billReviewTable11;
    private boolean isBillIdDetailTable11;
    private int invoiceIdTable11;
    private double saveBillPriceTable11;

    private BillTable11() {
        soLanBamAddTable11 = 0;
        invoiceIdTable11 = 0;
        isBillIdDetailTable11 = false;
        billReviewTable11 = "";
        saveBillPriceTable11 = 0.0;
    }

    public static synchronized BillTable11 getInstanceTable11() {
        if (instanceTable11 == null) {
            instanceTable11 = new BillTable11();
        }
        return instanceTable11;
    }

    public int getInvoiceIdTable11() {
        return invoiceIdTable11;
    }

    public void setInvoiceIdTable11(int InvoiceIdTable11) {
        this.invoiceIdTable11 = InvoiceIdTable11;
    }

    public boolean isBillIdDetailTable11() {
        return isBillIdDetailTable11;
    }

    public void setIsBillIdDetailTable11(boolean IsBillIdDetailTable11) {
        this.isBillIdDetailTable11 = IsBillIdDetailTable11;
    }

    public int getSoLanBamAddTable11() {
        return soLanBamAddTable11;
    }

    public void setSoLanBamAddTable11(int SoLanBamAddTable11) {
        this.soLanBamAddTable11 = SoLanBamAddTable11;
    }

    public String getBillReviewTable11() {
        return billReviewTable11;
    }

    public void setBillReviewTable11(String BillReviewTable11) {
        this.billReviewTable11 = BillReviewTable11;
    }

    public double getSaveBillPriceTable11() {
        return saveBillPriceTable11;
    }

    public void setSaveBillPriceTable11(double SaveBillPriceTable11) {
        this.saveBillPriceTable11 = SaveBillPriceTable11;
    }
}

