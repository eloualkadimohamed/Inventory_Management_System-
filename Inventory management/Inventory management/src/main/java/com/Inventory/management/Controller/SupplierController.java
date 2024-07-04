package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Category;
import com.Inventory.management.Entity.Supplier;
import com.Inventory.management.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
   @GetMapping("/suppliers/{admin_id}")
    public List<Supplier> fetchData(@PathVariable("admin_id") String admin_id){
       return supplierService.fetchdata(admin_id);
   }
   @PostMapping("/api/supplier/{admin_company}")
    public Supplier saveSupplier(@PathVariable("admin_company") String admin_company,@RequestBody Supplier supplier){
       return supplierService.saveSupplier(admin_company,supplier);
   }
   @GetMapping("/api/supplier/{name}")
    public Supplier getSupplierByName(@PathVariable("name") String name){
       return supplierService.getSupplierByName(name);
   }
    @PutMapping("/supplier/{id}")
    public Supplier UpdateSupplierById(@PathVariable("id") Long id, @RequestBody Supplier supplier){
        return supplierService.updateSupplierByTd(id,supplier);
    }
    @DeleteMapping("/supplier/{id}")
    public void deleteSupplier(@PathVariable("id") Long id){
        supplierService.deleteSupplier(id);
    }
}
