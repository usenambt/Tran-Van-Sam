package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @NotBlank
    @Size(min = 5,max = 45)
    private String questionTitle;

    @NotBlank
    @Size(min = 5,max = 45)
    private String questionContent;

    @NotBlank
    @Size(min = 5,max = 45)
    private String questionAnser;

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

    public Question(int questionId, @NotBlank @Size(min = 5, max = 45) String questionTitle, @NotBlank @Size(min = 5, max = 45) String questionContent, @NotBlank @Size(min = 5, max = 45) String questionAnser, LocalDate questionCreateDate, QuestionType questionType, Trangthai trangthai) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionAnser = questionAnser;
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

    public String getQuestionAnser() {
        return questionAnser;
    }

    public void setQuestionAnser(String questionAnser) {
        this.questionAnser = questionAnser;
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
