package com.example.Shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "ProductReview")

@Component
public class ProductReview {
    @Transient
    public static final String SEQUENCE_NAME = "review_Id";
    @Id
    private long  reviewId;
    private long  id;
    private long   userId;
    private String reviewText;
    private Double rating;

    public ProductReview() {
    }

    public ProductReview( long id, long userId, String reviewText, Double rating) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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