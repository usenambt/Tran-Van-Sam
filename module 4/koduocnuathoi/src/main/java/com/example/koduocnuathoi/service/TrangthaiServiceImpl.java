package com.example.koduocnuathoi.service;


import com.example.koduocnuathoi.model.Trangthai;
import com.example.koduocnuathoi.repository.TrangthaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrangthaiServiceImpl implements TrangthaiService {
    @Autowired
    private TrangthaiRepository trangthaiRepository;

    @Override
    public List<Trangthai> selectAllTrangthai() {
        return trangthaiRepository.findAll();
    }
}
