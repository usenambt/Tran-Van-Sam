package com.example.caysotudi.service;

import com.example.caysotudi.repository.CustomerTypeRepository;
import com.example.caysotudi.model.CustomerType;
import com.example.caysotudi.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> selectAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}

