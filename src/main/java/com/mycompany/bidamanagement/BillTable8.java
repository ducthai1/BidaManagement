/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable8 {
    
    private static BillTable8 instanceTable8;
    private int soLanBamAddTable8;
    private String billReviewTable8;
    private boolean isBillIdDetailTable8;
    private int invoiceIdTable8;
    private double saveBillPriceTable8;
    
    private BillTable8() {
        soLanBamAddTable8 = 0;
        invoiceIdTable8 = 0;
        isBillIdDetailTable8 = false;
        billReviewTable8 = "";
        saveBillPriceTable8 = 0.0;
    }
    
    public static synchronized BillTable8 getInstanceTable8() {
        if (instanceTable8 == null) {
            instanceTable8 = new BillTable8();
        }
        return instanceTable8;
    }
    
    public int getInvoiceIdTable8() {
        return invoiceIdTable8;
    }

    public void setInvoiceIdTable8(int InvoiceIdTable8) {
        this.invoiceIdTable8 = InvoiceIdTable8;
    }
    
    public boolean isBillIdDetailTable8() {
        return isBillIdDetailTable8;
    }

    public void setIsBillIdDetailTable8(boolean IsBillIdDetailTable8) {
        this.isBillIdDetailTable8 = IsBillIdDetailTable8;
    }

    public int getSoLanBamAddTable8() {
        return soLanBamAddTable8;
    }

    public void setSoLanBamAddTable8(int SoLanBamAddTable8) {
        this.soLanBamAddTable8 = SoLanBamAddTable8;
    }
    
    public String getBillReviewTable8() {
        return billReviewTable8;
    }

    public void setBillReviewTable8(String BillReviewTable8) {
        this.billReviewTable8 = BillReviewTable8;
    }
    
    
    public double getSaveBillPriceTable8() {
        return saveBillPriceTable8;
    }

    public void setSaveBillPriceTable8(double SaveBillPriceTable8) {
        this.saveBillPriceTable8 = SaveBillPriceTable8;
    }
}
