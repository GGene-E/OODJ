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
   
    public Customer(String personID, String username)
    {
        super(personID, username);
    }
    
    public Customer(String personID, String name, String contact, String email, int age)
    {
        super(personID, name, contact, email, age);
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
    
    // Override inbuilt toString
    @Override
    public String toString()
    {
        return super.toString();
    }
}
