package com.example.phonemanager.service;

import com.example.phonemanager.repository.PhoneRepository;
import com.example.phonemanager.model.Phone;
import com.example.phonemanager.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public List<Phone> selectAllPhone() {
        return phoneRepository.findAll();
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(int id) {
        Phone phone=phoneRepository.findById(id).orElse(null);
        phoneRepository.delete(phone);
    }

    @Override
    public Phone findPhoneById(int id) {
        return phoneRepository.findById(id).orElse(null);
    }
}
