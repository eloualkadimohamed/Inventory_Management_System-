package com.Inventory.management.Repository;

import com.Inventory.management.Entity.Notification;
import com.Inventory.management.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query(
            value = "SELECT * FROM notification s where s.admin_id = :admin_id",
            nativeQuery = true
    )
    List<Notification> getNotificationWithAdminIdNativeNamedParam(
            @Param("admin_id") String admin_id
    );
}
