package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextId++, "E-book", 9.99, "/dl/1", 4.2));
        products.add(new PhysicalProduct(nextId++, "Monitor", 249.99, 5.4, "60x40"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        if (product instanceof DigitalProduct) {
            ((DigitalProduct) product).applyDiscount(0.15);
        } else if (product instanceof PhysicalProduct) {
            ((PhysicalProduct) product).applyDiscount(0.10);
        }
        product.setId(nextId);
        nextId++;
        products.add(product);
        return product;
    }

    public String deleteProductById(Long id) {
        boolean isDeleted = products.removeIf(p -> p.getId().equals(id));
        if (isDeleted) {
            return "Deleted !!";
        } else {
            return "Product with given id is not found";
        }
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName()
                        .contains(name)).toList();
    }

    public List<String> getAllSummaries() {
        // Option 1
//        List<String> summaries = new ArrayList<>();
//        for (Product product : products) {
//            String summary = product.getSummary();
//            summaries.add(summary);
//        }
//        return summaries;

        // Option 2
        return products.stream().map(p -> p.getSummary()).toList();
    }

}
