package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(
            value = "SELECT * FROM product s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Product> getProductWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Query(
            value = "SELECT * FROM product s where s.name = :name",
            nativeQuery = true
    )
    Product getProductByName(
            @Param("name") String name);
}
