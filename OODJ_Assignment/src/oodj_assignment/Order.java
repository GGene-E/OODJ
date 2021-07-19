/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Order {
    
    private String order_ID;
    private double grandTotal;
    private String customerID;
    ArrayList<OrderItem> item = new ArrayList<OrderItem>();
    
    // Constructor 
    public Order(String OID, double GT, String CID)
    {
        order_ID = OID;
        grandTotal = GT;
        customerID = CID;
        
        
    }
    
    // Getters
    public String getOrderID(){return order_ID;}
    public double getGrandTotal(){return grandTotal;}
    public String getCustomerID(){return customerID;}
    public ArrayList<OrderItem> getItem(){return item;}
    
    // Setters
    public void setOrderID(String OID){order_ID = OID;}
    public void setGrandTotal(double GT){grandTotal = GT;}
    public void setCustomerID(String CID){customerID = CID;}
    public void setItems(ArrayList<OrderItem> OI){item = OI;}
    
    // Method
    /*
    public double calcGrandTotal(){}
    
    public boolean duplicationCheck(){}
    */
    
}
