package com.example.Shop.repository;

import com.example.Shop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepo extends MongoRepository<Product,String> {
}
