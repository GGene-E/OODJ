
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

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
