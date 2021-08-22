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
    
    //Admin Constructor
    public Admin() {} //Default Constructor
    
    public Admin(String ID, String name, String username, String password, int age, String contact, String email, PersonType personType) 
    {
        super(ID, name, username, password, age, contact, email, personType);
    }
    
    /*
    public String checkInventory(){}
    */
    
    // Overloaded View used to View Customer List
    public ArrayList<Customer> view(int x, int y)
    {
        FileOperator fileOperator = new FileOperator();
        return fileOperator.getCustomerList(); 
    }
    
    // Get the details of a single Customer
    public String[] view(String searchedID) 
    {
        String[] matchedDetails = new String[0];
        
        FileOperator fileOperator = new FileOperator();
        ArrayList<String> personList = fileOperator.getPersonList(); 
        
        if(!personList.isEmpty()) //Not Empty
        {
            for(String personDetail:personList)
            {
                String[] personDetailArray = personDetail.split(",");
                if(personDetailArray[0].equals(searchedID))
                {
                    return matchedDetails = personDetailArray;
                }
            }
        }
        return matchedDetails;        
    }
    
    
    public void checkDuplication(){}
}
