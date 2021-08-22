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
public class Customer extends Person {
    
    // Customer Constructor
    public Customer() // Default Constructor
    {
        super();
    }
   
    public Customer(String name, String username, String password, int age, String contact, String email)
    {
        super(name, username, password, age, contact, email);
    }
    
    public Customer(String personID, String name, String username, String password, int age, String contact, String email)
    {
        super(personID, name, username, password, age, contact, email);
    }
    
    // Methods
    // Customer Registering Ownself // Self-Registration
    public Boolean add(Customer customerObject)
    {
        return super.add(customerObject);
    }
    
    /*
    public String giveReview(){}
    
    public String rateShop(){}
    */
    
    // Override inbuilt toString
    @Override
    public String toString()
    {
        return super.toString();
    }
}
