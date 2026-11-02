package uk.ac.westminster.products_api;

// Line 1: A PhysicalProduct IS-A Product because it extends Product and inherits its fields/behavior.
// Line 2: An Invoice or ShoppingCart would NOT pass this test, because a ShoppingCart is a collection
// of products, not a product itself (it fails the "is-a" relationship test).
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions){
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary(){
        return getName() + " " + getPrice() + " " + getWeightKg();
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}