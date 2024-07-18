package com.example.NewShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductReview")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private long reviewId;

    @NotNull(message = "rating cannot be empty")
    @NotEmpty(message = "rating cannot be empty")
    private Double rating;

    @NotNull(message = "orderId cannot be empty")
    @NotEmpty(message = "order ID cannot be empty")
    @Size(max = 10, message = "Review text must not exceed 10 characters")
    private String reviewText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

    @NotNull(message = "userName cannot be empty")
    @NotEmpty(message = "userName cannot be empty")
    private String userName;


//    //new line
//    public Review(Double rating, String reviewText, String userName, Product product) {
//    }
}
