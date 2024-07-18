package com.example.NewShop.Service.Interface;

import com.example.NewShop.dto.ProductRatingDTO;
import com.example.NewShop.dto.ReviewDTO;
import com.example.NewShop.model.Review;

import java.util.List;

public interface ReviewService {
//        Review createProductReview(Review review);
        List<Review> getProductReviewsByProductId(Long productId);
        Review updateProductReview(Long reviewId, Review updatedReview);
        void deleteProductReview(Long reviewId);
        ProductRatingDTO getAverageRatingByProductId(Long productId);
     Review createProductReview(Review review);  //new change

    //Review createReview(ReviewDTO reviewDTO);//new line
}
