package com.example.user_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="leading_official")
    private Employee leading_official;

    // 因为是单向（由 Employee 连接到 Department）
    // 在 Employee 添加
//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;

    public Department(){
    }

    public Department(Integer id, String name, Employee leading_official) {
        this.id = id;
        this.name = name;
        this.leading_official = leading_official;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeading_official() {
        return leading_official;
    }

    public void setLeading_official(Employee leading_official) {
        this.leading_official = leading_official;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leading_official='" + leading_official.getName() + '\'' +
                '}';
    }
}
