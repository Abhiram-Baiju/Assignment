package com.example.NewShop.dto;


import com.example.NewShop.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
//    private String reviewText;
//    private Double rating;
    private String categoryName;
    private String name;
    private List<Review> review;//new line
}
