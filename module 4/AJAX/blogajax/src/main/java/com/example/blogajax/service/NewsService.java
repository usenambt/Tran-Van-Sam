package com.example.blogajax.service;

import com.example.blogajax.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    List<News> selectAllNewsIndex();
    List<News> selectAllNews();
    News findNewsById(int id);
    void saveNews(News news);
    void removeNews(News news);
    List<News> findByHeaderContaining(String value);
    List<News> findByCategory_Id(int categoryid);
}
