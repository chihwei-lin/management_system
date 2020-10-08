package com.example.user_management_system.api;

import com.example.user_management_system.model.Employee;
import com.example.user_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeApiController {
    @Autowired
    EmployeeService employeeService;

   
}
