/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable10 {
    
    private static BillTable10 instanceTable10;
    private int soLanBamAddTable10;
    private String billReviewTable10;
    private boolean isBillIdDetailTable10;
    private int invoiceIdTable10;
    private double saveBillPriceTable10;
    
    private BillTable10() {
        soLanBamAddTable10 = 0;
        invoiceIdTable10 = 0;
        isBillIdDetailTable10 = false;
        billReviewTable10 = "";
        saveBillPriceTable10 = 0.0;
    }
    
    public static synchronized BillTable10 getInstanceTable10() {
        if (instanceTable10 == null) {
            instanceTable10 = new BillTable10();
        }
        return instanceTable10;
    }
    
    public int getInvoiceIdTable10() {
        return invoiceIdTable10;
    }

    public void setInvoiceIdTable10(int InvoiceIdTable10) {
        this.invoiceIdTable10 = InvoiceIdTable10;
    }
    
    public boolean isBillIdDetailTable10() {
        return isBillIdDetailTable10;
    }

    public void setIsBillIdDetailTable10(boolean IsBillIdDetailTable10) {
        this.isBillIdDetailTable10 = IsBillIdDetailTable10;
    }

    public int getSoLanBamAddTable10() {
        return soLanBamAddTable10;
    }

    public void setSoLanBamAddTable10(int SoLanBamAddTable10) {
        this.soLanBamAddTable10 = SoLanBamAddTable10;
    }
    
    public String getBillReviewTable10() {
        return billReviewTable10;
    }

    public void setBillReviewTable10(String BillReviewTable10) {
        this.billReviewTable10 = BillReviewTable10;
    }
    
    
    public double getSaveBillPriceTable10() {
        return saveBillPriceTable10;
    }

    public void setSaveBillPriceTable10(double SaveBillPriceTable10) {
        this.saveBillPriceTable10 = SaveBillPriceTable10;
    }
}

