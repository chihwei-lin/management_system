package com.example.user_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="address")
    private String address;

    @Column(name="salary")
    private Long salary;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @Column(name="entry_date")
    private String entry_date;

    @Column(name="resignation_date")
    private String resignation_date;


    public Employee(){

    }

    public Employee(Integer id, String email, String name, Integer age, String address, Long salary, Department department, String entry_date, String resignation_date) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.department = department;
        this.entry_date = entry_date;
        this.resignation_date = resignation_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getResignation_date() {
        return resignation_date;
    }

    public void setResignation_date(String resignation_date) {
        this.resignation_date = resignation_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", entry_date='" + entry_date + '\'' +
                ", resignation_date='" + resignation_date + '\'' +
                ", departmentId='" + department.getName() + "'" +
                '}';
    }
}
