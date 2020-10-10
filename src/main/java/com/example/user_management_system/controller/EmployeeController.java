package com.example.user_management_system.controller;

import com.example.user_management_system.entity.Department;
import com.example.user_management_system.entity.Employee;
import com.example.user_management_system.service.DepartmentService;
import com.example.user_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeService.findAll();
        System.out.println(employees);
        model.addAttribute("employees", employees);

        return "employees/list";
    }

    @GetMapping("/employees/search")
    public String search(@RequestParam Integer id, Model model){
        Collection<Employee> employees = new ArrayList<>();
        employees.add(employeeService.findById(id).get());

        System.out.println(employees);

        model.addAttribute("employees", employees);

        return "employees/list";
    }

    @GetMapping("/api/employees")
    @ResponseBody
    public Collection<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employee")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentService.findAll();

        model.addAttribute("departments", departments);
        model.addAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        return "employees/add";
    }

    // 直接设置入参为 Employee 类，SpringMVC 会自动配置入参参数为 Employee 类
    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeService.save(employee);

        // 来到员工列表页面
        // redirect: 重新定向到一个地址
        // forward: 转发到一个地址
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee.get());

        Collection<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        // 修改和添加使用同一页面
        return "employees/add";
    }

    @PutMapping("/employee")
    public String editEmployee(Employee employee){
        employeeService.save(employee);

        return "redirect:/employees";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
