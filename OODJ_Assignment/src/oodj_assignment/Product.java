
package oodj_assignment;

enum productStatus 
{
    SALE, DISCONTINUED;
}

abstract class Product {
    
    //Attributes
    protected static int ID;
    protected String productID;
    protected double productPrice;
    protected String productType;
    protected productStatus productStat;
    protected String name;
    protected String description; 
    protected boolean fragility; 
    protected int stock;
    
    public Product() {} // Default Constructor
    
    public Product(String ID, double price, String type, productStatus status, String name, String description, boolean fragility, int stock)
    {
        productID = ID;
        productPrice = price;
        productType = type;
        productStat = status;
        this.name = name;
        this.description = description;
        this.fragility = fragility;
        this.stock = stock;
    }
    
    //Getters OPTIONAL

    public int getStock() {
        return stock;
    }
    
    public static int getID() {
        return ID;
    }

    public boolean isFragility() {
        return fragility;
    }
    
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
    public static void setID(int ID) {
        Product.ID = ID;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setFragility(boolean fragility) {    
        this.fragility = fragility;
    }

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
