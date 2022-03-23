package com.example.blogajax.repository;

import com.example.blogajax.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findByHeaderContaining(String value);
    List<News> findByCategory_Id(int categoryid);
}