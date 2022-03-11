package com.codegym.demo.service.impl;

import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.CustomerRepository;
import com.codegym.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerById(Long id) {
      return   customerRepository.findById(id).orElse(null);
    }
}
