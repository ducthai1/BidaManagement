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
    private int quantity;
    private double TotalPrice;
    private double TotalBill;
    private Date orderDate;

    // Constructors, getters, and setters
    public FieldReportCheckout() {

    }
    // Constructor
    public FieldReportCheckout(String productName, int quantity, double TotalPrice, double TotalBill, Date orderDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.TotalPrice = TotalPrice;
        this.TotalBill = roundDecimal(TotalPrice * quantity, 2);
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public double getTotalBill() {
        return TotalBill;
    }

    public void setTotalBill(double TotalBill) {
        this.TotalBill = TotalBill;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
