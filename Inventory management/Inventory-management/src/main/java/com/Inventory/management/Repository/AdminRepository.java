package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query(
            value = "SELECT * FROM admin s where s.company = :company",
            nativeQuery = true
    )
    Admin getAdminByCompany(
            @Param("company") String company);
    @Query(
            value = "SELECT * FROM admin s where s.email = :email AND s.password = :password",
            nativeQuery = true
    )

    Admin findByEmailAndPassword(
    @Param("email") String email,@Param("password") String password);
    @Query(
            value = "SELECT * FROM admin s where s.email = :email ",
            nativeQuery = true
    )
    Admin findByEmail(
            @Param("email") String email);
    @Query(
            value = "SELECT * FROM admin s where s.active = 'true' ",
            nativeQuery = true
    )
    Admin getActiveAdmin();
}
