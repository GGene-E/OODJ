
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class FileOperator {
    
    /*
    public void addProduct(double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        //Product.ID++;

        if (frag == true)
        {
            price = price * Fragile.getPACKAGEMULTI();
            
            Fragile newProd = new Fragile(Integer.toString(Product.ID),price,type,status,name,description,frag,stock);
            File file = new File("PRODUCT.txt");
            try
            {
                
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                String prod = newProd.getProductID() + "," + 
                              newProd.getProductPrice() + "," + 
                              newProd.getProductType() + "," + 
                              newProd.getProductStat() + "," + 
                              newProd.getName() + "," + 
                              newProd.getDescription() + "," + 
                              newProd.isFragility() + "," +
                              newProd.stock;
                
                bw.newLine();
                pw.write(prod);
                pw.close();
                bw.close();
                fw.close();
            } 
            catch (IOException Ex)
            {

            }
        } 
        else 
        {
            price = price * Non_Fragile.getPACKAGEMULTI();
            
            Non_Fragile newProd = new Non_Fragile(Integer.toString(Product.ID),price,type,status,name,description,frag,stock);
            File file = new File("PRODUCT.txt");
            try
            {
                
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                String prod = newProd.getProductID() + "," + 
                              newProd.getProductPrice() + "," + 
                              newProd.getProductType() + "," + 
                              newProd.getProductStat() + "," + 
                              newProd.getName() + "," + 
                              newProd.getDescription() + "," + 
                              newProd.isFragility() + "," +
                              newProd.stock;
                
                bw.newLine();
                pw.write(prod);
                pw.close();
                bw.close();
                fw.close();
            } 
            catch (IOException Ex)
            {

            }    
        }
    }
*/
    

    
    public void addProduct(double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        //Get indexing for ID
        int count = 1;
        ArrayList<Integer> IDList = new ArrayList<>();
        try 
        {
            File file = new File("PRODUCT.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] details = line.split(",");
                IDList.add(Integer.parseInt(details[0].trim()));
            }    
        }
        catch(IOException ex) 
        {
            
        }
        
        String newID = Integer.toString(count + IDList.size());

        // Calculate net price
        double netPrice;
        
        if(frag == true)
        {
            netPrice = price * Fragile.getPACKAGEMULTI();
        }
        else
        {
            netPrice = price * Non_Fragile.getPACKAGEMULTI();            
        }
        
        DecimalFormat df = new DecimalFormat("###.##");
        df.format(netPrice);
        //Add into textfile
        File file = new File("PRODUCT.txt");
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String prod = newID + "," + 
                          df.format(netPrice) + "," + 
                          type + "," + 
                          status + "," + 
                          name + "," + 
                          description + "," + 
                          frag + "," +
                          stock;

            pw.write(prod);
            bw.newLine();                    
            pw.close();
            bw.close();
            fw.close();
            } 
        catch (IOException Ex)
        {

        }
    }
    
    
    

    
    public ArrayList<Product> getProductArray()
    {   
        ArrayList<Product> prodList = new ArrayList<Product>();
        try 
        {
            File file = new File("PRODUCT.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] details = line.split(",");
                //Creates Fragile Object
                if (details[6].equals("true"))
                {
                    double price = Double.parseDouble(details[1]);
                    productStatus stat = productStatus.valueOf(details[4]);
                    boolean  frag = Boolean.parseBoolean(details[6]);
                    int stock = Integer.parseInt(details[7]);
                    
                    Fragile prod = new Fragile(details[0],price,details[2],stat,details[4],details[5],frag,stock);
                    prodList.add(prod);
                } 
                //Creates Non-Fragile Object
                else
                {
                    double price = Double.parseDouble(details[1]);
                    productStatus stat = productStatus.valueOf(details[4]);
                    boolean  frag = Boolean.parseBoolean(details[6]);
                    int stock = Integer.parseInt(details[7]);
                    
                    Non_Fragile prod = new Non_Fragile(details[0],price,details[2],stat,details[4],details[5],frag,stock);
                    prodList.add(prod);                    
                }
                
            } 
            
        }
        catch(IOException ex) 
        {
            
        }
        return prodList;
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
