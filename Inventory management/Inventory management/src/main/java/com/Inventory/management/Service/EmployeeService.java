package com.Inventory.management.Service;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AdminRepository adminRepository;
    public Employee saveEmployee(String admin_company,Employee employee) {
        employee.setAdmin_id(adminRepository.getAdminByCompany(admin_company));
        return employeeRepository.save(employee);
    }

    public List<Employee> fetchdata(String adminId) {
        return employeeRepository.getEmployeeWithAdminIdNativeNamedParam(adminId);
    }

    public Employee login(String email, String password) {
        return employeeRepository.getEmployeeByEmailAndPassword(email,password);
    }

    public Employee restPassword(String email,Employee employee) {
        Employee DB= employeeRepository.findByEmail(email);
        if (Objects.nonNull(employee.getPassword()) &&
                !"".equalsIgnoreCase(employee.getPassword())){
            DB.setPassword(employee.getPassword());
        }
        return employeeRepository.save(DB);
    }
    public Employee updateEmployeeByTd(Long id, Employee employee) {
        Employee DB= employeeRepository.findById(id).get();
        if (Objects.nonNull(employee.getName()) &&
                !"".equalsIgnoreCase(employee.getName())){
            DB.setName(employee.getName());
        }
        if (Objects.nonNull(employee.getPassword()) &&
                !"".equalsIgnoreCase(employee.getPassword())){
            DB.setPassword(employee.getPassword());
        }
        if (Objects.nonNull(employee.getAddress())){
            DB.setAddress(employee.getAddress());
        }
        if (Objects.nonNull(employee.getEmail()) &&
                !"".equalsIgnoreCase(employee.getEmail())){
            DB.setEmail(employee.getEmail());
        }
        if (Objects.nonNull(employee.getAvailability())){
            DB.setAvailability(employee.getAvailability());
        }
        if (Objects.nonNull(employee.getSeniority())){
            DB.setSeniority(employee.getSeniority());
        }


        return employeeRepository.save(DB);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
