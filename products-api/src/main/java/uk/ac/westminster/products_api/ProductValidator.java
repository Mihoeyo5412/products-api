package uk.ac.westminster.products_api;

public class ProductValidator {

    public static void checkProduct(Long id){
        if(id > 20){
            //Explicitly throw a runtime exception
            throw new ProductNotFoundException(id);
        }
        System.out.println("Product exists in the inventory");
    }
    public static void main(String[] args){
        try{
            checkProduct(25L);
        } catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
