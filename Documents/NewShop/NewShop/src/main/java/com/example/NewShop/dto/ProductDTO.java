package com.example.NewShop.dto;


import com.example.NewShop.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
//    private String reviewText;
//    private Double rating;
    private String productName;
    private String categoryName;
    private Double avgRating;
//    private String name;
  //  private Long averageRating;//new line
    private List<Review> review;


//    public ProductDTO(long id, String name, String categoryName, double averageRating, List<Review> reviews) {
//    }
}
