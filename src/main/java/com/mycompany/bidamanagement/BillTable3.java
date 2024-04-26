/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable3 {
    
    private static BillTable3 instanceTable3;
    private int soLanBamAddTable3;
    private String billReviewTable3;
    private boolean isBillIdDetailTable3;
    private int invoiceIdTable3;
    private double saveBillPriceTable3;
    
    private BillTable3() {
        soLanBamAddTable3 = 0;
        invoiceIdTable3 = 0;
        isBillIdDetailTable3 = false;
        billReviewTable3 = "";
        saveBillPriceTable3 = 0;
    }
    
    public static synchronized BillTable3 getInstanceTable3() {
        if (instanceTable3 == null) {
            instanceTable3 = new BillTable3();
        }
        return instanceTable3;
    }
    
    public int getInvoiceIdTable3() {
        return invoiceIdTable3;
    }

    public void setInvoiceIdTable3(int InvoiceIdTable3) {
        this.invoiceIdTable3 = InvoiceIdTable3;
    }
    
    public boolean isBillIdDetailTable3() {
        return isBillIdDetailTable3;
    }

    public void setIsBillIdDetailTable3(boolean IsBillIdDetailTable3) {
        this.isBillIdDetailTable3 = IsBillIdDetailTable3;
    }

    public int getSoLanBamAddTable3() {
        return soLanBamAddTable3;
    }

    public void setSoLanBamAddTable3(int SoLanBamAddTable3) {
        this.soLanBamAddTable3 = SoLanBamAddTable3;
    }
    
    public String getBillReviewTable3() {
        return billReviewTable3;
    }

    public void setBillReviewTable3(String BillReviewTable3) {
        this.billReviewTable3 = BillReviewTable3;
    }
    
    
    public double getSaveBillPriceTable3() {
        return saveBillPriceTable3;
    }

    public void setSaveBillPriceTable3(double SaveBillPriceTable3) {
        this.saveBillPriceTable3 = SaveBillPriceTable3;
    }
}
