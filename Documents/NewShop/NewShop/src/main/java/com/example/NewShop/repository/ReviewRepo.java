package com.example.NewShop.repository;

import com.example.NewShop.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<ProductReview,Long> {
}
