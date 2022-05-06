package com.example.caysotudi.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @NotBlank
    @Size(min = 5,max = 45)
    private String customerName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate customerBirthday;
    @NotBlank
    @Min(value = 100000000)
    @Max(value =999999999)
    private String customerIdCard;

    private String customerPhone;

    @NotBlank
    @Email
    private String customerEmail;

    @NotBlank
    @Size(min = 5,max = 45)
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId")
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String customerPhone = customer.getCustomerPhone();
        if (customerPhone.length() > 11 || customerPhone.length() < 10) {
            errors.rejectValue("customerPhone", null, "length of phonenumber failed");
        }
        if (!customerPhone.startsWith("0")) {
            errors.rejectValue("customerPhone", null, "phonenumber start with 0");
        }
        if (!customerPhone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("customerPhone", null, "phonenumber only contains number");
        }
    }
}