package com.example.NewShop.controller;

//import com.example.NewShop.Exception.InvalidTotalAmountException;
import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.Service.Impliments.OrderServiceImpl;
import com.example.NewShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping(path = "/orders")
    public List<Order> getAllOrders() {
        return orderServiceImpl.getAllOrders();
    }

    @GetMapping(path = "/orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "orderId") Long orderId) {
        Optional<Order> order = orderServiceImpl.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderServiceImpl.createOrder(order);
    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//        // Validate total amount
//        try {
//            double totalAmount = Double.parseDouble(order.getTotalAmount());
//            // Process order creation
//            Order createdOrder = orderServiceImpl.createOrder(order);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
//        } catch (NumberFormatException e) {
//            throw new InvalidTotalAmountException("Total amount must be a valid number.");
//        }
//    }



    @PutMapping(path = "/orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "orderId") Long orderId, @RequestBody Order orderDetails) {
        try {
            Order updatedOrder = orderServiceImpl.updateOrder(orderId, orderDetails);
            return ResponseEntity.ok(updatedOrder);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
        try {
            orderServiceImpl.deleteOrder(orderId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
