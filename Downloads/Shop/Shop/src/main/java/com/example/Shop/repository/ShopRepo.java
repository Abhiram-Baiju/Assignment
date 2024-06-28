package com.example.Shop.repository;

import com.example.Shop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShopRepo extends MongoRepository<Product,String> {
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByName(String name);
}
