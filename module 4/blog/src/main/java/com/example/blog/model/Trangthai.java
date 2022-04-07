package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "trangthai")
public class Trangthai{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrangthai;
    @Column(name = "name")
    private String nameTrangthai;
    @OneToMany(mappedBy = "trangthai")
    List<News> newsList;

    public Trangthai() {
    }

    public Trangthai(int idTrangthai, String nameTrangthai, List<News> newsList) {
        this.idTrangthai = idTrangthai;
        this.nameTrangthai = nameTrangthai;
        this.newsList = newsList;
    }

    public int getIdTrangthai() {
        return idTrangthai;
    }

    public void setIdTrangthai(int idTrangthai) {
        this.idTrangthai = idTrangthai;
    }

    public String getNameTrangthai() {
        return nameTrangthai;
    }

    public void setNameTrangthai(String nameTrangthai) {
        this.nameTrangthai = nameTrangthai;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}