package com.example.koduocnuathoi.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String questionTitle;
    private String questionContent;
    private String questionAnswer;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate questionCreateDate;


    @ManyToOne
    @JoinColumn(name = "questionTypeId", referencedColumnName = "questionTypeId")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "trangthaiId", referencedColumnName = "trangthaiId")
    private Trangthai trangthai;


    public Question() {
    }

    public Question(int questionId, String questionTitle, String questionContent, String questionAnswer, LocalDate questionCreateDate, QuestionType questionType, Trangthai trangthai) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionAnswer = questionAnswer;
        this.questionCreateDate = questionCreateDate;
        this.questionType = questionType;
        this.trangthai = trangthai;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public LocalDate getQuestionCreateDate() {
        return questionCreateDate;
    }

    public void setQuestionCreateDate(LocalDate questionCreateDate) {
        this.questionCreateDate = questionCreateDate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Trangthai getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Trangthai trangthai) {
        this.trangthai = trangthai;
    }
}