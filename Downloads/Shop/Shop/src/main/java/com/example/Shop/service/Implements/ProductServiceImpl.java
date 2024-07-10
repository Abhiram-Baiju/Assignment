package com.example.Shop.service.Implements;

import com.example.Shop.Dto.ProductDetailsDTO;
import com.example.Shop.Dto.ReviewDTO;
import com.example.Shop.model.Product;
import com.example.Shop.model.ProductCategory;
import com.example.Shop.model.ProductReview;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.repository.ShopRepo;
import com.example.Shop.service.Interface.ProductService;
//import com.example.Shop.service.Interface.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl<SequenceGeneratorService> implements ProductService {

    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void createProduct(Product product) {
      //  product.setProductId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        shopRepo.save(product);
    }

    @Override
    public List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name) {
        return shopRepo.findByPriceGreaterThanAndName(minPrice, name);
    }

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
    public List<ProductDetailsDTO> getProductsDetailsWithLowRating(double ratingThreshold) {
        List<Product> products = shopRepo.findAll();
        for (Product product : products) {
            product.setCategory(fetchCategoryById(product.getCategoryId()));
            product.setReviews(fetchReviewsByProductId(product.getProductId()));
        }

        // Filter products based on rating and map to DTOs
        return products.stream()
                .filter(product -> product.getReviews().stream()
                        .mapToDouble(review -> review.getRating() != null ? review.getRating() : 0)
                        .average()
                        .orElse(0) < ratingThreshold)
                .map(this::mapToProductDetailsDTO)
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

    private ProductDetailsDTO mapToProductDetailsDTO(Product product) {
        ProductDetailsDTO dto = new ProductDetailsDTO();
        dto.setProductId(product.getProductId());
        dto.setName(product.getName());
        dto.setCategoryId(product.getCategoryId());

        List<ReviewDTO> reviewDTOs = product.getReviews().stream()
                .map(this::mapToReviewDTO)
                .collect(Collectors.toList());
        dto.setReviews(reviewDTOs);

        return dto;
    }

    private ReviewDTO mapToReviewDTO(ProductReview review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getReviewId());
        dto.setReviewText(review.getReviewText());
        dto.setRating(review.getRating());
        return dto;
    }
}
