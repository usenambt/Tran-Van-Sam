package com.example.caysotudi.service;

import com.example.caysotudi.repository.CustomerTypeRepository;
import com.example.caysotudi.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> selectAllCustomerType();
}
