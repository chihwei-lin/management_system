package com.example.user_management_system.dao;

import com.example.user_management_system.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments;

    static{
        departments = new HashMap<>();

        departments.put(1, new Department(1, "人事"));
        departments.put(2, new Department(2, "开发"));
        departments.put(3, new Department(3, "管理"));
        departments.put(4, new Department(4, "战略投资"));
    }

    public Collection<Department> getAll(){ return departments.values(); }

    public Department getDepartment(Integer id){ return departments.get(id); }
}