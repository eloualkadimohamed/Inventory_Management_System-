package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Notification;
import com.Inventory.management.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @PostMapping("/api/notification/{admin_id}")
    public Notification saveNotification(@PathVariable("admin_id") String admin_id, @RequestBody Notification notification){
        return notificationService.saveNotification(notification,admin_id);
    }
    @GetMapping("/api/notifications/{admin_id}")
    public List<Notification> fetchData(@PathVariable("admin_id") String admin_id){
        return notificationService.fetchdata(admin_id);
    }
}
