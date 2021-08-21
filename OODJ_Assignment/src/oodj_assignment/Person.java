
package oodj_assignment;

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
    
    // Getters
    public String getPersonID(){return personID;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getContact(){return contact;}
    public String getEmail(){return email;}
    public PersonType getPersonType() {return personType;}
    
    // Setters
    public void setPersonID(String Id){personID = Id;}
    public void setName(String Nm){name = Nm;}
    public void setAge(int Ag){age = Ag;}
    public void setContact(String Ct){contact = Ct;}
    public void setEmail(String Em){email = Em;}
    public void setPersonType(PersonType Pt){personType = Pt;}

    // Methods
    // Person Registers Customer / Self Registration
    public Boolean add(Person a)
    {
        //In FileOperator, run a comparing function. Returns TRUE if there are same username
        return true;
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

    
}
