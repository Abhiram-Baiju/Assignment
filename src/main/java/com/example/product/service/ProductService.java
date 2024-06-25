package com.example.product.service;

import com.example.product.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.product.model.Product;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ShopRepo sr;
    private List<Product> productList = new ArrayList<>();

    private AtomicLong counter = new AtomicLong();

    public Product createProduct(Product product) {
        long id = counter.incrementAndGet();
        product.setId(id);
        sr.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return sr.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return sr.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails) {
        return sr.findById(id).map(productList -> {
            productList.setName(productDetails.getName());
            productList.setPrice(productDetails.getPrice());
            return sr.save(productList);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void deleteProduct(Long id) {
        sr.deleteById(id);
    }

    public List<Product> getProductsByPriceGreaterThan() {
        double price=500;
        return sr.findByPriceGreaterThan(price);
    }
}
