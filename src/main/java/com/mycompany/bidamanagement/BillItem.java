package com.mycompany.bidamanagement;

import static com.mycompany.bidamanagement.CheckOut.roundDecimal;
import java.util.Date;

public class BillItem {

    private String productName;
    private int quantity;
    private double TotalPrice;
    private double TotalBill;
    private Date orderDate;

    // Constructors, getters, and setters
    public BillItem() {

    }
    // Constructor
    public BillItem(String productName, int quantity, double TotalPrice, double TotalBill, Date orderDate) {
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
