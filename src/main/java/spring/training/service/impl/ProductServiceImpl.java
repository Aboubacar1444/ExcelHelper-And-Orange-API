package spring.training.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.training.entity.Product;
import spring.training.repository.ProductRepository;
import spring.training.service.ProductService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public Product Create(Product product) {
       if (findOneByRef(product.getRef()) != null) return null;
       return productRepository.save(product);
    }

    @Override
    public Product Update(Product product, String ref) {
       Optional<Product> p = productRepository.findOneByRef(ref);
        if (p.isEmpty()) return null;
        p.get().setRef(product.getRef());
        p.get().setPrix(product.getPrix());
        p.get().setQuantityStock(product.getQuantityStock());
        Product updated = productRepository.save(p.get());
        return updated;
    }

    @Override
    public void Delete(String ref) {
        Product product = findOneByRef(ref);
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product findOneByRef(String ref) {
        return productRepository.findOneByRef(ref).orElse(null);

    }

    @Override
    public Collection<Product> getProducts() {
      return  productRepository.findAll();
    }

    @Override
    public Collection <Product> getProductsByPrixGreatherThan(BigDecimal prix){
        return productRepository.findProductsByPrixGreaterThan(prix);
    }
}
