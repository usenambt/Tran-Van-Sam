package com.example.caysotudi.service;


import com.example.caysotudi.repository.GenderRepository;
import com.example.caysotudi.model.Gender;
import com.example.caysotudi.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> selectAllGender() {
        return genderRepository.findAll();
    }
}
