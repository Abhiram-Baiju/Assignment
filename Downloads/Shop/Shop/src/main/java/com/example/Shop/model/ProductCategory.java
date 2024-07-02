package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductCategory")

public class ProductCategory {
    @Id
    private String CategoryId;
    private int id;
    private String CategoryName;

    public ProductCategory(String categoryId, int id, String categoryName) {
        CategoryId = categoryId;
        this.id = id;
        CategoryName = categoryName;
    }

    public ProductCategory() {
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}

