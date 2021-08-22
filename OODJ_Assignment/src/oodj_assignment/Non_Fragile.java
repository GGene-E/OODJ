
package oodj_assignment;





public class Non_Fragile extends Product{

    private static double packageMulti = 1.06;
    private double basePrice;
    private double netPrice = basePrice * packageMulti;    
    
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
