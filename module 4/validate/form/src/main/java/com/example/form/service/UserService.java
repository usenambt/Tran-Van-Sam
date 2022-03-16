package com.example.form.service;

import com.example.form.model.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();
    void saveUser(User user);
    User findByAge(int age);
}
