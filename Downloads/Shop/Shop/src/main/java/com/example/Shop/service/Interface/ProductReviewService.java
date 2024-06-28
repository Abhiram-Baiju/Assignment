package com.example.Shop.service.Interface;

import com.example.Shop.model.ProductReview;

import java.util.List;

public interface ProductReviewService {
    void createProductReview(ProductReview productReview);
    List<ProductReview> getAllProductReview();
    void updateReview(ProductReview updatedProductReview, String id);
    void deleteProductReview(String id);
    List<ProductReview> getRatingLessThan(double rating);
}
