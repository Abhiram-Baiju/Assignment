package com.example.NewShop.controller;

import com.example.NewShop.Service.Interface.ProductCategoryService;
import com.example.NewShop.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productCategories")

public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
        return ResponseEntity.ok(productCategoryService.createProductCategory((ProductCategory) productCategory));
    }

    @GetMapping("/productCategories/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable("id") long categoryId) {
        return ResponseEntity.ok(productCategoryService.getProductCategoryById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        return ResponseEntity.ok(productCategoryService.getAllProductCategories());
    }

    @PutMapping("/productCategories/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable("id") long categoryId, @RequestBody ProductCategory productCategory) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(categoryId, productCategory));
    }

    @DeleteMapping("/productCategories/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable("id") long categoryId) {
        productCategoryService.deleteProductCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}
