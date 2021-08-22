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
    public Boolean add(Customer customerObject)
    {
        return super.add(customerObject);
    }
    
    public Boolean add(Admin adminObject)
    {
        //Returns FALSE if there are same username
        FileOperator fileOperator = new FileOperator();
        //Compare for username
        int adminCount = 1;
        ArrayList<Admin> adminList = fileOperator.getAdminList(); // Check for same username in Admin.txt
        for(Admin adminCheck:adminList)
        {
            if(adminCheck.getUsername().equals(adminObject.getUsername())) // There is a match
            {
                return false;
            }
            adminCount = adminCount + 1;
            
        }
        
        ArrayList<Customer> customerList = fileOperator.getCustomerList(); // Check for same username in Customer.txt
        for(Customer customerCheck:customerList)
        {
            if(customerCheck.getUsername().equals(adminObject.getUsername())) // There is a match
            {
                return false;
            }
        }
        adminObject.setPersonID("A" + Integer.toString(adminCount));
        
        Boolean status = fileOperator.writeAdmin(adminObject);
        return status;
    }
    
    
    //public String checkInventory(){}
    
    public void checkDuplication(){}
}
