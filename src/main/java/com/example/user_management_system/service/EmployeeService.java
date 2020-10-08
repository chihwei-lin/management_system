package com.example.user_management_system.service;

import com.example.user_management_system.dao.DepartmentDao;
import com.example.user_management_system.dao.EmployeeDao;
import com.example.user_management_system.model.Department;
import com.example.user_management_system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    public Collection<Employee> findAll(){
        List<Employee> employees = employeeDao.findAll();
        List<Department> departments = departmentDao.findAll();

        System.out.println(employees);

        return employees;
    }

    public Page<Employee> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return employeeDao.findAll(pageable);
    }

    public void save(Employee employee){
        employeeDao.save(employee);
    }

    public Optional<Employee>  findById(Integer id){
        return employeeDao.findById(id);
    }

    public void deleteById(Integer id){
        employeeDao.deleteById(id);
    }
}
