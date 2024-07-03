package com.example.Shop.service.Implements;

import com.example.Shop.model.ProductUser;
import com.example.Shop.repository.UserRepo;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductUserService implements com.example.Shop.service.Interface.ProductUserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private sequenceGeneratorService sg;

    public void createProductUser(ProductUser productUser) {
        productUser.setUserId(sg.generateSequence(productUser.SEQUENCE_NAME));
        userRepo.save(productUser);
    }

    public List<ProductUser> getAlluser() {
        return userRepo.findAll();
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    public void updateUser(ProductUser updatedProductUser, long id) {
        userRepo.findById(id).map(productUser -> {
            productUser.setUserId(updatedProductUser.getUserId());
            productUser.setName(updatedProductUser.getName());
            productUser.setEmail(updatedProductUser.getEmail());
            productUser.setPassword(updatedProductUser.getPassword());
            productUser.setAddress(updatedProductUser.getAddress());
            productUser.setPhoneNumber(updatedProductUser.getPhoneNumber());
            return userRepo.save(productUser);
        }).orElseThrow(() -> new RuntimeException("ProductUser not found with id " + id));
    }
}
