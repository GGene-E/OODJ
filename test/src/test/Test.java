
package test;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("Filetest.txt");
        
        Scanner Sc = new Scanner(System.in);
        int ch = Sc.nextInt();

        switch (ch) {
            case 1:
                ArrayList<String> sentence = new ArrayList<String>();
                sentence.add("How are you?");
                sentence.add("I'm fine, thank you.");
                FileOutputStream fo = new FileOutputStream(file);
                ObjectOutputStream output = new ObjectOutputStream(fo);
                for (String s : sentence){
                    output.writeObject(s);
                }   output.close();
                fo.close();
                break;
            case 2:
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream input = new ObjectInputStream(fi);
                ArrayList<String> sentence2 = new ArrayList<String>();
                try {
                    while (true){
                        String s = (String) input.readObject();
                        sentence2.add(s);
                    }
                } catch (EOFException ex) {}
                for (String s : sentence2)
                {
                    System.out.println(s);
                }   break;
            case 3:
                ArrayList<String> addsentence = new ArrayList<String>();
                addsentence.add("Are you sure?");
                addsentence.add("Yes, absolutely.");
                FileOutputStream file_o = new FileOutputStream(file);
                ObjectOutputStream object_o = new ObjectOutputStream(file_o);
                for (String s : addsentence){
                    object_o.writeObject(s);
                }   
                object_o.close();
                file_o.close();
                
                break;
            default:
                break;
        }
    }
    
}
