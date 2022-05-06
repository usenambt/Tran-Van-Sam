package com.example.demo.service;

import com.example.demo.model.Khuyenmai;

import java.time.LocalDate;
import java.util.List;

public interface KhuyenmaiService {
    void saveKhuyenmai(Khuyenmai khuyenmai);

    Khuyenmai findKhuyenmaiById(int khuyenmaiId);

    void deleteKhuyenmai(int khuyenmaiId);

    List<Khuyenmai> selectAllKhuyenmai();

    List<Khuyenmai> findAllByBatDauKetThucGiamGia(LocalDate batdau,String ketthuc,String giamgia);
    List<Khuyenmai> findByColumnDateBetween(LocalDate to, LocalDate from);

}