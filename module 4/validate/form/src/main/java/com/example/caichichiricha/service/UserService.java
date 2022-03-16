package com.example.caichichiricha.service;

import com.example.caichichiricha.model.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();
    void saveUser(User user);
    User findByAge(int age);
}
