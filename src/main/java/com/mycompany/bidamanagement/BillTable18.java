/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable18 {
    private static BillTable18 instanceTable18;
    private int soLanBamAddTable18;
    private String billReviewTable18;
    private boolean isBillIdDetailTable18;
    private int invoiceIdTable18;
    private double saveBillPriceTable18;

    private BillTable18() {
        soLanBamAddTable18 = 0;
        invoiceIdTable18 = 0;
        isBillIdDetailTable18 = false;
        billReviewTable18 = "";
        saveBillPriceTable18 = 0.0;
    }

    public static synchronized BillTable18 getInstanceTable18() {
        if (instanceTable18 == null) {
            instanceTable18 = new BillTable18();
        }
        return instanceTable18;
    }

    public int getInvoiceIdTable18() {
        return invoiceIdTable18;
    }

    public void setInvoiceIdTable18(int InvoiceIdTable18) {
        this.invoiceIdTable18 = InvoiceIdTable18;
    }

    public boolean isBillIdDetailTable18() {
        return isBillIdDetailTable18;
    }

    public void setIsBillIdDetailTable18(boolean IsBillIdDetailTable18) {
        this.isBillIdDetailTable18 = IsBillIdDetailTable18;
    }

    public int getSoLanBamAddTable18() {
        return soLanBamAddTable18;
    }

    public void setSoLanBamAddTable18(int SoLanBamAddTable18) {
        this.soLanBamAddTable18 = SoLanBamAddTable18;
    }

    public String getBillReviewTable18() {
        return billReviewTable18;
    }

    public void setBillReviewTable18(String BillReviewTable18) {
        this.billReviewTable18 = BillReviewTable18;
    }

    public double getSaveBillPriceTable18() {
        return saveBillPriceTable18;
    }

    public void setSaveBillPriceTable18(double SaveBillPriceTable18) {
        this.saveBillPriceTable18 = SaveBillPriceTable18;
    }
}

