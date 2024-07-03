package com.example.Shop.service.Implements;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductCategory;
import com.example.Shop.repository.ProductCategoryRepo;
import com.example.Shop.service.Interface.ProductCategoryService;
import com.example.Shop.service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo categoryRepo;
    @Override
    public void CreateaProductCategory(ProductCategory productCategory) {
        categoryRepo.save(productCategory);
    }
    @Override
    public List<ProductCategory> getAllcategory() {
        return categoryRepo.findAll();
    }
    @Override
    public void deleteProductCategory(long id) {
        categoryRepo.deleteById(id);
    }
    @Override
    public void updateProductCategory(ProductCategory updateProductCategory,long id) {
        categoryRepo.findById(id).map(productCategory -> {
            productCategory.setCategoryId(updateProductCategory.getCategoryId());
            productCategory.setCategoryName(updateProductCategory.getCategoryName());
            return categoryRepo.save(productCategory);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }
}
