package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {

    private String downloadUrl;
    private double fileSize;
    private double discountedPrice;

    public DigitalProduct() {

    }

    public DigitalProduct(Long id, String name, Double price
            , String downloadUrl, double fileSize) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getSummary() {
        return "Digital: Name: " + getName()
                + " | Price: " + getPrice()
                + " | Url: " + downloadUrl + " | File Size: " + fileSize;
    }

    @Override
    public void applyDiscount(double rate) {
        // no shipping: full rate applies
        discountedPrice = getPrice() * (1 -rate);
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
