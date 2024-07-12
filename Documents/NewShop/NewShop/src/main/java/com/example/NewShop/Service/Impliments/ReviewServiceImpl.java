package com.example.NewShop.Service.Impliments;

import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.Service.Interface.ReviewService;
import com.example.NewShop.model.Review;
import com.example.NewShop.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

//    @Override
//    public Review createProductReview(Review review) {
//        return reviewRepo.save(review);
//    }

    @Override
    public Review createProductReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public List<Review> getProductReviewsByProductId(Long productId) {
        return reviewRepo.findByProduct_Id(productId);
    }

    @Override
    public Review updateProductReview(Long reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepo.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setUserId(updatedReview.getUserId());
            existingReview.setReviewText(updatedReview.getReviewText());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setProduct(updatedReview.getProduct());
            return reviewRepo.save(existingReview);
        } else {
            throw new ResourceNotFoundException("Review not found with id " + reviewId);
        }
    }

    @Override
    public void deleteProductReview(Long reviewId) {
        reviewRepo.deleteById(reviewId);
    }

}
