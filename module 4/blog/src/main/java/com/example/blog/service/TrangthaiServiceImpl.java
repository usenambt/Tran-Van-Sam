package com.example.blog.service;

import com.example.blog.model.Trangthai;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TrangthaiRepository;

import java.util.List;

public class TrangthaiServiceImpl implements TrangthaiService{
    @Autowired
    private TrangthaiRepository trangthaiRepository;
    @Override
    public List<Trangthai> selectAllTrangthai() {
        return trangthaiRepository.findAll();
    }
}
