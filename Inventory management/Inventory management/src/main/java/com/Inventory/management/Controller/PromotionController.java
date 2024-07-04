package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Promotion;
import com.Inventory.management.Service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    @PostMapping("/promotion")
    public Promotion savePromotion(@RequestBody Promotion promotion){
        return promotionService.savePromotion(promotion);
    }


}
