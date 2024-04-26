/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable5 {
    
    private static BillTable5 instanceTable5;
    private int soLanBamAddTable5;
    private String billReviewTable5;
    private boolean isBillIdDetailTable5;
    private int invoiceIdTable5;
    private double saveBillPriceTable5;
    
    private BillTable5() {
        soLanBamAddTable5 = 0;
        invoiceIdTable5 = 0;
        isBillIdDetailTable5 = false;
        billReviewTable5 = "";
        saveBillPriceTable5 = 0.0;
    }
    
    public static synchronized BillTable5 getInstanceTable5() {
        if (instanceTable5 == null) {
            instanceTable5 = new BillTable5();
        }
        return instanceTable5;
    }
    
    public int getInvoiceIdTable5() {
        return invoiceIdTable5;
    }

    public void setInvoiceIdTable5(int InvoiceIdTable5) {
        this.invoiceIdTable5 = InvoiceIdTable5;
    }
    
    public boolean isBillIdDetailTable5() {
        return isBillIdDetailTable5;
    }

    public void setIsBillIdDetailTable5(boolean IsBillIdDetailTable5) {
        this.isBillIdDetailTable5 = IsBillIdDetailTable5;
    }

    public int getSoLanBamAddTable5() {
        return soLanBamAddTable5;
    }

    public void setSoLanBamAddTable5(int SoLanBamAddTable5) {
        this.soLanBamAddTable5 = SoLanBamAddTable5;
    }
    
    public String getBillReviewTable5() {
        return billReviewTable5;
    }

    public void setBillReviewTable5(String BillReviewTable5) {
        this.billReviewTable5 = BillReviewTable5;
    }
    
    
    public double getSaveBillPriceTable5() {
        return saveBillPriceTable5;
    }

    public void setSaveBillPriceTable5(double SaveBillPriceTable5) {
        this.saveBillPriceTable5 = SaveBillPriceTable5;
    }
}
