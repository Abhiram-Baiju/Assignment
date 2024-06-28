package com.example.Shop.Controller;

import com.example.Shop.model.Product;
import com.example.Shop.service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        public void deleteProduct(@PathVariable String id){
        ps.deleteProduct(id);
  }

    @PutMapping(path = "/product/{id}")
        public void updateProduct(@RequestBody Product product,@PathVariable String id){
        ps.updateProduct(product,id);
  }
    @GetMapping("/productAbove/{price}")
    public List<Product> getProductByPriceGreaterThan(@PathVariable double price) {
        return ps.getProductByPriceGreaterThan(price);
    }
    @GetMapping("/productName/{name}")
    public  List<Product>getProductByName(@PathVariable String name){
        return ps.getProductByname(name);
    }
}
