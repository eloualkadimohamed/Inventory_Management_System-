package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Product;
import com.Inventory.management.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    @Query(
            value = "SELECT * FROM supplier s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Supplier> getSupplierWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Query(
            value = "SELECT * FROM supplier s where s.name = :name",
            nativeQuery = true
    )
    Supplier getSupplierByName(
            @Param("name") String name);
}
