package spring.training.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.training.entity.Product;
import spring.training.service.ProductService;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

   @Autowired
   ProductService productService;

   @GetMapping("/")
   public Collection<Product> getProducts(){
        return productService.getProducts();
   }

   @PostMapping("/")
   public Product createProduct (@Validated @RequestBody Product product){
        return productService.Create(product);
   }

   @PutMapping("/ref/{ref}")
   public Product updateProduct (@Validated @RequestBody Product product, @PathVariable String ref){
       return productService.Update(product, ref);
   }

   @DeleteMapping("/ref/{ref}")
   public void deleteProduct (@PathVariable String ref){
       productService.Delete(ref);
   }

   @GetMapping("/ref/{ref}")
   public Product findOneByRef(@PathVariable String ref){
       return productService.findOneByRef(ref);
   }

   @GetMapping("/gt/{prix}")
   public Collection <Product> findByPrixGreatherThan(@PathVariable BigDecimal prix){
       return productService.getProductsByPrixGreatherThan(prix);
   }


}
