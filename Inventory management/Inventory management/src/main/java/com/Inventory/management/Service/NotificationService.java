package com.Inventory.management.Service;

import com.Inventory.management.Entity.Notification;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private AdminRepository adminRepository;
    public Notification saveNotification(Notification notification, String admin_id) {
        notification.setAdmin_id(adminRepository.getAdminByCompany(admin_id));
        return notificationRepository.save(notification);
    }

    public List<Notification> fetchdata(String adminId) {
        return notificationRepository.getNotificationWithAdminIdNativeNamedParam(adminId);
    }
}
