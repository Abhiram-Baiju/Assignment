package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductReview")
public class ProductReview {
    @Id
    private Product id;
    private Product name;
    private ProductCategory categoryId;
    private ProductCategory CategoryName;
    private String reviewText;
    private Double rating;

    public ProductReview() {
    }

    public ProductReview(Product id, Product name, ProductCategory categoryId, ProductCategory categoryName, String reviewText, Double rating) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        CategoryName = categoryName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Product getId() {
        return id;
    }

    public void setId(Product id) {
        this.id = id;
    }

    public Product getName() {
        return name;
    }

    public void setName(Product name) {
        this.name = name;
    }

    public ProductCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ProductCategory categoryId) {
        this.categoryId = categoryId;
    }

    public ProductCategory getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(ProductCategory categoryName) {
        CategoryName = categoryName;
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