/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable6 {
    
    private static BillTable6 instanceTable6;
    private int soLanBamAddTable6;
    private String billReviewTable6;
    private boolean isBillIdDetailTable6;
    private int invoiceIdTable6;
    private double saveBillPriceTable6;
    
    private BillTable6() {
        soLanBamAddTable6 = 0;
        invoiceIdTable6 = 0;
        isBillIdDetailTable6 = false;
        billReviewTable6 = "";
        saveBillPriceTable6 = 0.0;
    }
    
    public static synchronized BillTable6 getInstanceTable6() {
        if (instanceTable6 == null) {
            instanceTable6 = new BillTable6();
        }
        return instanceTable6;
    }
    
    public int getInvoiceIdTable6() {
        return invoiceIdTable6;
    }

    public void setInvoiceIdTable6(int InvoiceIdTable6) {
        this.invoiceIdTable6 = InvoiceIdTable6;
    }
    
    public boolean isBillIdDetailTable6() {
        return isBillIdDetailTable6;
    }

    public void setIsBillIdDetailTable6(boolean IsBillIdDetailTable6) {
        this.isBillIdDetailTable6 = IsBillIdDetailTable6;
    }

    public int getSoLanBamAddTable6() {
        return soLanBamAddTable6;
    }

    public void setSoLanBamAddTable6(int SoLanBamAddTable6) {
        this.soLanBamAddTable6 = SoLanBamAddTable6;
    }
    
    public String getBillReviewTable6() {
        return billReviewTable6;
    }

    public void setBillReviewTable6(String BillReviewTable6) {
        this.billReviewTable6 = BillReviewTable6;
    }
    
    
    public double getSaveBillPriceTable6() {
        return saveBillPriceTable6;
    }

    public void setSaveBillPriceTable6(double SaveBillPriceTable6) {
        this.saveBillPriceTable6 = SaveBillPriceTable6;
    }
}
