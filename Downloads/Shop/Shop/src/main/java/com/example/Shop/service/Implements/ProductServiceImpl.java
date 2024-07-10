
package com.example.Shop.service.Implements;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductCategory;
import com.example.Shop.model.ProductReview;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.repository.ShopRepo;
import com.example.Shop.service.Interface.ProductService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Query;
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
    @Autowired
    private MongoOperations mongoOperations;


    @Override
    public void createProduct(Product product){
        product.setProductId(sg.generateSequence(product.SEQUENCE_NAME));
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
    public void deleteProduct(long productId) {
        shopRepo.deleteById(productId);
    }

    @Override
    public void updateProduct(Product updatedProduct, long id) {
        shopRepo.findById(id).map(product -> {
            product.setProductId(updatedProduct.getProductId());
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


    public List<Product> getProductsDetailsWithLowRating(double ratingThreshold) {
        List<Product> products = shopRepo.findAll();
        for (Product product : products) {
            product.setCategory(fetchCategoryById(product.getCategoryId()));
            product.setReviews(fetchReviewsByProductId(product.getProductId()));
        }

        // Filter products based on rating
        return products.stream()
                .filter(product -> product.getReviews().stream()
                        .mapToDouble(review -> review.getRating() != null ? review.getRating() : 0)
                        .average()
                        .orElse(0) < ratingThreshold)
                .collect(Collectors.toList());
    }

    private ProductCategory fetchCategoryById(long categoryId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categoryId").is(categoryId));
        return mongoOperations.findOne(query, ProductCategory.class);
    }

    private List<ProductReview> fetchReviewsByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.find(query, ProductReview.class);
    }
}

