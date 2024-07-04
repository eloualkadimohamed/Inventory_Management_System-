package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(
            value = "SELECT * FROM category s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Category> getCategoryWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Query(
            value = "SELECT * FROM category s where s.name = :name",
            nativeQuery = true
    )
    Category getCategoryByName(
            @Param("name") String name);
}
