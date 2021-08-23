
package oodj_assignment;





public class Non_Fragile extends Product{

    private final static double PACKAGEMULTI = 1.06;    
    private double basePrice;
    private double netPrice = basePrice * PACKAGEMULTI;    
    
    public Non_Fragile() {};
    
    public Non_Fragile(String ID, double price, String type, productStatus status, String name, String description, boolean frag, int stock)
    {
        super(ID, price, type, status, name, description, frag, stock);
    }
    
    public static double getPACKAGEMULTI() {
        return PACKAGEMULTI;
    }
    
    @Override
    public String provideDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
