package com.example.khuyenmai.repository;

import com.example.khuyenmai.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    @Query(value = "select * from promotion where (timeStart between ?1 and ?2)", nativeQuery = true)
    List<Promotion> searchPromotion(String timestart, String timeend);
}