package com.example.phonemanager.repository;

import com.example.phonemanager.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}