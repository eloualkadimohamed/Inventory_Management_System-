package com.Inventory.management.Service;

import com.Inventory.management.Entity.Promotion;
import com.Inventory.management.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    public Promotion savePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }
}
