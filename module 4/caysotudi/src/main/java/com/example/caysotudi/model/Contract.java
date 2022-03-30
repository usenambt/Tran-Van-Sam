package com.example.caysotudi.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
public class Contract implements Validator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int contractId;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate contractStartDate;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetailList;
//
//    @ManyToOne
//    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId")
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "serviceId",referencedColumnName = "serviceId")
    private Service service;

    public Contract() {
    }

    public Contract(int contractId, LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit, double contractTotalMoney, List<ContractDetail> contractDetailList, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.contractDetailList = contractDetailList;
//        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        LocalDate contractStartDate=contract.getContractStartDate();
        LocalDate contractEndDate=contract.getContractEndDate();
        if (contractStartDate!=null && contractEndDate!=null){
            if (contractStartDate.isAfter(contractEndDate)){
                errors.rejectValue("contractEndDate",null,"Enddate before StartDay");
            }
            if(ChronoUnit.DAYS.between(contractStartDate, contractEndDate)>10){
                errors.rejectValue("contractEndDate",null,"Thue qua dai ngay");
            }
            if(contractStartDate.isBefore(LocalDate.now())){
                errors.rejectValue("contractStartDate",null,"Startdate is not past");
            }
        }
//        if(contract.getEmployee()==null){
//            errors.rejectValue("employee",null,"must not be null");
//        }
        if(contract.getService()==null){
            errors.rejectValue("service",null,"must not be null");
        }
        if(contract.getCustomer()==null){
            errors.rejectValue("customer",null,"must not be null");
        }

    }
}