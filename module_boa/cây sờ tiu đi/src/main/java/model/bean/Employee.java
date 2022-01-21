package model;

public class Employee {
    private int employeeId;
    private String name;
    private String birthday;
    private int cardId;
    private int phoneNumber;
    private String email;
    private Level level;
    private Department department;
    private Diploma diploma;
    private int salary;
    private String address;

    public Employee(int employeeId, String name, String birthday, int cardId, int phoneNumber, String email, Level level, Department department, Diploma diploma, int salary, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.department = department;
        this.diploma = diploma;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String name, String birthday, int cardId, int phoneNumber, String email, Level level, Department department, Diploma diploma, int salary, String address) {
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.department = department;
        this.diploma = diploma;
        this.salary = salary;
        this.address = address;
    }

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public void setDiploma(Diploma diploma) {
        this.diploma = diploma;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}