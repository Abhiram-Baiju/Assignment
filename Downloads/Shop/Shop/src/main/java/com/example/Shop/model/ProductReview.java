package com.example.Shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ProductReview")
public class ProductReview {
    @Transient
    public static final String SEQUENCE_NAME = "review_Id";
    @Id
    private long  reviewId;
    private String reviewText;
    private Double rating;
    private long userId;

}