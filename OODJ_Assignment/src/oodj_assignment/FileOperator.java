
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;


public class FileOperator {
    
    
    public void writeFile(String file)
    {
        
    }
    
    public Non_Fragile getProduct(String id) throws FileNotFoundException,IOException,EOFException
    {
        File file = new File("product.txt");
        FileInputStream finput = new FileInputStream(file);
        ObjectInputStream oinput = new ObjectInputStream(finput);
        ArrayList<Non_Fragile> prodList = new ArrayList<Non_Fragile>();
        try 
        { 
            while (true)
            {
                Non_Fragile prod = (Non_Fragile)oinput.readObject();
                prodList.add(prod);
            }
        }
        catch (ClassNotFoundException ex) {
            //Logger.getLogger(Non_Fragile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Non_Fragile p : prodList) 
        {
            if (!p.productID.equals(id))
            {
                continue;
            }
            else 
            {
                return p;
            }
        }
        finput.close();
        oinput.close();
        return null;
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
