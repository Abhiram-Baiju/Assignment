package com.example.Shop.Controller;

import com.example.Shop.model.Order;
import com.example.Shop.service.Interface.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productOrderController {
    @Autowired
    private ProductOrderService pOS;

    @PostMapping(path="productOrder")
    public void createProductOrder(@RequestBody Order order){
        pOS.CreateProductOrder(order);
    }
    @GetMapping(path = "/productOrder")
    public List<Order>getAllOrder(){
        return pOS.getAllOrder();
   }

//   @PutMapping(path ="/productOrder/{id}")
//   public void updateOrder(@RequestBody ProductOrder productOrder,@PathVariable String id){
//        pOS.updateOrder(productOrder,id);
//   }

   @DeleteMapping(path = "/productOrder/{id}")
    public void deleteOrder(@PathVariable long id){
        pOS. deleteOrder(id);
    }

    @GetMapping(path ="/productOrder/{userId}")
    public List<Order> getOrderByUserId(@PathVariable long userId){
       return pOS.getOrderByUserId(userId);
    }

}
