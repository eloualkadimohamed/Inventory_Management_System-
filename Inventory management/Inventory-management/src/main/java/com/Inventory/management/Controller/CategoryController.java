package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Category;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category/{admin_company}")
    public Category saveCategory(@PathVariable("admin_company") String admin_company,@RequestBody Category category){
        return categoryService.saveCategory(admin_company,category);
    }
    @GetMapping("/categories/{admin_id}")
    public List<Category> fetchData(@PathVariable("admin_id") String admin_id){
        return categoryService.fetchData(admin_id);
    }
    @GetMapping("/api/category/{name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        return categoryService.getCategoryByName(name);
    }
    @PutMapping("/category/{id}")
    public Category UpdateProductById(@PathVariable("id") Long id,@RequestBody Category category){
        return categoryService.updateCategoryByTd(id,category);
    }
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

}
