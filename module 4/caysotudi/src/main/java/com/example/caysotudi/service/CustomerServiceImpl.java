package com.example.caysotudi.service;


import com.example.caysotudi.repository.CustomerRepository;
import com.example.caysotudi.model.Customer;
import com.example.caysotudi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> selectAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findByCustomerNameContainingAndCustomerPhoneContaining(Pageable pageable, String namecustomer, String phonecustomer) {
        return customerRepository.findByCustomerNameContainingAndCustomerPhoneContaining(pageable,namecustomer,phonecustomer);
    }

    @Override
    public Page<Customer> findByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(Pageable pageable,String namecustomer, String phonecustomer, Optional<Integer> idcustomertype) {
        return customerRepository.findByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(pageable,namecustomer,phonecustomer,idcustomertype);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.findAll();
    }
}
