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
    
    //Constructors
    public Customer() {} //Default Constructor
    
    public Customer(String ID, String name, String username, String password, int age, String contact, String email) 
    {
        super(ID, name, username, password, age, contact, email);
    }
    
    public Customer(String ID, String name, String username, String password, int age, String contact, String email, PersonType personType) 
    {
        super(ID, name, username, password, age, contact, email, personType);
    }

    
    /*
    public String giveReview(){}
    
    public String rateShop(){}
    */
}
