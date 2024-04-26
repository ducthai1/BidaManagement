/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable7 {
    
    private static BillTable7 instanceTable7;
    private int soLanBamAddTable7;
    private String billReviewTable7;
    private boolean isBillIdDetailTable7;
    private int invoiceIdTable7;
    private double saveBillPriceTable7;
    
    private BillTable7() {
        soLanBamAddTable7 = 0;
        invoiceIdTable7 = 0;
        isBillIdDetailTable7 = false;
        billReviewTable7 = "";
        saveBillPriceTable7 = 0.0;
    }
    
    public static synchronized BillTable7 getInstanceTable7() {
        if (instanceTable7 == null) {
            instanceTable7 = new BillTable7();
        }
        return instanceTable7;
    }
    
    public int getInvoiceIdTable7() {
        return invoiceIdTable7;
    }

    public void setInvoiceIdTable7(int InvoiceIdTable7) {
        this.invoiceIdTable7 = InvoiceIdTable7;
    }
    
    public boolean isBillIdDetailTable7() {
        return isBillIdDetailTable7;
    }

    public void setIsBillIdDetailTable7(boolean IsBillIdDetailTable7) {
        this.isBillIdDetailTable7 = IsBillIdDetailTable7;
    }

    public int getSoLanBamAddTable7() {
        return soLanBamAddTable7;
    }

    public void setSoLanBamAddTable7(int SoLanBamAddTable7) {
        this.soLanBamAddTable7 = SoLanBamAddTable7;
    }
    
    public String getBillReviewTable7() {
        return billReviewTable7;
    }

    public void setBillReviewTable7(String BillReviewTable7) {
        this.billReviewTable7 = BillReviewTable7;
    }
    
    
    public double getSaveBillPriceTable7() {
        return saveBillPriceTable7;
    }

    public void setSaveBillPriceTable7(double SaveBillPriceTable7) {
        this.saveBillPriceTable7 = SaveBillPriceTable7;
    }
}
