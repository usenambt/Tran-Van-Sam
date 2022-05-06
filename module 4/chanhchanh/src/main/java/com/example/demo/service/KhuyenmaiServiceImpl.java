package com.example.demo.service;

import com.example.demo.model.Khuyenmai;
import com.example.demo.repository.KhuyenmaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KhuyenmaiServiceImpl implements KhuyenmaiService {

    @Autowired
    private KhuyenmaiRepository khuyenmaiRepository;


    @Override
    public void saveKhuyenmai(Khuyenmai khuyenmai) {

        khuyenmaiRepository.save(khuyenmai);
    }

    @Override
    public Khuyenmai findKhuyenmaiById(int khuyenmaiId) {
        return khuyenmaiRepository.findById(khuyenmaiId).orElse(null);
    }

    @Override
    public void deleteKhuyenmai(int khuyenmaiId) {
        Khuyenmai khuyenmai = this.khuyenmaiRepository.findById(khuyenmaiId).orElse(null);
        if (khuyenmai != null) {
            khuyenmaiRepository.delete(khuyenmai);
        }
    }

    @Override
    public List<Khuyenmai> selectAllKhuyenmai() {
        return khuyenmaiRepository.findAll();
    }

    @Override
    public List<Khuyenmai> findAllByBatDauKetThucGiamGia(LocalDate batdau,String ketthuc,String giamgia) {
        return this.khuyenmaiRepository.findAllByBatDauKetThucGiamGia(batdau, ketthuc,giamgia);
    }

    @Override
    public List<Khuyenmai> findByColumnDateBetween(LocalDate to, LocalDate from) {
        return null;
    }
//    @Override
//    public List<Khuyenmai> findByColumnDateBetween(LocalDate to, LocalDate from){
//        return khuyenmaiRepository.findByColumnDateBetween(to,from);
//    };


}

