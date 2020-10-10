package com.example.user_management_system.service;

import com.example.user_management_system.dao.DepartmentDao;
import com.example.user_management_system.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public List<Department> findAll(){
        return departmentDao.findAll();
    }

    public Page<Department> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return departmentDao.findAll(pageable);
    }

    public Department findById(Integer id){
        return departmentDao.getOne(id);
    }

    public void save(Department department){
        departmentDao.save(department);
    }

    public void deleteById(Integer id){
        departmentDao.deleteById(id);
    }
}
