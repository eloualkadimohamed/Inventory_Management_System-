package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    @Query(
            value = "SELECT * FROM costumer s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Costumer> getCostumerWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Query(
            value = "SELECT * FROM costumer s where s.name = :name",
            nativeQuery = true
    )
    Costumer getCostumerByName(
            @Param("name") String name
    );
}
