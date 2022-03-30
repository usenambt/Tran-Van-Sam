package com.example.caysotudi.repository;

import com.example.caysotudi.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}