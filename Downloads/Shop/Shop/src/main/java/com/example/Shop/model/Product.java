package com.example.Shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "id";
    @Id
    private int id;
    private String name;
    private double price;
    private String categoryIid;
    private double quantity;

    public Product(int id, String name, double price, String categoryIid, double quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryIid = categoryIid;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCategoryIid() {
        return categoryIid;
    }

    public void setCategoryIid(String categoryIid) {
        this.categoryIid = categoryIid;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}