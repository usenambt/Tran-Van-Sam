package com.example.demo.service;


import com.example.demo.model.Trangthai;
import com.example.demo.repository.TrangthaiRepository;
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
