package com.example.user_management_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    // 因为是单向（由 Employee 连接到 Department）
    // 在 Employee 添加
//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;

    public Department(){
        this.id = null;
        this.name = null;
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(Integer id, String name){
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
