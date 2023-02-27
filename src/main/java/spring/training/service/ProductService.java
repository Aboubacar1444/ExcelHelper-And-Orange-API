package spring.training.service;

import spring.training.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;

public interface ProductService {
    public abstract Product Create (Product product);

    public abstract Product Update (Product product, String ref);

    public abstract void Delete (String ref);

    public Product findOneByRef(String ref);

    public abstract Collection<Product> getProducts();
    public abstract Collection<Product> getProductsByPrixGreatherThan(BigDecimal prix);

}
