/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable16 {
    private static BillTable16 instanceTable16;
    private int soLanBamAddTable16;
    private String billReviewTable16;
    private boolean isBillIdDetailTable16;
    private int invoiceIdTable16;
    private double saveBillPriceTable16;

    private BillTable16() {
        soLanBamAddTable16 = 0;
        invoiceIdTable16 = 0;
        isBillIdDetailTable16 = false;
        billReviewTable16 = "";
        saveBillPriceTable16 = 0.0;
    }

    public static synchronized BillTable16 getInstanceTable16() {
        if (instanceTable16 == null) {
            instanceTable16 = new BillTable16();
        }
        return instanceTable16;
    }

    public int getInvoiceIdTable16() {
        return invoiceIdTable16;
    }

    public void setInvoiceIdTable16(int InvoiceIdTable16) {
        this.invoiceIdTable16 = InvoiceIdTable16;
    }

    public boolean isBillIdDetailTable16() {
        return isBillIdDetailTable16;
    }

    public void setIsBillIdDetailTable16(boolean IsBillIdDetailTable16) {
        this.isBillIdDetailTable16 = IsBillIdDetailTable16;
    }

    public int getSoLanBamAddTable16() {
        return soLanBamAddTable16;
    }

    public void setSoLanBamAddTable16(int SoLanBamAddTable16) {
        this.soLanBamAddTable16 = SoLanBamAddTable16;
    }

    public String getBillReviewTable16() {
        return billReviewTable16;
    }

    public void setBillReviewTable16(String BillReviewTable16) {
        this.billReviewTable16 = BillReviewTable16;
    }

    public double getSaveBillPriceTable16() {
        return saveBillPriceTable16;
    }

    public void setSaveBillPriceTable16(double SaveBillPriceTable16) {
        this.saveBillPriceTable16 = SaveBillPriceTable16;
    }
}

