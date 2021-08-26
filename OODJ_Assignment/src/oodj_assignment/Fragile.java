
package oodj_assignment;





public class Fragile extends Product {

    private final static double PACKAGEMULTI = 1.12;
    
    public Fragile(){};
    
    public Fragile(String ID, double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        super(ID, price, type, status, name, description, frag, stock);
    }

    public static double getPACKAGEMULTI() {
        return PACKAGEMULTI;
    }    
}
