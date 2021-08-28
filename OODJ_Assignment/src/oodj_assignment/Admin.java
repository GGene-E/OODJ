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
    
    // Registering new Product
    public void add(Product newProduct)
    {
        FileOperator fo = new FileOperator();
        ArrayList<Product> productList = fo.getProductList();
        String lastUsableID = "0";
        for(Product productObject:productList)
        {
            lastUsableID = productObject.getProductID();
        }
        int newIDInt = Integer.parseInt(lastUsableID) + 1;
        newProduct.setProductID(Integer.toString(newIDInt));
        fo.add(newProduct);
    }
    
    // Registering new Admin from Admin Account -> Overloaded add()
    public Boolean add(Admin adminObject)
    {
        //Returns FALSE if there are same username
        FileOperator fileOperator = new FileOperator();
        //Compare for username
        String lastAdminID = "A0";
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
        ArrayList<Customer> matchedCustomer = search(ID, null, null);
        for(Customer customerObject:matchedCustomer)
        {
            if(customerObject.getPersonID().toLowerCase().equals(ID))
            {
                viewedCustomer = customerObject;
            }
        }
        return viewedCustomer;
    }
    
    // Search Customers
    public ArrayList<Customer> search(String searchParameter, String x, String y) // Massive Search
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
    public ArrayList<Product> search(String searchParameter, String x) // int x is used to Overload
    {
        ArrayList<Product> foundProd = new ArrayList<Product>();
        searchParameter = searchParameter.toLowerCase().trim(); // Reformat for search
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> prodList = fileOperator.getProductList();
        
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
    
    public boolean editProd(Product edittedProd) //JONATHAN Overload this 
    {
        FileOperator fop = new FileOperator();
        ArrayList<Product> removedList = fop.deleteProductList(edittedProd);
        int index = Integer.parseInt(edittedProd.getProductID()) - 1;
        removedList.add(index, edittedProd);        
        boolean check = fop.overwriteProduct(removedList);
        return check;
    }
    
    // Delete Customer --> No remains of Entry
    public Boolean delete(String customerID)
    {
        Boolean status = false;
        FileOperator fileOperator = new FileOperator();
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        
        Iterator customerIterator = customerList.iterator(); // Create an Iterator
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
}