package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductReview")
public class ProductReview {
    @Id
    private String id;
    private String productId;
    private String reviewText;
    private Double rating;

    public ProductReview() {
    }

    public ProductReview(String id, String productId, String reviewText, Double rating) {
        this.id = id;
        this.productId = productId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
