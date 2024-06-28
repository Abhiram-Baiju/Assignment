package com.example.Shop.service.Interface;

import com.example.Shop.model.Product;

import java.util.List;

public interface ProductService{
    void createProduct(Product product);
    List<Product> getAllProduct();
    void deleteProduct(String id);
    void updateProduct(Product updatedProduct, String id);
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductByname(String name);
}

