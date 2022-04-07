package com.example.koduocnuathoi.service;

import com.example.koduocnuathoi.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Page<Question> selectAllQuestion(Pageable pageable);
    void saveQuestion(Question question);
    Question findQuestionById(int questionId);
    void deleteQuestion(int questionId);
    Page<Question> findByQuestionNameContainingAndQuestionPhoneContaining(String questiontitle);
    Page<Question> findByQuestionNameContainingAndQuestionPhoneContainingAndQuestionType_QuestionTypeId(Pageable pageable,String questiontitle,  Optional<Integer> questionTypeId);
    List<Question> selectAllQuestion();
}