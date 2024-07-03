package com.example.Shop.service.Interface;

import com.example.Shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    void deleteProduct(long id);
    void updateProduct(Product updatedProduct, long id);
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductByname(String name);

    void createProduct(Product product);

    List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name);
    List<Product> getProductByPriceGreaterThanAndName(double price, String name);
}
