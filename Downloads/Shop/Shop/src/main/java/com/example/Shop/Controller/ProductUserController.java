package com.example.Shop.Controller;

import com.example.Shop.model.ProductUser;
import com.example.Shop.service.Interface.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductUserController {
@Autowired
    private ProductUserService productUserService;
    @PostMapping(path = "productUser")
      public void createProductUser(@RequestBody ProductUser productUser){
          productUserService. createProductUser(productUser);
        }

    @GetMapping(path = "/productUser")
     public List<ProductUser>getAllUser(){
        return productUserService.getAlluser();
    }

    @DeleteMapping(path = "/productUser/{id}")
     public void deleteUser(@PathVariable String id){
    productUserService.deleteUser(id);
  }

    @PutMapping(path = "/productUser/{id}")
     public void updateUser(@RequestBody ProductUser productUser,@PathVariable String id){
         productUserService.updateUser(productUser,id);
  }
}

