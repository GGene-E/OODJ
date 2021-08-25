/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.util.ArrayList;

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
    
    // Constructor 
    public Order () {} // Default Constructor
    
    public Order(String customerID, OrderStatus orderStatus, double grandTotal, String itemList, String quantityList)
    {
        this.customerID = customerID;
        this.grandTotal = grandTotal;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
        this.quantityList = quantityList;
    }
    
    public Order(String orderID, String customerID, OrderStatus orderStatus, double grandTotal, String itemList, String quantityList)
    {
        this.orderID = orderID;
        this.customerID = customerID;
        this.grandTotal = grandTotal;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
        this.quantityList = quantityList;
    }
    
    // Getters
    public String getOrderID(){return orderID;}
    public double getGrandTotal(){return grandTotal;}
    public String getCustomerID(){return customerID;}
    public OrderStatus getOrderStatus() {return orderStatus;}
    public String getItemList(){return itemList;}
    public String getQuantityList() {return quantityList;}
    
    // Setters
    public void setOrderID(String OID){orderID = OID;}
    public void setGrandTotal(double GT){grandTotal = GT;}
    public void setCustomerID(String CID){customerID = CID;}
    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}
    public void setItemList(String OI){itemList = OI;}
    public void setQuantityList(String QL) {quantityList = QL;};
    
    // Method
    /*
    public double calcGrandTotal(){}
    
    public boolean duplicationCheck(){}
    */
    
}
