package com.example.Shopping.model;

public class shop {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public shop(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private  int price;

    public shop() {
    }
}
