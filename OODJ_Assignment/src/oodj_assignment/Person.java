
package oodj_assignment;

import java.util.ArrayList;

enum PersonType
{
    ADMIN, CUSTOMER;
}

public class Person {
    // Attributes of Person
    // <editor-fold defaultstate="collapsed" desc="Your Fold Comment">
    private String personID; //
    private String name;
    private String username;
    private String password;
    private int age;
    private String contact;
    private String email;
    private PersonType personType;
    // </editor-fold>
    
    // Constructors
    public Person() {}
    
    public Person(String ID, String name, String username, String password, int age, String contact, String email) 
    {
        this.personID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contact = contact;
        this.email = email;
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
    
    public Person(String name, String username, String password, int age, String contact, String email, PersonType personType) 
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contact = contact;
        this.email = email;
        this.personType = personType;
    }
    
    public Person(String ID, String name, String username, String password, int age, String contact, String email, PersonType personType) 
    {
        this.personID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contact = contact;
        this.email = email;
        this.personType = personType;
    }
    
    // Getters
    // <editor-fold defaultstate="collapsed" desc="Your Fold Comment">
    public String getPersonID(){return personID;}
    public String getName(){return name;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public int getAge(){return age;}
    public String getContact(){return contact;}
    public String getEmail(){return email;}
    public PersonType getPersonType() {return personType;}
    // </editor-fold>
    
    // Setters
    // <editor-fold defaultstate="collapsed" desc="Your Fold Comment">
    public void setPersonID(String Id){personID = Id;}
    public void setName(String Nm){name = Nm;}
    public void setUsername(String Un){username = Un;}
    public void setPassword(String Pw){password = Pw;}
    public void setAge(int Ag){age = Ag;}
    public void setContact(String Ct){contact = Ct;}
    public void setEmail(String Em){email = Em;}
    public void setPersonType(PersonType Pt){personType = Pt;}
    // </editor-fold>
    
    // Methods
    // Person Logs Into the System
    public String[] getLoginCredentials(String username, String password)
    {
        String[] matchedDetails = new String[0];
        
        FileOperator fileOperator = new FileOperator();
        ArrayList<String> personList = fileOperator.getPersonList();

        if(!personList.isEmpty()) //Not empty
        {
            for(String personDetail:personList)
            {
                String[] personDetailArray = personDetail.split(",");
                if(personDetailArray[2].equals(username) && personDetailArray[3].equals(password))
                {
                   return matchedDetails = personDetailArray;
                }
            }
        }
        return matchedDetails;
    }
    
    // Person Registers Customer / Self Registration
    public int add(Person personObject) //1 = Saved Successfully | 2 = Duplicate Username | 3 = IOException during Checking | 4 = IOException during Appending | 5 = IOException during Writing
    {
        //In FileOperator, run a comparing function. Returns TRUE if there are same username
        FileOperator fileOperator = new FileOperator();
        int status = fileOperator.writeCustomer(personObject);
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

    @Override
    public String toString()
    {
        String returnedString = String.format("%s,%s,%s,%s,%s,%s,%s,%s", personID, name, username, password, age, contact, email, personType);
        return returnedString;
    }
    
}
