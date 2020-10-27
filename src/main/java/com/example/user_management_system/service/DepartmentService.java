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

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    public List<Department> findAll(){
        return departmentDao.findAll();
    }

    public Page<Department> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return departmentDao.findAll(pageable);
    }

    // 100% sure id exists in the database
    public Department getOne(Integer id){
        return departmentDao.getOne(id);
    }

    // not sure id exists in the database
    public Optional<Department> findById(Integer id){
        return departmentDao.findById(id);
    }

    public List<Department> findByLeadingOfficial(Integer employeeId){
        return departmentDao.findByLeadingOfficial(employeeDao.getOne(employeeId));
    }

    public void save(Department department){
        System.out.println(department.toString());
        Employee leadingOfficial = department.getLeading_official();
        if(leadingOfficial.getId() != null){
            Employee employee = employeeDao.getOne(leadingOfficial.getId());
            System.out.println(employee.toString());
            department.setLeading_official(employee);
            System.out.println(department.toString());

            departmentDao.save(department);
        }
        // bug：当没有 leadingOfficial 使用 save 方法时，department 会 new 一个 employee，id 会自动递增，其他 column 为空
        // 这样同时 employees 表也会新增一个新的 employee（只有 id 其他都没有）

        else
            departmentDao.customSave(department.getName(), department.getId());
    }

    public void deleteById(Integer id){
        departmentDao.deleteById(id);
    }
}
