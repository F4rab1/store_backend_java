package com.farabi.store.services;

import com.farabi.store.entities.Product;
import com.farabi.store.repositories.CategoryRepository;
import com.farabi.store.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createProduct() {
        var category = categoryRepository.findById((byte)1).orElseThrow();

        var product = Product.builder()
                .name("Product 3")
                .description("Product 32")
                .price(BigDecimal.valueOf(200.00))
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct() {
        productRepository.deleteById(4L);
    }

    public void derivedQueryExample() {
        var product = productRepository.findByName("Product 2");
        System.out.println(product);
    }
}
