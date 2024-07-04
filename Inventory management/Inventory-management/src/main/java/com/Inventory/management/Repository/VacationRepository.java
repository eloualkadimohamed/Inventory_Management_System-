package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation,Long> {
    @Query(
            value = "SELECT * FROM vacation s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Vacation> getVacationWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
}
