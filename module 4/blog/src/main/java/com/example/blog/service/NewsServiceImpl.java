package com.example.blog.service;

import com.example.blog.model.News;
import com.example.blog.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> selectAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News findNewsById(int id) {
        return newsRepository.getById(id);
    }

    @Override
    public void saveNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void removeNews(News news) {
        newsRepository.delete(news);
    }

    @Override
    public List<News> findByHeaderContaining(String value) {
        return newsRepository.findByHeaderContaining(value);
    }
}