
package oodj_assignment;

enum productStatus 
{
    SALE, DISCONTINUED;
}




abstract class Product {
    
    //Attributes
    protected String productID;
    protected double productPrice;
    protected String productType;
    protected productStatus productStat;
    protected String name;
    protected String description; 
    
    //Getters
    public String getProductID() {
        return productID;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public productStatus getProductStat() {
        return productStat;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    //Setters
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductStat(productStatus productStat) {
        this.productStat = productStat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //Methods
    public abstract String provideDetail();
    public abstract double calcPackPrice();
    public abstract double calcGrandTotal();
}
