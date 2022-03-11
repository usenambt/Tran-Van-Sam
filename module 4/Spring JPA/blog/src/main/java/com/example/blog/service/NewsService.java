package com.example.blog.service;

import com.example.blog.model.News;

import java.util.List;

public interface NewsService {
    List<News> selectAllNews();
    News findNewsById(int id);
    void saveNews(News news);
    void removeNews(News news);
    List<News> findByHeaderContaining(String value);
}