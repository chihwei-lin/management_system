package com.example.user_management_system.controller;

import com.example.user_management_system.entity.Department;
import com.example.user_management_system.entity.Employee;
import com.example.user_management_system.service.DepartmentService;
import com.example.user_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/employees")
    public String list(@RequestParam(defaultValue = "0") Integer page, Model model){
        //Collection<Employee> employees = employeeService.findAll();
        Page<Employee> employeePages = employeeService.findAll(page, 10);
        model.addAttribute("employeePages", employeePages);

        return "employees/list";
    }

    @GetMapping("/employees/search")
    public String search(@RequestParam Integer id, Model model){
        Collection<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        Optional<Employee> employee = employeeService.findById(id);

        if(employee.isEmpty()){
            Page<Employee> employeePages = employeeService.findAll(0, 10);
            System.out.println(employeePages.toString());
            model.addAttribute("employeePages", employeePages);

            model.addAttribute("errorMessage", "该员工不存在");

            return "employees/list";
        }
        model.addAttribute("employee", employee.get());
        return "employees/add";
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
    public String deleteEmployee(@PathVariable("id") Integer id, Model model){
        // 解除和 Department 的绑定（department.leading_official 可能是被删除员工）
        List<Department> departments = departmentService.findByLeadingOfficial(id);

        if(departments.isEmpty()){
            employeeService.deleteById(id);
            return "redirect:/employees";
        }

        Page<Employee> employeePages = employeeService.findAll(0, 10);

        model.addAttribute("employeePages", employeePages);
        model.addAttribute("errorMessage", "删除失败：该员工为部门负责人，请先替换部门负责人");
        return "employees/list";
    }
}
