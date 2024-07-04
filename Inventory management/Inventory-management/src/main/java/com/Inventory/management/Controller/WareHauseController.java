package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Product;
import com.Inventory.management.Entity.Supplier;
import com.Inventory.management.Entity.WareHouse;
import com.Inventory.management.Service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class WareHauseController {
    @Autowired
    private WareHouseService wareHouseService;
    @PostMapping("/api/wareHouse/{admin_company}")
    public WareHouse saveWareHouse(@PathVariable("admin_company") String admin_company, @RequestBody WareHouse wareHouse){
        return wareHouseService.saveWareHouse(admin_company,wareHouse);
    }
    @GetMapping("/WareHouses/{admin_id}")
    public List<WareHouse> fetchData(@PathVariable("admin_id") String admin_id){
        return wareHouseService.fetchdata(admin_id);
    }
    @PutMapping("/wareHouse/{id}")
    public WareHouse UpdateWareHouseById(@PathVariable("id") Long id,
                                     @RequestBody WareHouse wareHouse){
        return wareHouseService.updateWareHouseById(id,wareHouse);
    }
    @DeleteMapping("/api/wareHouse/{id}")
    public  void deleteWareHouse(@PathVariable("id") Long id){
        wareHouseService.deleteWareHouse(id);
    }

}
