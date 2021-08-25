
package oodj_assignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;

enum PersonType
{
    ADMIN, CUSTOMER;
}

public class Person {
    
    // Attributes of Person
    private String personID; //
    private String name;
    private String username;
    private String password;
    private int age;
    private String contact;
    private String email;
    private PersonType personType;
    
    // Constructors
    public Person() {} //Default Constructor
    
    public Person(String personID, String username) // Login Constructor
    {
        this.personID = personID;
        this.username = username;
    }
    
    public Person(String personID, String name, String contact, String email, int age)
    {
        this.personID = personID;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.age = age;
    }
    
    public Person(String name, String username, String password, int age, String contact, String email)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }
    
    public Person(String personID, String name, String username, String password, int age, String contact, String email)
    {
        this.personID = personID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }
    
    // Getters
    public String getPersonID(){return personID;}
    public String getName(){return name;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public int getAge(){return age;}
    public String getContact(){return contact;}
    public String getEmail(){return email;}
    public PersonType getPersonType() {return personType;}
    
    // Setters
    public void setPersonID(String Id){personID = Id;}
    public void setName(String Nm){name = Nm;}
    public void setUsername(String Un){username = Un;}
    public void setPassword(String Pw){password = Pw;}
    public void setAge(int Ag){age = Ag;}
    public void setContact(String Ct){contact = Ct;}
    public void setEmail(String Em){email = Em;}
    public void setPersonType(PersonType Pt){personType = Pt;}

    // Methods
    // Person Logins to the system
    public String[] login(String username, String password)
    {
        String[] foundUser = new String[0];
        FileOperator fileOperator = new FileOperator();
        // Check Admin
        ArrayList<Admin> adminList = fileOperator.getAdminList();
        for(Admin adminObject:adminList)
        {
            if(adminObject.getUsername().equals(username) && adminObject.getPassword().equals(password))
            {
                String adminDetail = String.format("%s,%s,%s", adminObject.getPersonID(), adminObject.getUsername(), PersonType.ADMIN);
                foundUser = adminDetail.split(",");
            }
        }
        
        ArrayList<Customer> customerList = fileOperator.getCustomerList();
        for(Customer customerObject:customerList)
        {
            if(customerObject.getUsername().equals(username) && customerObject.getPassword().equals(password))
            {
                String customerDetail = String.format("%s,%s,%s", customerObject.getPersonID(), customerObject.getUsername(), PersonType.CUSTOMER);
                foundUser = customerDetail.split(",");
            }
        }
        return foundUser;
    }
    
    // Person Registers Customer / Self Registration
    public Boolean add(Customer customerObject)
    {
        //Returns FALSE if there are same username
        FileOperator fileOperator = new FileOperator();
        //Compare for username
        ArrayList<Admin> adminList = fileOperator.getAdminList(); // Check for same username in Admin.txt
        for(Admin adminCheck:adminList)
        {
            if(adminCheck.getUsername().equals(customerObject.getUsername())) // There is a match
            {
                return false;
            }       
        }
        
        String lastCustomerID = "a";
        ArrayList<Customer> customerList = fileOperator.getCustomerList(); // Check for same username in Customer.txt
        for(Customer customerCheck:customerList)
        {
            if(customerCheck.getUsername().equals(customerObject.getUsername())) // There is a match
            {
                return false;
            }
            lastCustomerID = customerCheck.getPersonID();
        }
        lastCustomerID = lastCustomerID.substring(1);
        String newCustomerID = Integer.toString(Integer.parseInt(lastCustomerID) + 1);
        customerObject.setPersonID(String.format("C%s", newCustomerID)); // Assign Customer ID to new Customer
        
        Boolean status = fileOperator.writeCustomer(customerObject);
        return status;
        
    }
    
    // Person places an ORDER
    public Boolean add(Order orderObject)
    {
        FileOperator fileOperator = new FileOperator();
        //fileOperator.getOrderList();
        //lastOrderID = lastOrderID.substring(1);
        //String newOrderID = Integer.toString(Integer.parseInt(lastOrderID) + 1);
        //orderObject.setOrderID(String.format("O%s", newOrderID)); // Assign Order ID to new Order
        
        Boolean status = fileOperator.writeOrder(orderObject);
        return status;
    }
    
    // Person deletes an ORDER
    public void delete(){}
    
    // Person edits an ORDER
    public void edit()
    {
        
    }
    
    // Person views an ORDER
    public void view(){}
    
    public Product view(String ID, String x)
    {
        Product viewedProd = null;
        ID = ID.toLowerCase().trim();
        //ArrayList<Product> matchedProduct = search(ID, null);
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> matchedProduct = fileOperator.getProductList();
        for(Product prod : matchedProduct)
        {
            if(prod.getProductID().toLowerCase().equals(ID))
            {
                viewedProd = prod;
            }
        }
        return viewedProd;
    }
    
    // Person searches for an ORDER
    public void search(){}

    public ArrayList<Product> getProductList()
    {
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> productList = fileOperator.getProductList();
        return productList;
    }
    
    public ArrayList<Product> getProductBasedOnType(String productType)
    {
        ArrayList<Product> productTypeList = new ArrayList<Product>();
        FileOperator fileOperator = new FileOperator();
        ArrayList<Product> productList = fileOperator.getProductList();
        for(Product productObject:productList)
        {
            if(productObject.getProductType().equals(productType) && 
                    productObject.getProductStat() == productStatus.SALE)
            {
                productTypeList.add(productObject);
            }
        }
        return productTypeList;
    }
    
    // Override Inbuilt Methods
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.personID, name, username, password, age, contact, email);
    }
    
}
