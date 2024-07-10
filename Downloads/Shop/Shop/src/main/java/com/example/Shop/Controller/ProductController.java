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

    @DeleteMapping(path = "/{productId}")
    public void deleteProduct(@PathVariable long productId) {
        ps.deleteProduct(productId);
    }

    @PutMapping(path = "/{ProductId}")
    public void updateProduct(@RequestBody Product product, @PathVariable long productId) {
        ps.updateProduct(product, productId);
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

//    @GetMapping("/product/rating")
//    public List<Product> getLowRatedProducts(@RequestParam(name = "rating", defaultValue = "2") double rating) {
//        return ps.getProductsDetailsWithLowRating(rating);
//    }

//    @GetMapping("/low-rated")
//    public List<Product> getLowRatedProducts(@RequestParam(name = "rating", defaultValue = "2") double rating) {
//        return ps.getProductsDetailsWithLowRating(rating);
//    }
@GetMapping("/low-rated")
public List<Product> getLowRatedProducts(@RequestParam(name = "rating", defaultValue = "2") double rating) {
    return ps.getProductsDetailsWithLowRating(rating);
}
}