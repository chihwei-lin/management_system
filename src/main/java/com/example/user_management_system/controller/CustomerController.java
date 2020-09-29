package com.example.user_management_system.controller;

import com.example.user_management_system.dao.CustomerDao;
import com.example.user_management_system.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    @GetMapping("/customers")
    public String toListPage(Model model){

        Collection<Customer> customers = customerDao.getAll();
        model.addAttribute("customers", customers);

        return "customers/list";
    }
}
