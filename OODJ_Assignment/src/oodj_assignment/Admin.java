
package oodj_assignment;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person implements Serializable{
    
    //Overrides method from Person to add customer
    @Override
    public void add(){
        /*
        File cus_txt = new File("customer.txt");
        PrintWriter output = new PrintWriter(cus_txt);
        */
        
        
    }
    
    //Overrides method from Person to delete customer
    @Override
    public void delete(){}
    
    //Overrides method from Person to edit customer
    @Override
    public void edit(){}
    
    //Overrides method from Person to view customer
    @Override
    public void view(){}
    
    //Overrides method from Person to search customer
    @Override
    public void search(){}

    
    public void checkDuplication(){}
}
