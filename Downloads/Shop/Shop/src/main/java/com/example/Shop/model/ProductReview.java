package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "Review")
@Component
public class ProductReview {
    @Transient
    public static final String SEQUENCE_NAME = "review_Id";
    @Id
    private long  reviewId;
    private long productId;
    private long   userId;
    private String reviewText;
    private Double rating;

    public ProductReview() {
    }

    public ProductReview(long productId, long userId, String reviewText, Double rating) {
        this.productId = productId;
        this.userId = userId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}