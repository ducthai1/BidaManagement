/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class BillTable1 {
    
    private static BillTable1 instanceTable1;
    private int soLanBamAddTable1;
    private String billReviewTable1;
    private boolean isBillIdDetailTable1;
    private int invoiceIdTable1;
    private double saveBillPriceTable1;
    
    private BillTable1() {
        soLanBamAddTable1 = 0;
        invoiceIdTable1 = 0;
        isBillIdDetailTable1 = false;
        billReviewTable1 = "";
        saveBillPriceTable1 = 0;
    }
    
    public static synchronized BillTable1 getInstanceTable1() {
        if (instanceTable1 == null) {
            instanceTable1 = new BillTable1();
        }
        return instanceTable1;
    }
    
    public int getInvoiceIdTable1() {
        return invoiceIdTable1;
    }

    public void setInvoiceIdTable1(int InvoiceIdTable1) {
        this.invoiceIdTable1 = InvoiceIdTable1;
    }
    
    public boolean isBillIdDetailTable1() {
        return isBillIdDetailTable1;
    }

    public void setIsBillIdDetailTable1(boolean IsBillIdDetailTable1) {
        this.isBillIdDetailTable1 = IsBillIdDetailTable1;
    }

    public int getSoLanBamAddTable1() {
        return soLanBamAddTable1;
    }

    public void setSoLanBamAddTable1(int SoLanBamAddTable1) {
        this.soLanBamAddTable1 = SoLanBamAddTable1;
    }
    
    public String getBillReviewTable1() {
        return billReviewTable1;
    }

    public void setBillReviewTable1(String BillReviewTable1) {
        this.billReviewTable1 = BillReviewTable1;
    }
    
    
    public double getSaveBillPriceTable1() {
        return saveBillPriceTable1;
    }

    public void setSaveBillPriceTable1(double SaveBillPriceTable1) {
        this.saveBillPriceTable1 = SaveBillPriceTable1;
    }
}
