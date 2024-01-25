/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.printModel;

import static com.mycompany.bidamanagement.CheckOut.roundDecimal;
import java.util.Date;

/**
 *
 * @author duc
 */
public class FieldReportCheckout {
    private String productName;
    private double TotalPrice;    
    private int quantity;    
    private double TotalBill;

    public FieldReportCheckout(String productName, double TotalPrice, int quantity, double TotalBill) {
        this.productName = productName;
        this.TotalPrice = TotalPrice;
        this.quantity = quantity;
        this.TotalBill = TotalBill;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalBill(double TotalBill) {
        this.TotalBill = TotalBill;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalBill() {
        return TotalBill;
    }

    
    // Constructors, getters, and setters
    public FieldReportCheckout() {

    }
    
 }

    
