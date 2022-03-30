package com.example.demo.repository;

import com.example.demo.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    Page<News> findByHeaderContaining(String value, Pageable pageable);
    Page<News> findByCategory_Id(int categoryid,Pageable pageable);
}