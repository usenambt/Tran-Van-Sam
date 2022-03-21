package com.example.phonemanager.service;

import com.example.phonemanager.model.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhoneService {
    List<Phone> selectAllPhone();
    void savePhone(Phone phone);
    void deletePhone(int id);
    Phone findPhoneById(int id);
}