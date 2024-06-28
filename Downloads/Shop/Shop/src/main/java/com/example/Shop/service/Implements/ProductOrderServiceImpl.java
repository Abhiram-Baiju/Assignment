package com.example.Shop.service.Implements;

import com.example.Shop.model.ProductOrder;
import com.example.Shop.repository.OrderRepo;
import com.example.Shop.service.Interface.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private OrderRepo orderRepo;

    public void CreateProductOrder(ProductOrder productOrder) {
        orderRepo.save(productOrder);
    }

    public List<ProductOrder> getAllorder() {
        return orderRepo.findAll();
    }

    public void deleteOrder(String id) {
        orderRepo.deleteById(id);
    }


    public void updateOrder(ProductOrder updatedProductOrder, String id) {
        orderRepo.findById(id).map(productOrder -> {
            productOrder.setuserName(updatedProductOrder.getUserName());
            productOrder.setOrderDate(updatedProductOrder.getOrderDate());
            productOrder.setStatus(updatedProductOrder.getStatus());
            productOrder.setTotalAmount(updatedProductOrder.getTotalAmount());
            return orderRepo.save(productOrder);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }


    public List<ProductOrder> getOrderByUserName(String userName) {
        return orderRepo.findByUserName(userName);
    }
}
