package com.example.NewShop.controller;

import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.Service.Impliments.OrderServiceImpl;
import com.example.NewShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping(path = "/Orders")
    public List<Order> getAllOrders() {
        return orderServiceImpl.getAllOrders();
    }

    @GetMapping(path = "/Orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "orderId") Long orderId) {
        Optional<Order> order = orderServiceImpl.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/Orders")
    public Order createOrder(@RequestBody Order order) {
        return orderServiceImpl.createOrder(order);
    }

    @PutMapping(path = "/Orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "orderId") Long orderId, @RequestBody Order orderDetails) {
        try {
            Order updatedOrder = orderServiceImpl.updateOrder(orderId, orderDetails);
            return ResponseEntity.ok(updatedOrder);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/Orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
        try {
            orderServiceImpl.deleteOrder(orderId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
