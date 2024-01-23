/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.printModel;

import java.util.Date;
import java.util.List;

/**
 *
 * @author duc
 */
public class ParameterReportCheckout {

    public Date getCURRENT_DATE() {
        return CURRENT_DATE;
    }

    public void setCURRENT_DATE(Date CURRENT_DATE) {
        this.CURRENT_DATE = CURRENT_DATE;
    }

    public String getPRO_NAME() {
        return PRO_NAME;
    }

    public void setPRO_NAME(String PRO_NAME) {
        this.PRO_NAME = PRO_NAME;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public Double getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(Double TOTAL) {
        this.TOTAL = TOTAL;
    }

    public List<FieldReportCheckout> getFields() {
        return fields;
    }

    public void setFields(List<FieldReportCheckout> fields) {
        this.fields = fields;
    }
    
    
    Date CURRENT_DATE;
    String PRO_NAME;
    Double PRICE;
    int QTY;
    Double TOTAL;

    public Double getTOTALBILL() {
        return TOTALBILL;
    }

    public void setTOTALBILL(Double TOTALBILL) {
        this.TOTALBILL = TOTALBILL;
    }
    Double TOTALBILL;
    List<FieldReportCheckout> fields;

    public ParameterReportCheckout() {
    }

    public ParameterReportCheckout(Date CURRENT_DATE, String PRO_NAME, Double PRICE, int QTY, Double TOTAL, List<FieldReportCheckout> fields) {
        this.CURRENT_DATE = CURRENT_DATE;
        this.PRO_NAME = PRO_NAME;
        this.PRICE = PRICE;
        this.QTY = QTY;
        this.TOTAL = TOTAL;
        this.fields = fields;
    }
}
