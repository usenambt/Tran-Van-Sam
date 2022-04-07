package com.example.koduocnuathoi.service;

import com.example.koduocnuathoi.model.QuestionType;
import com.example.koduocnuathoi.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> selectAllQuestionType() {
        return questionTypeRepository.findAll();
    }
}

