package com.example.khuyenmai.service;

import com.example.khuyenmai.repository.PromotionRepository;
import com.example.khuyenmai.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    @Override
    public List<Promotion> selectAllPromotion() {
        return promotionRepository.findAll();
    }

    @Override
    public void savePromotion(Promotion promotion) {

        this.promotionRepository.save(promotion);
    }

    @Override
    public Promotion findPromotionById(int id) {
        return this.promotionRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePromotion(Promotion promotion) {
        this.promotionRepository.delete(promotion);
    }

    @Override
    public List<Promotion> searchPromotion(String timestart, String timeend) {
        return promotionRepository.searchPromotion(timestart,timeend);
    }
}