package com.example.Shop.service.Implements;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;
import com.example.Shop.repository.ProductCategoryRepo;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.repository.ShopRepo;
import com.example.Shop.service.Interface.ProductService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private sequenceGeneratorService sg;
    @Autowired
    private ProductReview productReview;
    @Autowired
    private ReviewRepo reviewRepo;


    @Override
    public void createProduct(Product product){
        product.setId(sg.generateSequence(product.SEQUENCE_NAME));
        shopRepo.save(product);
    }

    @Override
    public List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name) {
        return null;
    }

    ;

    @Override
    public List<Product> getAllProduct() {
        return shopRepo.findAll();
    }

    @Override
    public void deleteProduct(long id) {
        shopRepo.deleteById(id);
    }

    @Override
    public void updateProduct(Product updatedProduct, long id) {
        shopRepo.findById(id).map(product -> {
            product.setId(updatedProduct.getId());
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setCategoryId(updatedProduct.getCategoryId());
            product.setQuantity(updatedProduct.getQuantity());
            return shopRepo.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found" + id));
    }

    @Override
    public List<Product> getProductByPriceGreaterThanAndName(double price, String name) {
        return shopRepo.findByPriceGreaterThanAndName(price, name);
    }

    @Override
    public List<Product> getProductByPriceGreaterThan(double price) {
        return shopRepo.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductByname(String name) {
        return shopRepo.findByName(name);
    }



    @Override
    public List<Product> getProductsDetailsWithLowRating(double rating) {
        List<ProductReview> lowRatedReviews = reviewRepo.findByRatingLessThan(rating);
        List<Long> productIds = lowRatedReviews.stream()
                .map(ProductReview::getId)
                .collect(Collectors.toList());

        return shopRepo.findAllByIdIn(productIds);
    }
}
