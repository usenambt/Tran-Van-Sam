package com.example.demo.service;

import com.example.demo.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    List<News> selectAllNewsIndex();
    Page<News> selectAllNews(Pageable pageable);
    News findNewsById(int id);
    void saveNews(News news);
    void removeNews(News news);
    Page<News> findByHeaderContaining(String value,Pageable pageable);
    Page<News> findByCategory_Id(int categoryid,Pageable pageable);
}