package com.example.caysotudi.repository;

import com.example.caysotudi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findByCustomerNameContainingAndCustomerPhoneContaining(Pageable pageable, String namecustomer, String phonecustomer);
    Page<Customer> findByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(Pageable pageable, String namecustomer, String phonecustomer, Optional<Integer> idcustomertype);
}
