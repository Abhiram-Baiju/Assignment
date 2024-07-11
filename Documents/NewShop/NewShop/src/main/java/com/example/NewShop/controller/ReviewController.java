package com.example.NewShop.controller;

import com.example.NewShop.Service.Interface.ReviewService;
import com.example.NewShop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> createProductReview(@RequestBody Review review) {
        Review createdReview = reviewService.createProductReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/reviews/{productId}")
    public ResponseEntity<List<Review>> getProductReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getProductReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateProductReview(@PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateProductReview(reviewId, review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteProductReview(@PathVariable Long reviewId) {
        reviewService.deleteProductReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
