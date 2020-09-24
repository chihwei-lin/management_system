package com.example.user_management_system.controller;

import com.example.user_management_system.dao.DepartmentDao;
import com.example.user_management_system.dao.EmployeeDao;
import com.example.user_management_system.model.Department;
import com.example.user_management_system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("employees", employees);

        return "employees/list";
    }

    @GetMapping("/employee")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getAll();

        model.addAttribute("departments", departments);

        return "employees/add";
    }

    // 直接设置入参为 Employee 类，SpringMVC 会自动配置入参参数为 Employee 类
    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);

        // 来到员工列表页面
        // redirect: 重新定向到一个地址
        // forward: 转发到一个地址
        return "redirect:/employees";
    }
}
