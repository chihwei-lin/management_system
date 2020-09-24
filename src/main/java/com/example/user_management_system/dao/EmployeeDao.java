package com.example.user_management_system.dao;

import com.example.user_management_system.model.Department;
import com.example.user_management_system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> employees;

    static{
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "employee01@example.com", "小敏", "陈", 24, new Department(1, "人事")));
        employees.put(2, new Employee(2, "employee02@example.com", "丹", "黄", 34, new Department(2, "开发")));
        employees.put(3, new Employee(3, "employee03@example.com", "大明", "林", 40, new Department(3, "管理")));
        employees.put(4, new Employee(4, "employee04@example.com", "Peter", "Pan", 37, new Department(4, "战略投资")));
    }

    private static Integer initId = 5;

    public void save(Employee employee){
        if(employees.get(employee.getId())== null)
            employee.setId(initId++);

        System.out.println(employee.toString());

        // 透过 dao 层
        Department department = departmentDao.getDepartment(employee.getDepartment().getId());
        employee.setDepartment(department);

        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployee(Integer id){ return employees.get(id); }
}
