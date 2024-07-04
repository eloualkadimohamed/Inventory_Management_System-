package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employee/{admin_company}")
    public Employee saveproduct(@PathVariable("admin_company") String admin_company,@RequestBody Employee employee){
        return employeeService.saveEmployee(admin_company,employee);
    }
    @GetMapping("/employees/{admin_id}")
    public List<Employee> fetchdata(@PathVariable("admin_id") String admin_id){
        return employeeService.fetchdata(admin_id);
    }
    @GetMapping("/Employee/login/{email}/{password}")
    public Employee login(@PathVariable("email") String email, @PathVariable("password") String password){
        return employeeService.login(email,password);
    }
    @PutMapping("/api/employee/{email}")
    public Employee resetPassword(@PathVariable("email") String email
            ,@RequestBody Employee employee){
        return employeeService.restPassword(email,employee);
    }
    @PutMapping("/employee/{id}")
    public Employee UpdateEmployeeById(@PathVariable("id") Long id,
                                     @RequestBody Employee employee){
        return employeeService.updateEmployeeByTd(id,employee);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
