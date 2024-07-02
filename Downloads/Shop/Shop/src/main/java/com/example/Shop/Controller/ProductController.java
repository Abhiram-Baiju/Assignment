package com.example.Shop.Controller;

import com.example.Shop.model.Product;
import com.example.Shop.service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class ProductController {
    @Autowired
    private ProductService ps;

    @PostMapping(path = "product")
    //@ResponseStatus(HttpStatus.CREATED)
        public void CreateProduct(@RequestBody Product product) {
        ps.createProduct(product);
    }

    @GetMapping(path = "/product")
        public List<Product> getAllProduct(){
        return ps.getAllProduct();
  }

    @DeleteMapping(path = "/product/{id}")
        public void deleteProduct(@PathVariable int id){
        ps.deleteProduct(id);
  }

    @PutMapping(path = "/product/{id}")
        public void updateProduct(@RequestBody Product product,@PathVariable int id){
        ps.updateProduct(product,id);
  }
    @GetMapping("/product/{price}")
    public List<Product> getProductByPriceGreaterThan(@PathVariable double price) {
        return ps.getProductByPriceGreaterThan(price);
    }
    @GetMapping("/product/{name}")
    public  List<Product>getProductByName(@PathVariable String name){
        return ps.getProductByname(name);
    }
//    @PatchMapping(path = "/product/{id}")
//    public void updateProductPartial(@PathVariable String id, @RequestBody Map<String, Object> updates) {
//        ps.updateProductPartial(id, updates);
//    }
}

