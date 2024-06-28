package com.example.Shop.repository;

import com.example.Shop.model.ProductOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends MongoRepository<ProductOrder,String> {

    List<ProductOrder> findByUserName(String userName);
}
