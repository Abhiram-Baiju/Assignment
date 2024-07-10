package com.example.Shop.Controller;

import com.example.Shop.Dto.ProductDetailsDTO;
import com.example.Shop.Dto.SearchProductDTO;
import com.example.Shop.model.Product;
import com.example.Shop.service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService ps;

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        ps.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return ps.getAllProduct();
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable long productId) {
        ps.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@RequestBody Product product, @PathVariable long productId) {
        ps.updateProduct(product, productId);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Double minPrice) {
        SearchProductDTO searchProductDTO = new SearchProductDTO();
        searchProductDTO.setName(name);
        searchProductDTO.setMinPrice(minPrice);
        return ps.searchProducts(searchProductDTO);
    }}

//
//http://localhost:8081/product/search?name=Keyboard
//        http://localhost:8081/product/search
//        http://localhost:8081/product/search?minPrice=500
