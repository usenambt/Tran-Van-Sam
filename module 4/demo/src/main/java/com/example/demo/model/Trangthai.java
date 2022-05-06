package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Trangthai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trangthaiId;
    private String trangthaiName;

    @OneToMany(mappedBy = "trangthai")
    List<Question> questionList;

    public Trangthai() {
    }

    public Trangthai(int trangthaiId, String trangthaiName, List<Question> questionList) {
        this.trangthaiId = trangthaiId;
        this.trangthaiName = trangthaiName;
        this.questionList = questionList;
    }

    public int getTrangthaiId() {
        return trangthaiId;
    }

    public void setTrangthaiId(int trangthaiId) {
        this.trangthaiId = trangthaiId;
    }

    public String getTrangthaiName() {
        return trangthaiName;
    }

    public void setTrangthaiName(String trangthaiName) {
        this.trangthaiName = trangthaiName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}

