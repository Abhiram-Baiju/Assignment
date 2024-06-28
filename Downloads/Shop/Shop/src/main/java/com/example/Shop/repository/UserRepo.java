package com.example.Shop.repository;

import com.example.Shop.model.ProductUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<ProductUser,String> {
}
