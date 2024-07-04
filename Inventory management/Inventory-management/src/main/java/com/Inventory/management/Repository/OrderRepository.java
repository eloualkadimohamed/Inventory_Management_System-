package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Orders;
import com.Inventory.management.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query(
            value = "SELECT * FROM orders s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Orders> getOrderWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Modifying
    @Transactional
    @Query(
            value = "Delete FROM orders s where s.product_id = :product_id",
            nativeQuery = true
    )
    void deleteOrderByProductId(
            @Param("product_id") Long product_id
    );
}
