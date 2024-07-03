package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "product_id";
    @Id
    private long id;
    private String name;
    private double price;
    private long categoryId;
    private double quantity;

    public Product() {
    }

    public Product( String name, double price, long categoryId, double quantity) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}