package com.example.Shop.service.Interface;

import com.example.Shop.model.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    void CreateProductOrder(ProductOrder productOrder);
    List<ProductOrder> getAllorder();
    void deleteOrder(long id);
    void updateOrder(ProductOrder updatedProductOrder, long id);
    List<ProductOrder> getOrderByUserName(String userName);
}
