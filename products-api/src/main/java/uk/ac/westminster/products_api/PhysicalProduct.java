package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {

    }

    public PhysicalProduct(Long id, String name, Double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: Name: " + getName() + " | Price: " + getPrice()
                + " | Weight: " + weightKg + " | Dimensions: " + dimensions;
    }

    @Override
    public void applyDiscount(double rate) {
        // shipping is never discounted, so
        // cap the reduction at 20%
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice()* (1 -capped);
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
