package com.example.blogajax.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity (name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "header", columnDefinition = "TEXT")
    private String header;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @Column(name="createdate")
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name="categoryid",referencedColumnName = "id")
    private Category category;

    public News() {
    }

    public News(int id, String header, String content, LocalDateTime createDate, Category category) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.createDate = createDate;
        this.category = category;
    }

    public News(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public News(int id, String header, String content) {
        this.id = id;
        this.header = header;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public News(int id, String header, String synopsis, String content, LocalDateTime createDate, Category category) {
        this.id = id;
        this.header = header;
        this.synopsis = synopsis;
        this.content = content;
        this.createDate = createDate;
        this.category = category;
    }
}