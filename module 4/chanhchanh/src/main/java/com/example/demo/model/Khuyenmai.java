package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class Khuyenmai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int khuyenmaiId;

    @NotBlank
    @Size(min = 5, max = 50)
    private String khuyenmaiTen;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate khuyenmaiKetthuc;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate khuyenmaiBatdau;

    @NotBlank
    @Min(10000)
    private String khuyenmaiGiamGia;

    @NotBlank
    @Size(min = 5, max = 50)
    private String khuyenmaiChiTiet;


    public Khuyenmai() {
    }

    public Khuyenmai(int khuyenmaiId, @NotBlank @Size(min = 5, max = 50) String khuyenmaiTen, LocalDate khuyenmaiKetthuc, LocalDate khuyenmaiBatdau, @NotBlank @Min(10000) String khuyenmaiGiamGia, @NotBlank @Size(min = 5, max = 50) String khuyenmaiChiTiet) {
        this.khuyenmaiId = khuyenmaiId;
        this.khuyenmaiTen = khuyenmaiTen;
        this.khuyenmaiKetthuc = khuyenmaiKetthuc;
        this.khuyenmaiBatdau = khuyenmaiBatdau;
        this.khuyenmaiGiamGia = khuyenmaiGiamGia;
        this.khuyenmaiChiTiet = khuyenmaiChiTiet;
    }

    public int getKhuyenmaiId() {
        return khuyenmaiId;
    }

    public void setKhuyenmaiId(int khuyenmaiId) {
        this.khuyenmaiId = khuyenmaiId;
    }

    public String getKhuyenmaiTen() {
        return khuyenmaiTen;
    }

    public void setKhuyenmaiTen(String khuyenmaiTen) {
        this.khuyenmaiTen = khuyenmaiTen;
    }

    public LocalDate getKhuyenmaiKetthuc() {
        return khuyenmaiKetthuc;
    }

    public void setKhuyenmaiKetthuc(LocalDate khuyenmaiKetthuc) {
        this.khuyenmaiKetthuc = khuyenmaiKetthuc;
    }

    public LocalDate getKhuyenmaiBatdau() {
        return khuyenmaiBatdau;
    }

    public void setKhuyenmaiBatdau(LocalDate khuyenmaiBatdau) {
        this.khuyenmaiBatdau = khuyenmaiBatdau;
    }

    public String getKhuyenmaiGiamGia() {
        return khuyenmaiGiamGia;
    }

    public void setKhuyenmaiGiamGia(String khuyenmaiGiamGia) {
        this.khuyenmaiGiamGia = khuyenmaiGiamGia;
    }

    public String getKhuyenmaiChiTiet() {
        return khuyenmaiChiTiet;
    }

    public void setKhuyenmaiChiTiet(String khuyenmaiChiTiet) {
        this.khuyenmaiChiTiet = khuyenmaiChiTiet;
    }
}