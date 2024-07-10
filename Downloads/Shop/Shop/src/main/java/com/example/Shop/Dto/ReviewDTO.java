package com.example.Shop.Dto;

public class ReviewDTO {
    private long reviewId;
    private String reviewText;
    private double rating;

    // Getters and Setters

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
    }
}
