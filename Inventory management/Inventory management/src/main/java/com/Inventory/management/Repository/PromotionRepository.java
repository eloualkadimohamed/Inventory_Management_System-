package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Product;
import com.Inventory.management.Entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    @Query(
            value = "SELECT * FROM promotion s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Promotion> getProductWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
}
