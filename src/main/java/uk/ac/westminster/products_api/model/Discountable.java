package uk.ac.westminster.products_api.model;

public interface Discountable {

    // a contract: no body, no state
    public abstract void applyDiscount(double rate);

}
