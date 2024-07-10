
package com.example.Shop.service.Interface;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void deleteProduct(long productId);
    void updateProduct(Product updatedProduct, long productId);
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductByname(String name);
    void createProduct(Product product);
    List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name);
    List<Product> getProductByPriceGreaterThanAndName(double price, String name);
    List<Product> getProductsDetailsWithLowRating(double rating);
}
