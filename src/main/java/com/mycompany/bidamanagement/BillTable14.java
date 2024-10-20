/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable14 {
    private static BillTable14 instanceTable14;
    private int soLanBamAddTable14;
    private String billReviewTable14;
    private boolean isBillIdDetailTable14;
    private int invoiceIdTable14;
    private double saveBillPriceTable14;

    private BillTable14() {
        soLanBamAddTable14 = 0;
        invoiceIdTable14 = 0;
        isBillIdDetailTable14 = false;
        billReviewTable14 = "";
        saveBillPriceTable14 = 0.0;
    }

    public static synchronized BillTable14 getInstanceTable14() {
        if (instanceTable14 == null) {
            instanceTable14 = new BillTable14();
        }
        return instanceTable14;
    }

    public int getInvoiceIdTable14() {
        return invoiceIdTable14;
    }

    public void setInvoiceIdTable14(int InvoiceIdTable14) {
        this.invoiceIdTable14 = InvoiceIdTable14;
    }

    public boolean isBillIdDetailTable14() {
        return isBillIdDetailTable14;
    }

    public void setIsBillIdDetailTable14(boolean IsBillIdDetailTable14) {
        this.isBillIdDetailTable14 = IsBillIdDetailTable14;
    }

    public int getSoLanBamAddTable14() {
        return soLanBamAddTable14;
    }

    public void setSoLanBamAddTable14(int SoLanBamAddTable14) {
        this.soLanBamAddTable14 = SoLanBamAddTable14;
    }

    public String getBillReviewTable14() {
        return billReviewTable14;
    }

    public void setBillReviewTable14(String BillReviewTable14) {
        this.billReviewTable14 = BillReviewTable14;
    }

    public double getSaveBillPriceTable14() {
        return saveBillPriceTable14;
    }

    public void setSaveBillPriceTable14(double SaveBillPriceTable14) {
        this.saveBillPriceTable14 = SaveBillPriceTable14;
    }
}

