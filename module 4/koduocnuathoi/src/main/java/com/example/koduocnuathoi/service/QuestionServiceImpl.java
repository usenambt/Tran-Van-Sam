package com.example.koduocnuathoi.service;


import com.example.koduocnuathoi.model.Question;
import com.example.koduocnuathoi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Page<Question> selectAllQuestion(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findQuestionById(int questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public void deleteQuestion(int questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        questionRepository.delete(question);
    }

    @Override
    public Page<Question> findByQuestionNameContainingAndQuestionPhoneContaining( String questiontitle) {
        return questionRepository.findByQuestionNameContainingAndQuestionPhoneContaining(questiontitle);
    }

    @Override
    public Page<Question> findByQuestionNameContainingAndQuestionPhoneContainingAndQuestionType_QuestionTypeId(Pageable pageable,String questiontitle, Optional<Integer> idquestiontype) {
        return questionRepository.findByQuestionNameContainingAndQuestionPhoneContainingAndQuestionType_QuestionTypeId(pageable,questiontitle,idquestiontype);
    }

    @Override
    public List<Question> selectAllQuestion() {
        return questionRepository.findAll();
    }


    }

