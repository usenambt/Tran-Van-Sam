package com.example.blogajax.service;


import com.example.blogajax.model.News;
import com.example.blogajax.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> selectAllNewsIndex() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> selectAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News findNewsById(int id) {
        return newsRepository.findById(id).orElse(null);
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

    @Override
    public List<News> findByCategory_Id(int categoryid) {
        return newsRepository.findByCategory_Id(categoryid);
    }
}
