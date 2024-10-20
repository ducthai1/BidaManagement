/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable17 {
    private static BillTable17 instanceTable17;
    private int soLanBamAddTable17;
    private String billReviewTable17;
    private boolean isBillIdDetailTable17;
    private int invoiceIdTable17;
    private double saveBillPriceTable17;

    private BillTable17() {
        soLanBamAddTable17 = 0;
        invoiceIdTable17 = 0;
        isBillIdDetailTable17 = false;
        billReviewTable17 = "";
        saveBillPriceTable17 = 0.0;
    }

    public static synchronized BillTable17 getInstanceTable17() {
        if (instanceTable17 == null) {
            instanceTable17 = new BillTable17();
        }
        return instanceTable17;
    }

    public int getInvoiceIdTable17() {
        return invoiceIdTable17;
    }

    public void setInvoiceIdTable17(int InvoiceIdTable17) {
        this.invoiceIdTable17 = InvoiceIdTable17;
    }

    public boolean isBillIdDetailTable17() {
        return isBillIdDetailTable17;
    }

    public void setIsBillIdDetailTable17(boolean IsBillIdDetailTable17) {
        this.isBillIdDetailTable17 = IsBillIdDetailTable17;
    }

    public int getSoLanBamAddTable17() {
        return soLanBamAddTable17;
    }

    public void setSoLanBamAddTable17(int SoLanBamAddTable17) {
        this.soLanBamAddTable17 = SoLanBamAddTable17;
    }

    public String getBillReviewTable17() {
        return billReviewTable17;
    }

    public void setBillReviewTable17(String BillReviewTable17) {
        this.billReviewTable17 = BillReviewTable17;
    }

    public double getSaveBillPriceTable17() {
        return saveBillPriceTable17;
    }

    public void setSaveBillPriceTable17(double SaveBillPriceTable17) {
        this.saveBillPriceTable17 = SaveBillPriceTable17;
    }
}

