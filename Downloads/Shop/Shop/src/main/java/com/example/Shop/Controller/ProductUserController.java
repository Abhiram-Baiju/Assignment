package com.example.Shop.Controller;

import com.example.Shop.model.User;
import com.example.Shop.service.Interface.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductUserController {
@Autowired
private ProductUserService productUserService;

    @PostMapping(path ="productUser")
         public void createProductUser(@RequestBody User user){
        productUserService. createProductUser(user);
        }

    @GetMapping(path ="/productUser")
        public List<User>getAllUser(){
        return productUserService.getAllUser();
    }

    @DeleteMapping(path = "/productUser/{id}")
        public void deleteUser(@PathVariable long id){
    productUserService.deleteUser(id);
  }

    @PutMapping(path = "/productUser/{id}")
        public void updateUser(@RequestBody User user, @PathVariable long id){
            productUserService.updateUser(user,id);}
}

