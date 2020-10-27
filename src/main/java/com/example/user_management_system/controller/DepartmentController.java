package com.example.user_management_system.controller;

import com.example.user_management_system.entity.Department;
import com.example.user_management_system.entity.Employee;
import com.example.user_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public String list(@RequestParam(defaultValue = "0") Integer page, Model model){
        //Collection<Employee> employees = employeeService.findAll();
        Page<Department> departmentPages = departmentService.findAll(page, 10);
        model.addAttribute("departmentPages", departmentPages);

        return "departments/list";
    }

    @GetMapping("/departments/search")
    public String search(@RequestParam("id") Integer id, Model model){
        Optional<Department> department = departmentService.findById(id);

        if(department.isEmpty()){
            model.addAttribute("errorMessage", "该部门不存在");

            Page<Department> departmentPages = departmentService.findAll(0, 10);
            model.addAttribute("departmentPages", departmentPages);

            return "departments/list";
        }
        model.addAttribute("department", department.get());

        return "departments/add";
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
        Department department = departmentService.getOne(id);
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
