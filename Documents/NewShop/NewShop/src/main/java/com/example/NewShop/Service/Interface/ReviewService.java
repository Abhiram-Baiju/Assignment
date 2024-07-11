package com.example.NewShop.Service.Interface;

import com.example.NewShop.model.Review;

import java.util.List;

public interface ReviewService {
        Review createProductReview(Review review);
        List<Review> getProductReviewsByProductId(Long productId);
        Review updateProductReview(Long reviewId, Review updatedReview);
        void deleteProductReview(Long reviewId);
}
