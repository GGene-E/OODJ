
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
    // Person Registers Customer / Self Registration
    public Boolean add(Customer customerObject)
    {
        //Returns FALSE if there are same username
        FileOperator fileOperator = new FileOperator();
        //Compare for username
        int adminCount = 1;
        ArrayList<Admin> adminList = fileOperator.getAdminList(); // Check for same username in Admin.txt
        for(Admin adminCheck:adminList)
        {
            if(adminCheck.getUsername().equals(customerObject.getUsername())) // There is a match
            {
                return false;
            }
            adminCount = adminCount + 1;
            
        }
        
        int customerCount = 1;
        ArrayList<Customer> customerList = fileOperator.getCustomerList(); // Check for same username in Customer.txt
        for(Customer customerCheck:customerList)
        {
            if(customerCheck.getUsername().equals(customerObject.getUsername())) // There is a match
            {
                return false;
            }
            customerCount = customerCount + 1;
        }
        customerObject.setPersonID("C" + Integer.toString(customerCount));
        
        Boolean status = fileOperator.writeCustomer(customerObject);
        return status;
        
    }
    
    // Person places an ORDER
    public void add(){}
    
    // Person deletes an ORDER
    public void delete(){}
    
    // Person edits an ORDER
    public void edit(){}
    
    // Person views an ORDER
    public void view(){}
    
    // Person searches for an ORDER
    public void search(){}

    
    // Override Inbuilt Methods
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.personID, name, username, password, age, contact, email);
    }
    
}
