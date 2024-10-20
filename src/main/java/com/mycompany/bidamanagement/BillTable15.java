/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable15 {
    private static BillTable15 instanceTable15;
    private int soLanBamAddTable15;
    private String billReviewTable15;
    private boolean isBillIdDetailTable15;
    private int invoiceIdTable15;
    private double saveBillPriceTable15;

    private BillTable15() {
        soLanBamAddTable15 = 0;
        invoiceIdTable15 = 0;
        isBillIdDetailTable15 = false;
        billReviewTable15 = "";
        saveBillPriceTable15 = 0.0;
    }

    public static synchronized BillTable15 getInstanceTable15() {
        if (instanceTable15 == null) {
            instanceTable15 = new BillTable15();
        }
        return instanceTable15;
    }

    public int getInvoiceIdTable15() {
        return invoiceIdTable15;
    }

    public void setInvoiceIdTable15(int InvoiceIdTable15) {
        this.invoiceIdTable15 = InvoiceIdTable15;
    }

    public boolean isBillIdDetailTable15() {
        return isBillIdDetailTable15;
    }

    public void setIsBillIdDetailTable15(boolean IsBillIdDetailTable15) {
        this.isBillIdDetailTable15 = IsBillIdDetailTable15;
    }

    public int getSoLanBamAddTable15() {
        return soLanBamAddTable15;
    }

    public void setSoLanBamAddTable15(int SoLanBamAddTable15) {
        this.soLanBamAddTable15 = SoLanBamAddTable15;
    }

    public String getBillReviewTable15() {
        return billReviewTable15;
    }

    public void setBillReviewTable15(String BillReviewTable15) {
        this.billReviewTable15 = BillReviewTable15;
    }

    public double getSaveBillPriceTable15() {
        return saveBillPriceTable15;
    }

    public void setSaveBillPriceTable15(double SaveBillPriceTable15) {
        this.saveBillPriceTable15 = SaveBillPriceTable15;
    }
}

