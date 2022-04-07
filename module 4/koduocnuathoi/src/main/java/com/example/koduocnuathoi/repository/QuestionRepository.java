package com.example.koduocnuathoi.repository;

import com.example.koduocnuathoi.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Page<Question> findByQuestionNameContainingAndQuestionPhoneContaining(String questiontitle);
    Page<Question> findByQuestionNameContainingAndQuestionPhoneContainingAndQuestionType_QuestionTypeId(Pageable pageable, String questiontitle, Optional<Integer> idquestiontype);
}
