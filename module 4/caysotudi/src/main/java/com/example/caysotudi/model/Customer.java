package com.example.caysotudi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate customerBirthday;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId",referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @ManyToOne
    @JoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;

    @OneToMany(mappedBy = "customer")
    List<Contract> contractList;

    public Customer() {
    }

    public Customer(int customerId, String customerName, LocalDate customerBirthday, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType, Gender gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.gender = gender;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(LocalDate customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}