package com.example.demo.repository;

import com.example.demo.model.Khuyenmai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface KhuyenmaiRepository extends JpaRepository<Khuyenmai,Integer> {

    @Query("select k from Khuyenmai k where (:batdau is null  or k.khuyenmaiBatdau like %:batdau%) and (:ketthuc is null  or k.khuyenmaiBatdau like %:ketthuc%) ")
    List<Khuyenmai> findAllByBatDauKetThucGiamGia(LocalDate batdau, String ketthuc, String giamgia);

//    List<Khuyenmai> findByColumnDateBetween(LocalDate to, LocalDate from);

}

