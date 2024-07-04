package com.Inventory.management.Service;

import com.Inventory.management.Entity.Category;
import com.Inventory.management.Entity.Orders;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private ProductRepository productRepository;
    public List<Orders> fetchData(String admin_id) {
        return orderRepository.getOrderWithAdminIdNativeNamedParam(admin_id);
    }

    public Orders saveOrder(String adminName,String costumerName,String productName,Orders orders) {
        orders.setAdmin_id(adminRepository.getAdminByCompany(adminName));
        orders.setCostumer_id(costumerRepository.getCostumerByName(costumerName));
        orders.setProduct_id(productRepository.getProductByName(productName));
         return orderRepository.save(orders);
    }
    @Transactional
    public Orders updateOrderByTd(String productName, String costumerName, Long id, Orders orders) {
        Orders DB= orderRepository.findById(id).get();
        if (Objects.nonNull(orders.getCode()) &&
                !"".equalsIgnoreCase(orders.getCode())){
            DB.setCode(orders.getCode());
        }
        if (Objects.nonNull(orders.getDate())){
            DB.setDate(orders.getDate());
        }
        if (Objects.nonNull(orders.getStatus()) &&
                !"".equalsIgnoreCase(orders.getStatus())){
            DB.setStatus(orders.getStatus());
        }
        if (Objects.nonNull(orders.getTotalPrice()) &&
                !"".equalsIgnoreCase(orders.getTotalPrice())){
            DB.setTotalPrice(orders.getTotalPrice());
        }
        if (Objects.nonNull(orders.getQuantity())) {
            DB.setQuantity(orders.getQuantity());
        }
            DB.setProduct_id(productRepository.getProductByName(productName));


            DB.setCostumer_id(costumerRepository.getCostumerByName(costumerName));


        return orderRepository.save(DB);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
