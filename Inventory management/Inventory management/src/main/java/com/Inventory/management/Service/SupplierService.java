package com.Inventory.management.Service;

import com.Inventory.management.Entity.Category;
import com.Inventory.management.Entity.Supplier;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private AdminRepository adminRepository;
    public List<Supplier> fetchdata(String admin_id) {
        return supplierRepository.getSupplierWithAdminIdNativeNamedParam(admin_id);
    }

    public Supplier saveSupplier(String admin_company,Supplier supplier) {
        supplier.setAdmin_id(adminRepository.getAdminByCompany(admin_company));
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplierByName(String name) {
        return supplierRepository.getSupplierByName(name);
    }
    public Supplier updateSupplierByTd(Long id, Supplier supplier) {
        Supplier DB= supplierRepository.findById(id).get();
        if (Objects.nonNull(supplier.getName()) &&
                !"".equalsIgnoreCase(supplier.getName())){
            DB.setName(supplier.getName());
        }
        if (Objects.nonNull(supplier.getEmail()) &&
                !"".equalsIgnoreCase(supplier.getEmail())){
            DB.setEmail(supplier.getEmail());
        }
        if (Objects.nonNull(supplier.getPhone()) &&
                !"".equalsIgnoreCase(supplier.getPhone())){
            DB.setPhone(supplier.getPhone());
        }
        if (Objects.nonNull(supplier.getCode()) &&
                !"".equalsIgnoreCase(supplier.getCode())){
            DB.setCode(supplier.getCode());
        }
        return supplierRepository.save(DB);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

}
