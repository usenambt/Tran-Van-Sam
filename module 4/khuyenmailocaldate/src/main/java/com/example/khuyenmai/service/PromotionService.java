package com.example.khuyenmai.service;

import com.example.khuyenmai.model.Promotion;

import java.util.List;

public interface PromotionService {
    List<Promotion> selectAllPromotion();
    void savePromotion(Promotion promotion);
    Promotion findPromotionById(int id);
    void deletePromotion(Promotion promotion);
    List<Promotion> searchPromotion(String timestart, String timeend);
}