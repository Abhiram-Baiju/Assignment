package com.example.NewShop.controller;

import com.example.NewShop.Service.Interface.ReviewService;
import com.example.NewShop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/reviews")
@Validated
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createProductReview(@Valid @RequestBody Review review) {
        Review createdReview = reviewService.createProductReview(review);
        return ResponseEntity.ok(createdReview);
    }



    @GetMapping(path = "/reviews/{id}")
    public ResponseEntity<List<Review>> getProductReviewsByProductId(@PathVariable Long id) {
        List<Review> reviews = reviewService.getProductReviewsByProductId(id);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping(path = "/reviews/{reviewId}")
    public ResponseEntity<Review> updateProductReview(@PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateProductReview(reviewId, review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping(path = "/reviews/{reviewId}")
    public ResponseEntity<Void> deleteProductReview(@PathVariable Long reviewId) {
        reviewService.deleteProductReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
