package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Costumer;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class CostumerController {
    @Autowired
    private CostumerService costumerService;
    @GetMapping("/costumers/{admin_id}")
    public List<Costumer> fetchData(@PathVariable("admin_id") String admin_id){
        return costumerService.fetchData(admin_id);
    }
    @PostMapping("/costumer/{admin_company}")
    public Costumer saveCostumer(@PathVariable("admin_company")String admin_company ,@RequestBody Costumer costumer){
        return costumerService.saveCostumer(admin_company,costumer);
    }
    @GetMapping("/api/costumer/{name}")
    public Costumer getCostumerByName(@PathVariable("name") String name){
        return costumerService.getCostumerByName(name);
    }
    @PutMapping("/costumer/{id}")
    public Costumer UpdateCostumerById(@PathVariable("id") Long id,
                                     @RequestBody Costumer costumer){
        return costumerService.updateCostumerById(id,costumer);
    }
    @DeleteMapping("/costumer/{id}")
    public void deleteProductWithOrders(@PathVariable("id") Long id){
        costumerService.deleteCostumerWithOrders(id);
    }
}
