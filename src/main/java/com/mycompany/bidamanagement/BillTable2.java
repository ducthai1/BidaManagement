/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable2 {
    
    private static BillTable2 instanceTable2;
    private int soLanBamAddTable2;
    private String billReviewTable2;
    private boolean isBillIdDetailTable2;
    private int invoiceIdTable2;
    private double saveBillPriceTable2;
    
    private BillTable2() {
        soLanBamAddTable2 = 0;
        invoiceIdTable2 = 0;
        isBillIdDetailTable2 = false;
        billReviewTable2 = "";
        saveBillPriceTable2 = 0;
    }
    
    public static synchronized BillTable2 getInstanceTable2() {
        if (instanceTable2 == null) {
            instanceTable2 = new BillTable2();
        }
        return instanceTable2;
    }
    
    public int getInvoiceIdTable2() {
        return invoiceIdTable2;
    }

    public void setInvoiceIdTable2(int InvoiceIdTable2) {
        this.invoiceIdTable2 = InvoiceIdTable2;
    }
    
    public boolean isBillIdDetailTable2() {
        return isBillIdDetailTable2;
    }

    public void setIsBillIdDetailTable2(boolean IsBillIdDetailTable2) {
        this.isBillIdDetailTable2 = IsBillIdDetailTable2;
    }

    public int getSoLanBamAddTable2() {
        return soLanBamAddTable2;
    }

    public void setSoLanBamAddTable2(int SoLanBamAddTable2) {
        this.soLanBamAddTable2 = SoLanBamAddTable2;
    }
    
    public String getBillReviewTable2() {
        return billReviewTable2;
    }

    public void setBillReviewTable2(String BillReviewTable2) {
        this.billReviewTable2 = BillReviewTable2;
    }
    
    
    public double getSaveBillPriceTable2() {
        return saveBillPriceTable2;
    }

    public void setSaveBillPriceTable2(double SaveBillPriceTable2) {
        this.saveBillPriceTable2 = SaveBillPriceTable2;
    }
}
