
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;


public class FileOperator extends ObjectOutputStream{
    
    public FileOperator(OutputStream output) throws IOException //Run this to Append
    {
        super(output);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException
    {
        reset();
    }
    
    public void addProduct()
    {
        File file = new File("product.txt");
        FileOutputStream foutput = new FileOutputStream(file, true);
        //ObjectOutputStream ooutput = new ObjectOutputStream(foutput);
    }
    
    public Product getProduct(String id) throws FileNotFoundException,IOException,EOFException
    {
        // Open File and deserialize input 
        File file = new File("product.txt");
        FileInputStream finput = new FileInputStream(file);
        ObjectInputStream oinput = new ObjectInputStream(finput);
        
        ArrayList<Product> prodList = new ArrayList<>();
        try 
        { 
            while (true)
            {
                Product prod = (Product)oinput.readObject();
                prodList.add(prod);
            }
        }
        catch (ClassNotFoundException ex) { /*ADD EXCEPTION*/ }
        
        finput.close();
        oinput.close();

        for (Product p : prodList) 
        {
            if (p.productID.equals(id) && p instanceof Non_Fragile)
            {
                p = (Non_Fragile) p;
                return p;
                    
            }
            if (p.productID.equals(id) && p instanceof Fragile)
            {
                p = (Fragile) p;
                return p;
            }
            else
            {
                continue;
            }
        }
        System.out.println("Error getting Product, No such ID");
        return null;
    }        
        
    public Boolean writeCustomers(Customer customerObject)
    {
        if(compareSimilarities(customerObject) == true)//JONATHAN - Update compareSimilarities
        {
            return false; //There are similarities
        }
        
        File personFile = new File("person.txt");
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(personFile);
            try
            {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(customerObject);
            }
            catch(IOException ex)
            {
                
            }
        }
        catch(FileNotFoundException ex)
        {
            
        }
        
        
        return true;
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
