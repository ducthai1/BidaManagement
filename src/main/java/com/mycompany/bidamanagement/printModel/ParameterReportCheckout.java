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
    
    private Date CURRENT_DATE;
    private double TOTALBILL;
    private List<FieldReportCheckout> fields;

    public void setCURRENT_DATE(Date CURRENT_DATE) {
        this.CURRENT_DATE = CURRENT_DATE;
    }

    public void setTOTALBILL(double TOTALBILL) {
        this.TOTALBILL = TOTALBILL;
    }

    public void setFields(List<FieldReportCheckout> fields) {
        this.fields = fields;
    }

    public Date getCURRENT_DATE() {
        return CURRENT_DATE;
    }

    public double getTOTALBILL() {
        return TOTALBILL;
    }

    public List<FieldReportCheckout> getFields() {
        return fields;
    }

    public ParameterReportCheckout() {
    }

    public ParameterReportCheckout(Date CURRENT_DATE, List<FieldReportCheckout> fields, double TOTALBILL) {
        this.CURRENT_DATE = CURRENT_DATE;
        this.fields = fields;
        this.TOTALBILL = TOTALBILL;    
    }
}
