package com.example.Shop.service.Interface;

import com.example.Shop.model.ProductUser;

import java.util.List;

public interface ProductUserService {
    void createProductUser(ProductUser productUser);
    List<ProductUser> getAlluser();
    void deleteUser(String id);
    void updateUser(ProductUser updatedProductUser, String id);
}
