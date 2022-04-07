package com.example.caysotudi.service;

import com.example.caysotudi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> selectAllCustomer(Pageable pageable);
    void saveCustomer(Customer customer);
    Customer findCustomerById(int customerId);
    void deleteCustomer(int customerId);
    Page<Customer> findByCustomerNameContainingAndCustomerPhoneContaining(Pageable pageable, String questiontitle, String questionType);
    Page<Customer> findByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(Pageable pageable,String questiontitle, String questionType, Optional<Integer> questionTypeId);
    List<Customer> selectAllCustomer();
}