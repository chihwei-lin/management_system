package com.example.user_management_system.service;

import com.example.user_management_system.dao.DepartmentDao;
import com.example.user_management_system.dao.EmployeeDao;
import com.example.user_management_system.entity.Department;
import com.example.user_management_system.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    public List<Employee> findAll(){
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
        Department department = employee.getDepartment();
        if(department != null && department.getName() == null)
            employee.setDepartment(departmentDao.getOne(department.getId()));
        employeeDao.save(employee);
    }

    public Optional<Employee>  findById(Integer id){
        return employeeDao.findById(id);
    }

    public void deleteById(Integer id){
        List<Department> departments = departmentDao.findByLeadingOfficial(employeeDao.getOne(id));
        List<Employee> employees = employeeDao.findAll();

//        System.out.println(departments.get(0).toString());
        System.out.println(id);
        System.out.println(employeeDao.getOne(id).toString());

        for(Department department : departments){
            if(department.getLeading_official().getId() == id)
                department.setLeading_official(employees.get(0));
        }

//        System.out.println(departments.toString());

        departmentDao.saveAll(departments);
        employeeDao.deleteById(id);
    }
}
