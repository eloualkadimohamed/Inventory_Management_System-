package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/api/products/{admin_id}")
    public List<Product> fetchData(@PathVariable("admin_id") String admin_id){
        return productService.fetchData(admin_id);
    }
    @PostMapping("/product/{admin_company}/{supplier_name}/{wareHouse_name}/{category_name}")
    public Product saveproduct(@PathVariable("admin_company") String admin_company,@PathVariable("supplier_name") String supplier_name,
                               @PathVariable("wareHouse_name") String wareHouse_name,@PathVariable("category_name") String category_name,
                               @RequestBody Product product){
        return productService.saveProduct(admin_company,supplier_name,wareHouse_name,category_name,product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProductWithOrders(@PathVariable("id") Long id){
         productService.deleteProductWithOrders(id);
    }
    @PutMapping("/products/{supplier_name}/{wareHouse_name}/{category_name}/{id}")
    public Product UpdateProductById(@PathVariable("id") Long id,
                                     @PathVariable("supplier_name") String supplier_name,
                                     @PathVariable("wareHouse_name") String wareHouse_name,@PathVariable("category_name") String category_name,
                                     @RequestBody Product product){
        return productService.updateProductByTd(supplier_name,wareHouse_name,category_name,id,product);
    }
    @PutMapping("/products/{name}")
    public Product UpdateProductQuantity(@PathVariable("name") String name,
                                     @RequestBody Product product){
        return productService.updateProductQuantity(name,product);
    }
    @GetMapping("/api/product/{name}")
    private Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

}
