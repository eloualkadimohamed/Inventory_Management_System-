package com.Inventory.management.Service;

import com.Inventory.management.Entity.Costumer;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private AdminRepository adminRepository;
    public List<Costumer> fetchData(String admin_id) {
        return costumerRepository.getCostumerWithAdminIdNativeNamedParam(admin_id);
    }

    public Costumer saveCostumer(String admin_company,Costumer costumer) {
        costumer.setAdmin_id(adminRepository.getAdminByCompany(admin_company));
        return costumerRepository.save(costumer);
    }

    public Costumer getCostumerByName(String name) {
        return costumerRepository.getCostumerByName(name);
    }
    public Costumer updateCostumerById(Long id, Costumer costumer) {
        Costumer DB= costumerRepository.findById(id).get();
        if (Objects.nonNull(costumer.getName()) &&
                !"".equalsIgnoreCase(costumer.getName())){
            DB.setName(costumer.getName());
        }
        if (Objects.nonNull(costumer.getAddress()) &&
                !"".equalsIgnoreCase(costumer.getAddress())){
            DB.setAddress(costumer.getAddress());
        }
        if (Objects.nonNull(costumer.getEmail())){
            DB.setEmail(costumer.getEmail());
        }
        if (Objects.nonNull(costumer.getPhone()) &&
                !"".equalsIgnoreCase(costumer.getPhone())){
            DB.setPhone(costumer.getPhone());
        }
        if (Objects.nonNull(costumer.getLoyalty())){
            DB.setLoyalty(costumer.getLoyalty());
        }
        return costumerRepository.save(DB);
    }

    public void deleteCostumerWithOrders(Long id) {
         costumerRepository.deleteById(id);
    }
}
