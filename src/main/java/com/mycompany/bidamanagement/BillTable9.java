/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class BillTable9 {
    
    private static BillTable9 instanceTable9;
    private int soLanBamAddTable9;
    private String billReviewTable9;
    private boolean isBillIdDetailTable9;
    private int invoiceIdTable9;
    private double saveBillPriceTable9;
    
    private BillTable9() {
        soLanBamAddTable9 = 0;
        invoiceIdTable9 = 0;
        isBillIdDetailTable9 = false;
        billReviewTable9 = "";
        saveBillPriceTable9 = 0.0;
    }
    
    public static synchronized BillTable9 getInstanceTable9() {
        if (instanceTable9 == null) {
            instanceTable9 = new BillTable9();
        }
        return instanceTable9;
    }
    
    public int getInvoiceIdTable9() {
        return invoiceIdTable9;
    }

    public void setInvoiceIdTable9(int InvoiceIdTable9) {
        this.invoiceIdTable9 = InvoiceIdTable9;
    }
    
    public boolean isBillIdDetailTable9() {
        return isBillIdDetailTable9;
    }

    public void setIsBillIdDetailTable9(boolean IsBillIdDetailTable9) {
        this.isBillIdDetailTable9 = IsBillIdDetailTable9;
    }

    public int getSoLanBamAddTable9() {
        return soLanBamAddTable9;
    }

    public void setSoLanBamAddTable9(int SoLanBamAddTable9) {
        this.soLanBamAddTable9 = SoLanBamAddTable9;
    }
    
    public String getBillReviewTable9() {
        return billReviewTable9;
    }

    public void setBillReviewTable9(String BillReviewTable9) {
        this.billReviewTable9 = BillReviewTable9;
    }
    
    
    public double getSaveBillPriceTable9() {
        return saveBillPriceTable9;
    }

    public void setSaveBillPriceTable9(double SaveBillPriceTable9) {
        this.saveBillPriceTable9 = SaveBillPriceTable9;
    }
}

