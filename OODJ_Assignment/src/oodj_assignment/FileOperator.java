
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileOperator {
    
    
    public void writeFile(String file)
    {
        
    }

    
    
    
    // Concerning Admin and Customers Data Retrieval
    public Boolean writePersonToAdmin(Person personObject) // Same implementation as writeAdmin() but writes Person Object instead
    {
        Boolean status = false; // False = writing/appending failed.
        File adminFile = new File("Admin.txt");
        if(adminFile.exists()) // Admin.txt exists
        {
            try(FileWriter fileWriter = new FileWriter(adminFile, true))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while appending to Admin database");
            }
        }
        else // Admin.txt has not been created
        {
            JOptionPane.showMessageDialog(null, "Admin database not found. Creating a new database.");
            try(FileWriter fileWriter = new FileWriter(adminFile))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while creating and writing to Admin database.");
            }
        }
        return status;
    }
    
    public Boolean writePersonToCustomer(Person personObject) // Sample implementation as writeCustomer() but writes Person Object instead
    {
        Boolean status = false; // False = writing/appending failed.
        File customerFile = new File("Customer.txt");
        if(customerFile.exists()) // Customer.txt exists
        {
            try(FileWriter fileWriter = new FileWriter(customerFile, true))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while appending to Customer database");
            }
        }
        else // Customer.txt has not been created
        {
            JOptionPane.showMessageDialog(null, "Customer database not found. Creating a new database.");
            try(FileWriter fileWriter = new FileWriter(customerFile))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(personObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while creating and writing to Customer database.");
            }
        }
        return status;
    }
    
    public ArrayList<Admin> getAdminList() // Returns a list of admin objects
    {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        
        File adminFile = new File("Admin.txt");
        try(Scanner adminScanner = new Scanner(adminFile))
        {
            while(adminScanner.hasNextLine())
            {
                String tempAdmin = adminScanner.nextLine();
                String[] tempAdminArray = tempAdmin.split(",");
                Admin tempAdminObject = new Admin(tempAdminArray[0], tempAdminArray[1], tempAdminArray[2],
                    tempAdminArray[3], Integer.parseInt(tempAdminArray[4]), tempAdminArray[5], tempAdminArray[6]);
                adminList.add(tempAdminObject);
            }
        }
        catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Admin database is not found. Please contact an admin or file a report.");
        }
        return adminList;
    }
    
    public ArrayList<Customer> getCustomerList() // Returns a list of customer objects
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        
        File customerFile = new File("Customer.txt");
        try(Scanner customerScanner = new Scanner(customerFile))
        {
            while(customerScanner.hasNextLine())
            {
                String tempCustomer = customerScanner.nextLine();
                String[] tempCustomerArray = tempCustomer.split(",");
                Customer tempCustomerObject = new Customer(tempCustomerArray[0], tempCustomerArray[1], tempCustomerArray[2],
                    tempCustomerArray[3], Integer.parseInt(tempCustomerArray[4]), tempCustomerArray[5], tempCustomerArray[6]);
                customerList.add(tempCustomerObject);
            }
        }
        catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Customer database is not found. Please contact an admin or file a report.");
        }
        return customerList;
    }
    
    public Boolean writeAdmin(Admin adminObject) // Write One Admin Object
    {
        Boolean status = false; // False = writing/appending failed.
        File adminFile = new File("Admin.txt");
        if(adminFile.exists()) // Admin.txt exists
        {
            try(FileWriter fileWriter = new FileWriter(adminFile, true))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(adminObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while appending to Admin database");
            }
        }
        else // Admin.txt has not been created
        {
            JOptionPane.showMessageDialog(null, "Admin database not found. Creating a new database.");
            try(FileWriter fileWriter = new FileWriter(adminFile))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(adminObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while creating and writing to Admin database.");
            }
        }
        return status;
    }

    public Boolean writeCustomer(Customer customerObject) // Write One Customer Object
    {
        Boolean status = null; // False = writing/appending failed.
        File customerFile = new File("Customer.txt");
        if(customerFile.exists()) // Customer.txt exists
        {
            try(FileWriter fileWriter = new FileWriter(customerFile, true))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(customerObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while appending to Customer database");
            }
        }
        else // Customer.txt has not been created
        {
            JOptionPane.showMessageDialog(null, "Customer database not found. Creating a new database.");
            try(FileWriter fileWriter = new FileWriter(customerFile))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(customerObject.toString());
                        bufferedWriter.newLine();
                        status = true;
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while creating and writing to Customer database.");
            }
        }
        return status;
    }
}
