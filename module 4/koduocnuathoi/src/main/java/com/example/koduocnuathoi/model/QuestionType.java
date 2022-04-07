package com.example.koduocnuathoi.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionTypeId;
    private String questionTypeName;
    @OneToMany(mappedBy = "questionType")
    List<Question> questionList;

    public QuestionType() {
    }

    public QuestionType(int questionTypeId, String questionTypeName, List<Question> questionList) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
        this.questionList = questionList;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
