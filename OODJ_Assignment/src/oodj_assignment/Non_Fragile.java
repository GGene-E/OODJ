
package oodj_assignment;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Non_Fragile extends Product{

    //Static variable for packaging multiplier
    private static double packageMulti = 1.06;
    private double basePrice;
    private double netPrice = basePrice * packageMulti;
    
    //Constructor for Non_Fragile
    public Non_Fragile(String ID, double price, String type, productStatus status, String name, String description)
    {
        super(ID, price, type, status, name, description);
    }
    
    @Override
    public String provideDetail() throws FileNotFoundException,IOException,EOFException{
        return "A";
    }

    @Override
    public double calcPackPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcGrandTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
