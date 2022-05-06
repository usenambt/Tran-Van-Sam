package com.example.demo.service;

import com.example.demo.model.Trangthai;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.model.Question;
import com.example.demo.repository.TrangthaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    private TrangthaiRepository trangthaiRepository;

    @Override
    public void saveQuestion(Question question) {
        LocalDate now = LocalDate.now();
        question.setQuestionCreateDate(now);

        Trangthai trangthai = this.trangthaiRepository.getById(1);
        question.setTrangthai(trangthai);

//        question.setQuestionAnswer("Bạn xem demo tại link sau đây:example.com");

        questionRepository.save(question);
    }

    @Override
    public Question findQuestionById(int questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public void deleteQuestion(int questionId) {
        Question question = this.questionRepository.findById(questionId).orElse(null);
        if (question != null) {
            questionRepository.delete(question);
        }
    }

    @Override
    public Page<Question> selectAllQuestion(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findAllByTitleAndType(String title, Integer typeId, Pageable pageable) {
//        return this.questionRepository.findAllByTitleAndType(title, typeId,pageable);
        return null;
    }


}

