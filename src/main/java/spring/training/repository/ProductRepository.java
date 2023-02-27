package spring.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.training.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    Optional<Product> findOneByRef(String ref);
    Collection<Product> findProductsByPrixGreaterThan(BigDecimal prix);

    void deleteByRef(String ref);
}
