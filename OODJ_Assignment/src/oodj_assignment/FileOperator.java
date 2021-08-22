
package oodj_assignment;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class FileOperator {
    
    
    public void writeFile(String file)
    {
        
    }
   
    public int writeCustomer(Person personObject)
    {
        File personFile = new File("Person.txt");
        int idCount = 1; //ID Count will always be ahead by 1 step
        //Check For Similarties
        
        
        
        //Add Customer
        if(personFile.exists()) //File Exists
        {
            //Check for Similarities
            try(Scanner fileScanner = new Scanner(personFile))
            {
                while(fileScanner.hasNextLine())
                {
                    String tempPerson = fileScanner.nextLine();
                    String[] tempPersonDetails = tempPerson.split(",");
                    if(tempPersonDetails[2].equals(personObject.getUsername()))
                    {
                        return 2;
                    }
                    idCount = idCount + 1;
                }
            }
            catch(FileNotFoundException ex)
            {
                return 6;
            }
            //Continue Adding by Appending
            try(FileWriter fileWriter = new FileWriter(personFile, true))//Try With Resources
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        //Code
                        personObject.setPersonID(Integer.toString(idCount));
                        personObject.setPersonType(PersonType.CUSTOMER);
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
            catch(IOException ex)
            {
                return 4;
            }
            return 1;
        }
        else //File does not exists
        {
            try(FileWriter fileWriter = new FileWriter(personFile))//Try With Resources
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        //Code
                        personObject.setPersonID(Integer.toString(idCount));
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
            catch(IOException ex)
            {
                return 5;
            }
            return 1;
        }
        
    } 
    
//    public ArrayList<String> getPersonList()
//    {
//        ArrayList<String> personList = new ArrayList<String>();
//        File personFile = new File("Person.txt");
//        
//        try(Scanner fileScanner = new Scanner(personFile))
//        {
//            while(fileScanner.hasNextLine())
//            {
//                String scannedPerson = fileScanner.nextLine();
//                personList.add(scannedPerson);
//            }
//        }
//        catch (FileNotFoundException ex)
//        {
//            return personList; //Empty List
//        }
//        return personList;
//    }
    
    public ArrayList<Object> getPersonList()
    {
        ArrayList<Object> personList = new ArrayList<Object>();
        File personFile = new File("Person.txt");
        
        try(Scanner fileScanner = new Scanner(personFile))
        {
            while(fileScanner.hasNextLine())
            {
                String scannedPerson = fileScanner.nextLine();
                String[] scannedPersonArray = scannedPerson.split(",");
                if(PersonType.valueOf(scannedPersonArray[7]) == PersonType.ADMIN )
                {
                    Person person = new Person();
                }
                else
                {
                    if(PersonType.valueOf(scannedPersonArray[7]) == PersonType.CUSTOMER)
                    {
                        
                    }
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            return personList; //Empty List
        }
        return personList;
    }
    
    public ArrayList<Customer> getCustomerList()
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        File personFile = new File("Person.txt");
        
        try(Scanner fileScanner = new Scanner(personFile))
        {
            while(fileScanner.hasNextLine())
            {
                String scannedPerson = fileScanner.nextLine();
                String[] personDetails = scannedPerson.split(",");
                if(personDetails[7].equals(PersonType.CUSTOMER.name()))
                {
                    Customer customer = new Customer(personDetails[0], 
                            personDetails[1], personDetails[2], 
                            personDetails[3], Integer.parseInt(personDetails[4]), 
                            personDetails[5], personDetails[6]);
                    customerList.add(customer);
                }
            }
        }
        catch(FileNotFoundException ex)
        {
            return customerList; //Empty List
        }
        return customerList;
    }
}
