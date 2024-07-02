package com.example.Shop.service.Interface;

import com.example.Shop.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService{
    void createProduct(Product product);
    List<Product> getAllProduct();
    void deleteProduct(int id);
     void updateProduct(Product updatedProduct, int id);
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductByname(String name);

    //void updateProductPartial(String , Map<String, Object> );
}

