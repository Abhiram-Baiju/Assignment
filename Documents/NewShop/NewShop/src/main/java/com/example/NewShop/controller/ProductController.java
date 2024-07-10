//package com.example.NewShop.controller;
//
//import com.example.NewShop.Service.Interface.ProductService;
//import com.example.NewShop.model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createproduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
//        return productService.updateProduct(productId, product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable("id") Long productId) {
//        productService.deleteProduct(productId);
//    }
//
//    @GetMapping
//    public List<Product> getProducts() {
//        return productService.getProducts();
//    }
//}
