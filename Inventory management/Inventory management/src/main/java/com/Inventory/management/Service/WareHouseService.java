package com.Inventory.management.Service;

import com.Inventory.management.Entity.Product;
import com.Inventory.management.Entity.WareHouse;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WareHouseService {
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private AdminRepository adminRepository;
    public WareHouse saveWareHouse(String adminCompany,WareHouse wareHouse) {
        wareHouse.setAdmin_id(adminRepository.getAdminByCompany(adminCompany));
        return wareHouseRepository.save(wareHouse);
    }

    public List<WareHouse> fetchdata(String adminId) {
        return wareHouseRepository.getWareHouseWithAdminIdNativeNamedParam(adminId);
    }
    public WareHouse updateWareHouseById( Long id, WareHouse wareHouse) {
        WareHouse DB= wareHouseRepository.findById(id).get();
        if (Objects.nonNull(wareHouse.getName()) &&
                !"".equalsIgnoreCase(wareHouse.getName())){
            DB.setName(wareHouse.getName());
        }
        if (Objects.nonNull(wareHouse.getAddress()) &&
                !"".equalsIgnoreCase(wareHouse.getAddress())){
            DB.setAddress(wareHouse.getAddress());
        }
        if (Objects.nonNull(wareHouse.getStatus()) &&
                !"".equalsIgnoreCase(wareHouse.getStatus())){
            DB.setStatus(wareHouse.getStatus());
        }
        if (Objects.nonNull(wareHouse.getLocation()) &&
                !"".equalsIgnoreCase(wareHouse.getLocation())){
            DB.setLocation(wareHouse.getLocation());
        }
        return wareHouseRepository.save(DB);
    }

    public void deleteWareHouse(Long id) {
        wareHouseRepository.deleteById(id);
    }
}
