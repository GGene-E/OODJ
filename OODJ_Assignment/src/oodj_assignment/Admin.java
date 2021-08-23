/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    public Admin(String personID, String username)
    {
        super(personID, username);
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
    // Get Customer List
    public ArrayList<Customer> getCustomerList()
    {
        FileOperator fileOperator = new FileOperator();
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        return customerList;
    }
    
    // Get Product List
    public ArrayList<Product> getProductList()
    {
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> productList = fileOperator.getProductArray();
        return productList;
    }
    
    // Registering new Product
    public void add(double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        FileOperator fo = new FileOperator();
        fo.addProduct(price, type, status, name, description, frag, stock);
    }
    
    // Registering new Customers from Admin Account
    public Boolean add(Customer customerObject)
    {
        return super.add(customerObject);
    }
    
    // Registering new Admin from Admin Account -> Overloaded add()
    public Boolean add(Admin adminObject)
    {
        //Returns FALSE if there are same username
        FileOperator fileOperator = new FileOperator();
        //Compare for username
        String lastAdminID = "a";
        ArrayList<Admin> adminList = fileOperator.getAdminList(); // Check for same username in Admin.txt
        for(Admin adminCheck:adminList)
        {
            if(adminCheck.getUsername().equals(adminObject.getUsername())) // There is a match
            {
                return false;
            }
            lastAdminID = adminCheck.getPersonID();
        }
        
        ArrayList<Customer> customerList = fileOperator.getCustomerList(); // Check for same username in Customer.txt
        for(Customer customerCheck:customerList)
        {
            if(customerCheck.getUsername().equals(adminObject.getUsername())) // There is a match
            {
                return false;
            }
        }
        lastAdminID = lastAdminID.substring(1);
        String newAdminID = Integer.toString(Integer.parseInt(lastAdminID) + 1);
        adminObject.setPersonID(String.format("A%s", newAdminID));
                        
        Boolean status = fileOperator.writeAdmin(adminObject);
        return status;
    }
    
    // Viewing Customers
    public Customer view(String ID) //Specialized Finder
    {
        Customer viewedCustomer = null;
        ID = ID.toLowerCase().trim(); // Reformat for search
        ArrayList<Customer> matchedCustomer = search(ID);
        for(Customer customerObject:matchedCustomer)
        {
            if(customerObject.getPersonID().toLowerCase().equals(ID))
            {
                viewedCustomer = customerObject;
            }
        }
        return viewedCustomer;
    }
    
    public Product viewProd(String ID)
    {
        Product viewedProd = null;
        ID = ID.toLowerCase().trim();
        ArrayList<Product> matchedProduct = searchProd(ID);
        for(Product prod : matchedProduct)
        {
            if(prod.getProductID().toLowerCase().equals(ID))
            {
                viewedProd = prod;
            }
        }
        return viewedProd;
    }
    
    // Search Customers
    public ArrayList<Customer> search(String searchParameter) // Massive Search
    {
        ArrayList<Customer> foundCustomer = new ArrayList<Customer>();
        searchParameter = searchParameter.toLowerCase().trim(); // Reformat for search
        FileOperator fileOperator = new FileOperator();
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        
        for(Customer customerObject:customerList)
        {
            if(searchParameter.equals(customerObject.getPersonID().toLowerCase()))
            {
                foundCustomer.add(customerObject);
            }
            else if(searchParameter.equals(customerObject.getName().toLowerCase())|| 
                    customerObject.getName().toLowerCase().contains(searchParameter))
            {
                foundCustomer.add(customerObject);
            }
        }
        return foundCustomer;
    }
    
    
    // Search Customer
    public ArrayList<Product> searchProd(String searchParameter) // Massive Search
    {
        ArrayList<Product> foundProd = new ArrayList<Product>();
        searchParameter = searchParameter.toLowerCase().trim(); // Reformat for search
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> prodList = fileOperator.getProductArray();
        
        for(Product prod : prodList)
        {
            if(searchParameter.equals(prod.getProductID().toLowerCase()))
            {
                foundProd.add(prod);
            }
            else if(searchParameter.equals(prod.getName().toLowerCase())|| 
                    prod.getName().toLowerCase().contains(searchParameter))
            {
                foundProd.add(prod);
            }
        }
        return foundProd;
    }
    
    // Edit Customers
    public Boolean edit(Customer edittedCustomer)
    {
        Boolean status = false;
        FileOperator fileOperator = new FileOperator();
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        for(Customer customerObject:customerList)
        {
            if(customerObject.getPersonID().equals(edittedCustomer.getPersonID()))
            {
                customerObject.setName(edittedCustomer.getName());
                customerObject.setContact(edittedCustomer.getContact());
                customerObject.setEmail(edittedCustomer.getEmail());
                customerObject.setAge(edittedCustomer.getAge());
                status = true;
            }
        }
        if(status == true)
        {
            status = fileOperator.overwriteCustomer(customerList);
        }
        return status;
    }
    
    // Delete Customer --> No remains of Entry
    public Boolean delete(String customerID)
    {
        Boolean status = false;
        FileOperator fileOperator = new FileOperator();
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        
        Iterator customerIterator = customerList.iterator();
        while(customerIterator.hasNext())
        {
            Customer customerObject = (Customer)customerIterator.next();
            if(customerObject.getPersonID().equals(customerID))
            {
                customerIterator.remove();
                status = true;
            }
        }
        
        fileOperator.overwriteCustomer(customerList);
        return status;
    }
    
    //public String checkInventory(){}
    
    public void checkDuplication(){}
}