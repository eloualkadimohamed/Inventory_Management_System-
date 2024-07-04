package com.Inventory.management.Service;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private OrderRepository orderRepository;
    public List<Product> fetchData(String admin_id) {
        return productRepository.getProductWithAdminIdNativeNamedParam(admin_id);
    }

    public Product saveProduct(String adminCompany,String supplierName,String wareHouseName,String categoryName,Product product) {
        product.setAdmin_id(adminRepository.getAdminByCompany(adminCompany));
        product.setSupplier_id(supplierRepository.getSupplierByName(supplierName));
        product.setWareHouse_id(wareHouseRepository.getWareHouseByName(wareHouseName));
        product.setCategory_id(categoryRepository.getCategoryByName(categoryName));
        return productRepository.save(product);
    }
    @Modifying
    @Transactional
    public void deleteProductWithOrders(Long id) {
         orderRepository.deleteOrderByProductId(id);
         productRepository.deleteById(id);
    }

    public Product updateProductByTd(String supplierName,String wareHouseName,String categoryName,Long id, Product product) {
        Product DB= productRepository.findById(id).get();
        if (Objects.nonNull(product.getName()) &&
                !"".equalsIgnoreCase(product.getName())){
            DB.setName(product.getName());
        }
        if (Objects.nonNull(product.getCode()) &&
                !"".equalsIgnoreCase(product.getCode())){
            DB.setCode(product.getCode());
        }
        if (Objects.nonNull(product.getDate())){
            DB.setDate(product.getDate());
        }
        if (Objects.nonNull(product.getPrice()) &&
                !"".equalsIgnoreCase(product.getPrice())){
            DB.setPrice(product.getPrice());
        }
        if (Objects.nonNull(product.getImage()) &&
                !"".equalsIgnoreCase(product.getImage())){
            DB.setImage(product.getImage());
        }
        if (Objects.nonNull(product.getQuantity())){
            DB.setQuantity(product.getQuantity());
        }
        if (Objects.nonNull(product.getDelivery_time()) &&
                !"".equalsIgnoreCase(product.getDelivery_time())){
            DB.setDelivery_time(product.getDelivery_time());
        }
            DB.setSupplier_id(supplierRepository.getSupplierByName(supplierName));


            DB.setCategory_id(categoryRepository.getCategoryByName(categoryName));


            DB.setWareHouse_id(wareHouseRepository.getWareHouseByName(wareHouseName));

        return productRepository.save(DB);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public Product updateProductQuantity(String name, Product product) {
        Product DB= productRepository.getProductByName(name);
        if (Objects.nonNull(product.getQuantity())){
            DB.setQuantity(product.getQuantity());
        }
        return productRepository.save(DB);
    }
}
