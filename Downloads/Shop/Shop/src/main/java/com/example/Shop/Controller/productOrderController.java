package com.example.Shop.Controller;

import com.example.Shop.model.ProductOrder;
import com.example.Shop.service.Interface.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productOrderController {
    @Autowired
    private ProductOrderService pOS;

    @PostMapping(path="productOrder")
    public void createProductOrder(@RequestBody ProductOrder productOrder){
        pOS.CreateProductOrder(productOrder);
    }
    @GetMapping(path = "/productOrder")
    public List<ProductOrder>getAllOrder(){
        return pOS.getAllorder();
   }

   @PutMapping(path ="/productOrder/{id}")
   public void updateOrder(@RequestBody ProductOrder productOrder,@PathVariable String id){
        pOS.updateOrder(productOrder,id);
   }

   @DeleteMapping(path = "/productOrder/{id}")
    public void deleteOrder(@PathVariable String id){
        pOS. deleteOrder(id);
    }
    @GetMapping(path = "/productOrder/{userName}")
    public List<ProductOrder> getOrderByUserName(@PathVariable String userName){
       return pOS.getOrderByUserName(userName);
    }


}
