/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable4 {
    
    private static BillTable4 instanceTable4;
    private int soLanBamAddTable4;
    private String billReviewTable4;
    private boolean isBillIdDetailTable4;
    private int invoiceIdTable4;
    private double saveBillPriceTable4;
    
    private BillTable4() {
        soLanBamAddTable4 = 0;
        invoiceIdTable4 = 0;
        isBillIdDetailTable4 = false;
        billReviewTable4 = "";
        saveBillPriceTable4 = 0.0;
    }
    
    public static synchronized BillTable4 getInstanceTable4() {
        if (instanceTable4 == null) {
            instanceTable4 = new BillTable4();
        }
        return instanceTable4;
    }
    
    public int getInvoiceIdTable4() {
        return invoiceIdTable4;
    }

    public void setInvoiceIdTable4(int InvoiceIdTable4) {
        this.invoiceIdTable4 = InvoiceIdTable4;
    }
    
    public boolean isBillIdDetailTable4() {
        return isBillIdDetailTable4;
    }

    public void setIsBillIdDetailTable4(boolean IsBillIdDetailTable4) {
        this.isBillIdDetailTable4 = IsBillIdDetailTable4;
    }

    public int getSoLanBamAddTable4() {
        return soLanBamAddTable4;
    }

    public void setSoLanBamAddTable4(int SoLanBamAddTable4) {
        this.soLanBamAddTable4 = SoLanBamAddTable4;
    }
    
    public String getBillReviewTable4() {
        return billReviewTable4;
    }

    public void setBillReviewTable4(String BillReviewTable4) {
        this.billReviewTable4 = BillReviewTable4;
    }
    
    
    public double getSaveBillPriceTable4() {
        return saveBillPriceTable4;
    }

    public void setSaveBillPriceTable4(double SaveBillPriceTable4) {
        this.saveBillPriceTable4 = SaveBillPriceTable4;
    }
}
