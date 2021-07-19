/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

/**
 *
 * @author user
 */
public class OrderItem {
    
    // Attribute
    private String orderID;
    private String productID;
    private double itemSum;
    private int quantity;
    
    // Getter
    public String getOrderID(){return orderID;}
    public String getProductID(){return productID;}
    public double getItemSum(){return itemSum;}
    public int getQuantity(){return quantity;}
    
    // Setter
    public void setOrderID(String OID){orderID = OID;}
    public void setProductID(String PID){productID = PID;}
    public void setItemSum(double IS){itemSum = IS;}
    public void setQuantity(int Q){quantity = Q;}
}
