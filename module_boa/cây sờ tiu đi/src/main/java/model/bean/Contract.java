package model;

public class Contract {
    private int contractId;
    private Customer customer;
    private Service service;
    private Employee employee;
    private String beginDate;
    private String finishDate;
    private int firstPayment;
    private int totalPayment;

    public Contract(int contractId, Customer customer, Service service, Employee employee, String beginDate, String finishDate, int firstPayment, int totalPayment) {
        this.contractId = contractId;
        this.customer = customer;
        this.service = service;
        this.employee = employee;
        this.beginDate = beginDate;
        this.finishDate = finishDate;
        this.firstPayment = firstPayment;
        this.totalPayment = totalPayment;
    }

    public Contract(Customer customer, Service service, Employee employee, String beginDate, String finishDate, int firstPayment, int totalPayment) {
        this.customer = customer;
        this.service = service;
        this.employee = employee;
        this.beginDate = beginDate;
        this.finishDate = finishDate;
        this.firstPayment = firstPayment;
        this.totalPayment = totalPayment;
    }

    public Contract(int contractId, Customer customer) {
        this.contractId = contractId;
        this.customer = customer;
    }

    public Contract(int contractId) {
        this.contractId = contractId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(int firstPayment) {
        this.firstPayment = firstPayment;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", customer=" + customer +
                ", service=" + service +
                ", employee=" + employee +
                ", beginDate='" + beginDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", firstPayment=" + firstPayment +
                ", totalPayment=" + totalPayment +
                '}';
    }
}