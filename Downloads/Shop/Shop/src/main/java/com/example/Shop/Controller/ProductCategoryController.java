package com.example.Shop.Controller;

import com.example.Shop.model.ProductCategory;
import com.example.Shop.service.Interface.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductCategoryController {
    @Autowired
    private ProductCategoryService pcs;

    @PostMapping(path = "productCategory")
    public void CreateProductCategory(@RequestBody ProductCategory productCategory){
        pcs.CreateaProductCategory(productCategory);
    }

    @GetMapping(path = "/productCategory")
    public List<ProductCategory> getAllCategory()
    {
        return pcs.getAllcategory();
    }

    @PutMapping("/productCategory/{id}")
    public void updateProductCateory(@RequestBody ProductCategory productCategory,@PathVariable String id){
        pcs.updateProductCategory(productCategory,id);
    }

    @DeleteMapping(path = "productCategory/{id}")
    public void deleteProductCategory(@PathVariable String id){
        pcs.deleteProductCategory(id);
    }


}
