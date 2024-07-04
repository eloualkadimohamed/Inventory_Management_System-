package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import com.Inventory.management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/admin")
    public List<Admin> fetchData(){
        return adminService.fechData();
    }
    @GetMapping("/ActiveAdmin")
    public Admin getActiveAdmin(){
        return adminService.getActiveAdmin();
    }
    @PostMapping("/admin")
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
    @GetMapping("/Admin/login/{email}/{password}")
        public Admin login(@PathVariable("email") String email,@PathVariable("password") String password){
            return adminService.login(email,password);
            }
    @PutMapping("/api/admin/{email}")
    public Admin resetPassword(@PathVariable("email") String email
            , @RequestBody Admin admin){
        return adminService.restPassword(email,admin);
    }
    @PutMapping("/api/adminActive/{email}")
    public Admin updateActive(@PathVariable("email") String email
            , @RequestBody Admin admin){
        return adminService.updateActive(email,admin);
    }

}
