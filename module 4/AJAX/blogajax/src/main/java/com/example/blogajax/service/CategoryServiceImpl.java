package com.example.blogajax.service;

import com.example.blogajax.model.Category;
import com.example.blogajax.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> selectAllCategory() {
        return categoryRepository.findAll();
    }
}
