package com.example.demo.service;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    void saveQuestion(Question question);

    Question findQuestionById(int questionId);

    void deleteQuestion(int questionId);

    Page<Question> selectAllQuestion(Pageable pageable);

    Page<Question> findAllByTitleAndType(String title, Integer typeId, Pageable pageable);

}