/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.util.ArrayList;
import java.time.LocalDate;

enum OrderStatus
{
    CANCELLED, COMPLETED, ONGOING;
}

public class Order {
    
    private String orderID;
    private double grandTotal;
    private String customerID;
    private OrderStatus orderStatus;
    private String itemList;
    private String quantityList;
    private LocalDate orderDate;
    
    // Constructor 
    public Order () {} // Default Constructor
    
    public Order(String customerID, OrderStatus orderStatus, double grandTotal, String itemList, String quantityList)
    {
        this.customerID = customerID;
        this.grandTotal = grandTotal;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
        this.quantityList = quantityList;
        orderDate = LocalDate.now();
    }
    
    public Order(String orderID, String customerID, OrderStatus orderStatus, double grandTotal, String itemList, String quantityList, LocalDate orderDate)
    {
        this.orderID = orderID;
        this.customerID = customerID;
        this.grandTotal = grandTotal;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
        this.quantityList = quantityList;
        this.orderDate = orderDate;
    }
    
    // Getters
    public String getOrderID(){return orderID;}
    public double getGrandTotal(){return grandTotal;}
    public String getCustomerID(){return customerID;}
    public OrderStatus getOrderStatus() {return orderStatus;}
    public String getItemList(){return itemList;}
    public String getQuantityList() {return quantityList;}
    public LocalDate getOrderDate() {return orderDate;}
    
    // Setters
    public void setOrderID(String OID){orderID = OID;}
    public void setGrandTotal(double GT){grandTotal = GT;}
    public void setCustomerID(String CID){customerID = CID;}
    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}
    public void setItemList(String OI){itemList = OI;}
    public void setQuantityList(String QL) {quantityList = QL;};
    public void setOrderDate(LocalDate LD) {orderDate = LD;}
    
    // Override inbuilt toString method
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s", orderID, customerID, orderStatus, grandTotal, itemList, quantityList, orderDate);
    }
}
