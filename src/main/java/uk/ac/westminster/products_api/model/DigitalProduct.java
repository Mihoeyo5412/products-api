package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {

    private double fileSizeMB;
    private String downloadUrl;
    private double discountedPrice;

    public DigitalProduct(){}

    public DigitalProduct(Long id, String name, double price, double fileSizeMB, String downloadUrl){
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public String getdownloadUrl(){
        return downloadUrl;
    }

    public double getFileSizeMB(){
        return fileSizeMB;
    }

    public void setdownloadUrl(String downloadUrl){
        this.downloadUrl = downloadUrl;
    }

    public void setFileSizeMB(double fileSizeMB){
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public String getSummary(){
        return getName() + " " + getPrice() + " " + getdownloadUrl();
    }

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}