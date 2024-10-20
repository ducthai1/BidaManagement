/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable12 {
    private static BillTable12 instanceTable12;
    private int soLanBamAddTable12;
    private String billReviewTable12;
    private boolean isBillIdDetailTable12;
    private int invoiceIdTable12;
    private double saveBillPriceTable12;

    private BillTable12() {
        soLanBamAddTable12 = 0;
        invoiceIdTable12 = 0;
        isBillIdDetailTable12 = false;
        billReviewTable12 = "";
        saveBillPriceTable12 = 0.0;
    }

    public static synchronized BillTable12 getInstanceTable12() {
        if (instanceTable12 == null) {
            instanceTable12 = new BillTable12();
        }
        return instanceTable12;
    }

    public int getInvoiceIdTable12() {
        return invoiceIdTable12;
    }

    public void setInvoiceIdTable12(int InvoiceIdTable12) {
        this.invoiceIdTable12 = InvoiceIdTable12;
    }

    public boolean isBillIdDetailTable12() {
        return isBillIdDetailTable12;
    }

    public void setIsBillIdDetailTable12(boolean IsBillIdDetailTable12) {
        this.isBillIdDetailTable12 = IsBillIdDetailTable12;
    }

    public int getSoLanBamAddTable12() {
        return soLanBamAddTable12;
    }

    public void setSoLanBamAddTable12(int SoLanBamAddTable12) {
        this.soLanBamAddTable12 = SoLanBamAddTable12;
    }

    public String getBillReviewTable12() {
        return billReviewTable12;
    }

    public void setBillReviewTable12(String BillReviewTable12) {
        this.billReviewTable12 = BillReviewTable12;
    }

    public double getSaveBillPriceTable12() {
        return saveBillPriceTable12;
    }

    public void setSaveBillPriceTable12(double SaveBillPriceTable12) {
        this.saveBillPriceTable12 = SaveBillPriceTable12;
    }
}

