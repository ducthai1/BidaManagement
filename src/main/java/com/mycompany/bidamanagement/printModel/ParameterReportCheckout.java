/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.printModel;

/**
 *
 * @author duc
 */
public class ParameterReportCheckout {

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
    

    public ParameterReportCheckout(String DATE, String STARTTIME, String ENDTIME, String TABLE_FEE) {
        this.DATE = DATE;
        this.STARTTIME = STARTTIME;
        this.ENDTIME = ENDTIME;
        this.TABLE_FEE = TABLE_FEE;
    }

    public ParameterReportCheckout() {
    }
    
    private String DATE;
    private String STARTTIME;
    private String ENDTIME;
    private String TABLE_FEE;
    
}
