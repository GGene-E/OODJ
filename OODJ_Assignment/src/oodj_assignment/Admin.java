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
public class Admin extends Person{
    
    // Admin Constructors
    public Admin() //Default Constructor
    {
        super();
    }
    
    public Admin(String name, String username, String password, int age, String contact, String email)
    {
        super(name, username, password, age, contact, email);
    }
    
    public Admin(String personID, String name, String username, String password, int age, String contact, String email)
    {
        super(personID, name, username, password, age, contact, email);
    }
    
    // Methods
    public Boolean add(Admin adminObject)
    {
        return true;
    }
    
    
    //public String checkInventory(){}
    
    public void checkDuplication(){}
}
