package com.example.blog.repository;

import com.example.blog.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findByHeaderContaining(String value);
}