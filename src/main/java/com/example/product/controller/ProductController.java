package com.example.product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.product.model.Product;
import com.example.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ProductController {

    @Autowired
    private ProductService pS;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return pS.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return pS.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = pS.getProductById((long) id).orElseThrow();
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product productDetails) {
        return pS.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        pS.deleteProduct((long) id);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductsByPriceGreaterThan(@PathVariable double price) {
        return pS.getProductsByPriceGreaterThan();
    }
}

