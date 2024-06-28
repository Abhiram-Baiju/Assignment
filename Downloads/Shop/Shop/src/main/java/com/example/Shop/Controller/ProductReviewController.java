package com.example.Shop.Controller;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;
import com.example.Shop.service.Interface.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductReviewController {
    @Autowired
    private ProductReviewService prs;

    @PostMapping(path = "productReview")
    public void createProductReview(@RequestBody ProductReview productReview) {
        prs.createProductReview(productReview);
    }

    @GetMapping(path = "/productReview")
    public List<ProductReview> getAllProductReview() {
        return prs.getAllProductReview();
    }

    @DeleteMapping(path = "/productReview/{id}")
    public void deleteProductReview(@PathVariable String id) {
        prs.deleteProductReview(id);
    }

    @PutMapping(path = "/productReview/{id}")
    public void updateReview(@RequestBody ProductReview productReview, @PathVariable String id) {
        prs.updateReview(productReview, id);
    }

    @GetMapping("/productReview/{rating}")
    public List<ProductReview>getRatingLessThan(@PathVariable double rating){
        return prs.getRatingLessThan(rating);
    }
}
