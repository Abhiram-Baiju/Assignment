package com.example.NewShop.Service.Impliments;



import com.example.NewShop.Service.Interface.ProductService;
import com.example.NewShop.dto.ProductDTO;
import com.example.NewShop.dto.SearchDTO;
import com.example.NewShop.model.Product;
import com.example.NewShop.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
@Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(long productId) {
        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(long ProductId, Product product) {
        Product existingProduct = productRepo.findById(ProductId).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductCategory(product.getProductCategory());
        //existingProduct.setReviews(product.getReviews());
        return productRepo.save(existingProduct);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepo.deleteById(productId);

    }
    @Override
    public List<ProductDTO> getProductsBelowRating(double ratingThreshold) {
        return productRepo.findAll().stream()
                .flatMap(product -> product.getReviews().stream()
                        .filter(review -> review.getRating() < ratingThreshold)
                        .map(review -> new ProductDTO(
                                product.getId(),
                                review.getReviewText(),
                                review.getRating(),
                                product.getProductCategory().getCategoryName()
                        )))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsBySearch(SearchDTO searchDTO) {
        return productRepo.findByNameContainingAndPriceGreaterThan(
                        searchDTO.getName(), searchDTO.getPrice())
                .stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getProductCategory().getCategoryName()
                ))
                .collect(Collectors.toList());
    }


}
