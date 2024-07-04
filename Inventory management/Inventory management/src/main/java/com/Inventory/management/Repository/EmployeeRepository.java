package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Admin;
import com.Inventory.management.Entity.Employee;
import com.Inventory.management.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(
            value = "SELECT * FROM employee s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Employee> getEmployeeWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
    @Query(
            value = "SELECT * FROM employee s where s.name = :name",
            nativeQuery = true
    )
    Employee getEmployeeByName(
            @Param("name") String name
    );
    @Query(
            value = "SELECT * FROM employee s where s.email = :email AND s.password = :password",
            nativeQuery = true
    )
    Employee getEmployeeByEmailAndPassword(
            @Param("email") String email, @Param("password") String password);
    @Query(
            value = "SELECT * FROM employee s where s.email = :email ",
            nativeQuery = true
    )
    Employee findByEmail(
            @Param("email") String email);
}
