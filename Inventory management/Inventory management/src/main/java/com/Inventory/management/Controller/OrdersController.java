package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Orders;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders/{admin_id}")
    public List<Orders> fetchData(@PathVariable("admin_id") String admin_id){
        return orderService.fetchData(admin_id);
    }
    @PostMapping("/order/{admin_name}/{costumer_name}/{product_name}")
    public Orders saveOrder(@PathVariable("admin_name") String admin_name
                            ,@PathVariable("costumer_name") String costumer_name,@PathVariable("product_name") String product_name,
                                @RequestBody Orders orders){

         return orderService.saveOrder(admin_name,costumer_name,product_name,orders);
    }
    @PutMapping("/orders/{product_name}/{costumer_name}/{id}")
    public Orders UpdateProductById(@PathVariable("id") Long id,
                                     @PathVariable("product_name") String product_name,
                                     @PathVariable("costumer_name") String costumer_name,
                                     @RequestBody Orders order){
        return orderService.updateOrderByTd(product_name,costumer_name,id,order);
    }
    @DeleteMapping("/api/order/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }
}
