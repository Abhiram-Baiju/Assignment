package com.example.NewShop.Service.Interface;


import com.example.NewShop.dto.ProductDTO;
import com.example.NewShop.dto.SearchDTO;
import com.example.NewShop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(long productId);
    List<Product>getAllProducts();
    Product updateProduct(long ProductId,Product product);
    void deleteProduct(long productId);
    List<ProductDTO> getProductsBelowRating(double ratingThreshold);
    List<ProductDTO> getProductsBySearch(SearchDTO searchDTO);
}
