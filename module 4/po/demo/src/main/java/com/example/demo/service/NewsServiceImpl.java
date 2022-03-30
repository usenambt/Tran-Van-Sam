package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
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
    public Page<News> selectAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
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
    public Page<News> findByHeaderContaining(String value,Pageable pageable) {
        return newsRepository.findByHeaderContaining(value,pageable);
    }

    @Override
    public Page<News> findByCategory_Id(int categoryid, Pageable pageable) {
        return newsRepository.findByCategory_Id(categoryid, pageable);
    }
}


