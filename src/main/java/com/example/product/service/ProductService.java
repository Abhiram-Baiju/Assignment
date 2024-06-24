package com.example.product.service;

import org.springframework.stereotype.Service;
import com.example.product.model.Product;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public Product createProduct(Product product) {
        long id = counter.incrementAndGet();
        product.setId(id);
        productList.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    public Optional<Product> getProductById(Long id) {
        return productList.stream().filter(product -> product.getId()==(id)).findFirst();
    }

    public Product updateProduct(Long id, Product productDetails) {
        for (Product product : productList) {
            if (product.getId()==(id)) {
                product.setName(productDetails.getName());
                product.setPrice(productDetails.getPrice());
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productList.removeIf(product -> product.getId()==(id));
    }

    public List<Product> getProductsByPriceGreaterThan(double price) {
        return productList.stream()
                .filter(product -> product.getPrice() > price)
                .collect(Collectors.toList());
    }
}
