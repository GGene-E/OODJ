
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.time.LocalDate;


public class FileOperator {

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
    
    public ArrayList<Product> getProductList()
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
                    productStatus stat = productStatus.valueOf(details[3]);
                    boolean  frag = Boolean.parseBoolean(details[6]);
                    int stock = Integer.parseInt(details[7]);
                    
                    Fragile prod = new Fragile(details[0],price,details[2],stat,details[4],details[5],frag,stock);
                    prodList.add(prod);
                } 
                //Creates Non-Fragile Object
                else
                {
                    double price = Double.parseDouble(details[1]);
                    productStatus stat = productStatus.valueOf(details[3]);
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
    
    public ArrayList<Admin> getAdminList() // Returns a list of admin objects
    {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        
        File adminFile = new File("ADMIN.txt");
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
        
        File customerFile = new File("CUSTOMER.txt");
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
    
    public ArrayList<Order> getOrderList() // Returns a list of order objects
    {
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        File orderFile = new File("ORDER.txt");
        try(Scanner orderScanner = new Scanner(orderFile))
        {
            while(orderScanner.hasNextLine())
            {
                String tempOrder = orderScanner.nextLine();
                String[] tempOrderArray = tempOrder.split(",");
                Order tempOrderObject = new Order(tempOrderArray[0], tempOrderArray[1], OrderStatus.valueOf(tempOrderArray[2]),
                        Double.parseDouble(tempOrderArray[3]), tempOrderArray[4], tempOrderArray[5], LocalDate.parse(tempOrderArray[6]));
                orderList.add(tempOrderObject);
            }
        }
        catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Order database is not found. Please contact an admin or file a report.");
        }
        return orderList;
    }
    
    public Boolean writeOrder(Order orderObject) // Write One Order Object
    {
        Boolean status = false; // False = writing/appending failed.
        File orderFile = new File("ORDER.txt");
        if(orderFile.exists()) // Order.txt exists
        {
            try(FileWriter fileWriter = new FileWriter(orderFile, true))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(orderObject.toString());
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
        else // Order.txt has not been created
        {
            JOptionPane.showMessageDialog(null, "Order database not found. Creating a new database.");
            try(FileWriter fileWriter = new FileWriter(orderFile))
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        printWriter.write(orderObject.toString());
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
        return status;
    }
    
    public Boolean writeAdmin(Admin adminObject) // Write One Admin Object
    {
        Boolean status = false; // False = writing/appending failed.
        File adminFile = new File("ADMIN.txt");
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
        Boolean status = false; // False = writing/appending failed.
        File customerFile = new File("CUSTOMER.txt");
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
    
    public Boolean overwriteCustomer(ArrayList<Customer> customerList)
    {
        Boolean status = false;
        File customerFile = new File("CUSTOMER.txt");
        try(FileWriter fileWriter = new FileWriter(customerFile))
        {
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
            {
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                {
                    for(Customer customerObject:customerList)
                    {
                        printWriter.write(customerObject.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
            status = true;
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while writing to Customer database.");
        }
        return status;
    }
    
    public Boolean overwriteProduct(ArrayList<Product> prodList)
    {
        Boolean status = false;
        File file = new File("PRODUCT.txt");
        try(FileWriter fileWriter = new FileWriter(file))
        {
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
            {
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                {
                    for(Product productObject : prodList)
                    {
                        String prod = productObject.getProductID() + "," + 
                        productObject.getProductPrice() + "," + 
                        productObject.getProductType() + "," + 
                        productObject.getProductStat() + "," + 
                        productObject.getName() + "," + 
                        productObject.getDescription() + "," + 
                        productObject.isFragility() + "," +
                        productObject.getStock();
                        
                        printWriter.write(prod);
                        bufferedWriter.newLine();
                    }
                }
            }
            status = true;
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Unexpected IOException encountered while writing to Product database.");
        }
        return status;
    }
    
    public ArrayList<Product> deleteProductList(Product Prod) //Returns a list excluding the specified product
    {
        ArrayList<Product> prodRemoved = new ArrayList<>();
        try
        {
            File file = new File("PRODUCT.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] details = line.split(",");
                if(!details[0].toLowerCase().equals(Prod.getProductID().toLowerCase()))
                {
                    if (details[6].equals("true"))
                    {
                        double price = Double.parseDouble(details[1]);
                        productStatus stat = productStatus.valueOf(details[3]);
                        boolean frag = Boolean.parseBoolean(details[6]);
                        int stock = Integer.parseInt(details[7]);

                        Fragile prod = new Fragile(details[0],price,details[2],stat,details[4],details[5],frag,stock);
                        prodRemoved.add(prod);
                    } 
                    //Creates Non-Fragile Object
                    else
                    {
                        double price = Double.parseDouble(details[1]);
                        productStatus stat = productStatus.valueOf(details[3]);
                        boolean  frag = Boolean.parseBoolean(details[6]);
                        int stock = Integer.parseInt(details[7]);

                        Non_Fragile prod = new Non_Fragile(details[0],price,details[2],stat,details[4],details[5],frag,stock);
                        prodRemoved.add(prod);                    
                    }
                }

            }
        }
        catch(IOException ex)
        {
            
        }
        return prodRemoved;
    }
}