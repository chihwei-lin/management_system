package com.example.user_management_system.controller;

import com.example.user_management_system.entity.Department;
import com.example.user_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public String list(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        return "departments/list";
    }

    @GetMapping("/department")
    public String toAddPage(){
        return "departments/add";
    }

    @PostMapping("/department")
    public String addDepartment(Department department){
        departmentService.save(department);

        return "redirect:/departments";
    }

    @GetMapping("/department/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);

        return "departments/add";
    }

    @PutMapping("/department")
    public String editDepartment(Department department){
        departmentService.save(department);

        return "redirect:/departments";
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        departmentService.deleteById(id);

        return "redirect:/departments";
    }
}
