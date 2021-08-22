
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileOperator {
    
    
    public void addProduct(double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        Product.ID++;

        if (frag == true)
        {
            Fragile tempProd = new Fragile();
            price = price * tempProd.getPACKAGEMULTI();
            
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
            Non_Fragile tempProd = new Non_Fragile();
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


    
    public void addProduct2(double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        double netPrice;
        
        if(frag == true)
        {
            netPrice = price * Fragile.getPACKAGEMULTI();
        }
        else
        {
            netPrice = price * Non_Fragile.getPACKAGEMULTI();            
        }
        
        File file = new File("PRODUCT.txt");
        try
        {
            Product.ID++;
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String prod = Product.ID + "," + 
                          netPrice + "," + 
                          type + "," + 
                          status + "," + 
                          name + "," + 
                          description + "," + 
                          frag + "," +
                          stock;
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
    
    
    
    
    
    
    
    
    
    
    
    
    public void listProduct()
    {
        try 
        {
            ArrayList<Product> prodList = new ArrayList<Product>();
            File file = new File("PRODUCT.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] details = line.split(",");
                if (details[6].equals("true"))
                {
                    Fragile prod = new Fragile(details[0],details[1],details[2],details[3],details[4],details[5],details[6]);
                }        
            }    
        }
        catch(IOException ex) 
        {
            
        }
    }
 
    
    public Boolean compareSimilarities(Person personObject)
    {
        if(personObject.getUsername().equals("A"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
