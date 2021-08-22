
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;


public class FileOperator {
    
    
    public void addProduct()
    {
        File file = new File("PRODUCT.txt");
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String prod = ;
        } 
        catch (IOException Ex)
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
