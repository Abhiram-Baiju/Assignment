package com.example.Shop.Controller;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;
import com.example.Shop.service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService ps;

    @PostMapping(path = "product")
    public void createProduct(@RequestBody Product product) {
        ps.createProduct(product);
    }

    @GetMapping(path = "/product")
    public List<Product> getAllProduct() {
        return ps.getAllProduct();
    }

    @DeleteMapping(path = "/product/{id}")
    public void deleteProduct(@PathVariable long id) {
        ps.deleteProduct(id);
    }

    @PutMapping(path = "/product/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable long id) {
        ps.updateProduct(product, id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Double minPrice) {
        if (name != null && minPrice != null) {
            return ps.getProductByPriceGreaterThanAndName(minPrice, name);
        } else if (name != null) {
            return ps.getProductByname(name);
        } else if (minPrice != null) {
            return ps.getProductByPriceGreaterThan(minPrice);
        } else {
            return ps.getAllProduct();
        }
    }
    //get product by rating
    @GetMapping("/product/rating")
    public List<ProductReview> getLowRatedProducts(@RequestParam (name = "rating", defaultValue = "2.0")double rating) {
        return ps.getProductsWithLowRating(rating);
    }
}
