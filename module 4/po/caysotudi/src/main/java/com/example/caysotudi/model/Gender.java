package com.example.caysotudi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    private String genderName;

    @OneToMany(mappedBy = "gender")
    List<Customer> customerList;

    public Gender() {
    }

    public Gender(int genderId, String genderName, List<Customer> customerList) {
        this.genderId = genderId;
        this.genderName = genderName;
        this.customerList = customerList;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}