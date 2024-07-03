package com.example.Shop.service.Implements;

import com.example.Shop.model.ProductReview;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.service.Interface.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductReviewImpl implements ProductReviewService {
    @Autowired
    private ReviewRepo reviewRepo;


    public void createProductReview(ProductReview productReview) {
        reviewRepo.save(productReview);
    }

    public List<ProductReview> getAllProductReview() {
        return reviewRepo.findAll();
    }

    public void updateReview(ProductReview updatedProductReview, long id) {
        reviewRepo.findById(id).map(productReview -> {
            productReview.setReviewText(updatedProductReview.getReviewText());
            productReview.setRating(updatedProductReview.getRating());
            return reviewRepo.save(productReview);
        }).orElseThrow(() -> new RuntimeException("ProductReview not found with id " + id));}


    public void deleteProductReview(long id) {
        reviewRepo.deleteById(id);
    }

    public List<ProductReview> getRatingLessThan(double rating) {
        return reviewRepo.findByRatingLessThan(rating);
    }
}
