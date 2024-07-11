package com.example.NewShop.controller;


import com.example.NewShop.Service.Interface.ProductService;
import com.example.NewShop.dto.ProductDTO;
import com.example.NewShop.dto.SearchDTO;
import com.example.NewShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") long productId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/ratingbelow/{rating}")
    public ResponseEntity<List<ProductDTO>> getProductsBelowRating(@PathVariable("rating") double rating) {
        List<ProductDTO> products = productService.getProductsBelowRating(rating);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> getProductsBySearch(@ModelAttribute SearchDTO searchDTO) {
        List<ProductDTO> products = productService.getProductsBySearch(searchDTO);
        return ResponseEntity.ok(products);
    }
}