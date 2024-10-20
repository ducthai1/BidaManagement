/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable13 {
    private static BillTable13 instanceTable13;
    private int soLanBamAddTable13;
    private String billReviewTable13;
    private boolean isBillIdDetailTable13;
    private int invoiceIdTable13;
    private double saveBillPriceTable13;

    private BillTable13() {
        soLanBamAddTable13 = 0;
        invoiceIdTable13 = 0;
        isBillIdDetailTable13 = false;
        billReviewTable13 = "";
        saveBillPriceTable13 = 0.0;
    }

    public static synchronized BillTable13 getInstanceTable13() {
        if (instanceTable13 == null) {
            instanceTable13 = new BillTable13();
        }
        return instanceTable13;
    }

    public int getInvoiceIdTable13() {
        return invoiceIdTable13;
    }

    public void setInvoiceIdTable13(int InvoiceIdTable13) {
        this.invoiceIdTable13 = InvoiceIdTable13;
    }

    public boolean isBillIdDetailTable13() {
        return isBillIdDetailTable13;
    }

    public void setIsBillIdDetailTable13(boolean IsBillIdDetailTable13) {
        this.isBillIdDetailTable13 = IsBillIdDetailTable13;
    }

    public int getSoLanBamAddTable13() {
        return soLanBamAddTable13;
    }

    public void setSoLanBamAddTable13(int SoLanBamAddTable13) {
        this.soLanBamAddTable13 = SoLanBamAddTable13;
    }

    public String getBillReviewTable13() {
        return billReviewTable13;
    }

    public void setBillReviewTable13(String BillReviewTable13) {
        this.billReviewTable13 = BillReviewTable13;
    }

    public double getSaveBillPriceTable13() {
        return saveBillPriceTable13;
    }

    public void setSaveBillPriceTable13(double SaveBillPriceTable13) {
        this.saveBillPriceTable13 = SaveBillPriceTable13;
    }
}

