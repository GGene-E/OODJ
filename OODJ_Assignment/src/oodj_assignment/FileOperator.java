
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;


public class FileOperator {
    
    
    public void writeFile(String file)
    {
        
    }
    
    public void writeCustomer(Person personObject)
    {
        //Check For Similarties
        
        //Add Customer
        File personFile = new File("Person.txt");
        if(personFile.exists())
        {
            System.out.println("Yes");
            try(FileWriter fileWriter = new FileWriter(personFile, true))//Try With Resources
            {
                try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
                {
                    try(PrintWriter printWriter = new PrintWriter(bufferedWriter))
                    {
                        //Code
                    }
                }
            }
            catch(IOException ex)
            {
                
            }
        }
        else
        {
            System.out.println("No");
        }
        
    }  
}
