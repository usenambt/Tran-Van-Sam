package com.example.demo.service;

import com.example.demo.model.QuestionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionTypeService {
    List<QuestionType> selectAllQuestionType();
}
