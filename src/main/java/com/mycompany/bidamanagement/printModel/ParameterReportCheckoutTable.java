/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.printModel;

/**
 *
 * @author duc
 */
public class ParameterReportCheckoutTable {

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getSTARTTIME() {
        return STARTTIME;
    }

    public void setSTARTTIME(String STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    public String getENDTIME() {
        return ENDTIME;
    }

    public void setENDTIME(String ENDTIME) {
        this.ENDTIME = ENDTIME;
    }

    public String getTABLE_FEE() {
        return TABLE_FEE;
    }

    public void setTABLE_FEE(String TABLE_FEE) {
        this.TABLE_FEE = TABLE_FEE;
    }
    
    public int getINVOICE_ID() {
        return INVOICE_ID;
    }
    
    public void setINVOICE_ID (int INVOICE_ID) {
        this.INVOICE_ID = INVOICE_ID;
    }
    
    public String getTOTAL_BILL_FEE() {
        return TOTAL_BILL_FEE;
    }
    
    public void setTOTAL_TABLE_FEE (String TOTAL_BILL_FEE) {
        this.TOTAL_BILL_FEE = TOTAL_BILL_FEE;
    }
    

    public ParameterReportCheckoutTable(String DATE, String STARTTIME, String ENDTIME, String TABLE_FEE, int INVOICE_ID, String TOTAL_BILL_FEE) {
        this.DATE = DATE;
        this.STARTTIME = STARTTIME;
        this.ENDTIME = ENDTIME;
        this.TABLE_FEE = TABLE_FEE;
        this.INVOICE_ID = INVOICE_ID;
        this.TOTAL_BILL_FEE = TOTAL_BILL_FEE;
    }

    public ParameterReportCheckoutTable() {
    }
    
    private String DATE;
    private String STARTTIME;
    private String ENDTIME;
    private String TABLE_FEE;
    private String TOTAL_BILL_FEE;
    private int INVOICE_ID;

    
}
