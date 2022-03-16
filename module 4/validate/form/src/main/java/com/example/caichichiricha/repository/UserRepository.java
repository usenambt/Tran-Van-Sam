package com.example.caichichiricha.repository;

import com.example.caichichiricha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByAge(int age);
}
