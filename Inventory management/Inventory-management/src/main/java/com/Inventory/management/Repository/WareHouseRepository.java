package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Supplier;
import com.Inventory.management.Entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
    @Query(
            value = "SELECT * FROM ware_house s where s.name = :name",
            nativeQuery = true
    )
    WareHouse getWareHouseByName(
            @Param("name") String name);
    @Query(
            value = "SELECT * FROM ware_house s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<WareHouse> getWareHouseWithAdminIdNativeNamedParam(
            @Param("admin_id") String adminId);
}
