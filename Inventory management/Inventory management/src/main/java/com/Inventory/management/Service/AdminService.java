package com.Inventory.management.Service;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import com.Inventory.management.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> fechData() {
        return adminRepository.findAll();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin login(String email,String password) {
        return adminRepository.findByEmailAndPassword(email,password);
    }
    public Admin restPassword(String email, Admin admin) {
        Admin DB= adminRepository.findByEmail(email);
        if (Objects.nonNull(admin.getPassword()) &&
                !"".equalsIgnoreCase(admin.getPassword())){
            DB.setPassword(admin.getPassword());
        }
        return adminRepository.save(DB);


    }

    public Admin updateActive(String email, Admin admin) {
        Admin DB= adminRepository.findByEmail(email);
        if (Objects.nonNull(admin.getActive()) &&
                !"".equalsIgnoreCase(admin.getActive())){
            DB.setActive(admin.getActive());
        }
        return adminRepository.save(DB);
    }

    public Admin getActiveAdmin() {
        return adminRepository.getActiveAdmin();
    }
}
