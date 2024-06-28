package com.example.Shop.repository;

import com.example.Shop.model.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepo extends MongoRepository<ProductReview,String> {
    List<ProductReview> findByRatingLessThan(double rating);
}
