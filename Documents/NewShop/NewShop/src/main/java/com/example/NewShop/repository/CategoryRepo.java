package com.example.NewShop.repository;

import com.example.NewShop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<ProductCategory,Long> {
}
